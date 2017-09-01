package cache;

import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import datastore.DataStore;
import datastore.IDataStore;
import eviction.IEviction;
import eviction.LRUEviction;

public class Cache<K, V> implements ICache<K, V> {

	int size;
	int capacity;
	IDataStore<K, V> dataStore;
	IEviction<K> eviction;

	public Cache(int capacity, IDataStore<K, V> dataStore, IEviction<K> eviction) {
		size = 0;
		this.capacity = capacity;
		this.dataStore = dataStore;
		this.eviction = eviction;
	}

	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	public void set(Object key, Object value) {
		System.out.println("In put method waiting to acquire lock");
		rwl.writeLock().lock();
		System.out.println("In put method acquired write lock");

		try {

			if (dataStore.get((K) key) != null) {
				dataStore.set((K) key, (V) value);
				eviction.setUpdateEvictionKey((K) key, System.currentTimeMillis());
			} else if (size == capacity) {
				K ky = eviction.getEvictionKey();
				dataStore.delete((K) ky);
				eviction.deleteEvictionKey((K) ky);
				dataStore.set((K) key, (V) value);
				eviction.setUpdateEvictionKey((K) key, System.currentTimeMillis());
			} else {
				dataStore.set((K) key, (V) value);
				eviction.setUpdateEvictionKey((K) key, System.currentTimeMillis());
				size++;
			}

		} finally {
			rwl.writeLock().unlock();
			System.out.println("In put method released write lock");
		}

	}

	@Override
	public void delete(Object key) {
		Object val = null;
		System.out.println("In get method waiting to acquire lock");
		rwl.readLock().lock();
		System.out.println("In get method acquired read lock");

		try {
			eviction.deleteEvictionKey((K) key);
			dataStore.delete((K) key);
		} finally {
			rwl.readLock().unlock();
			System.out.println("In get method released read lock");
		}
	}

	@Override
	public Object get(Object key) {
		System.out.println("In get method waiting to acquire lock");
		rwl.readLock().lock();
		System.out.println("In get method acquired read lock");
		try {
			eviction.setUpdateEvictionKey((K) key, System.currentTimeMillis());
			return dataStore.get((K) key);
		} finally {
			rwl.readLock().unlock();
			System.out.println("In get method released read lock");
		}
	}

	public void showData() {
		for (Map.Entry<K, V> map : ((DataStore<K, V>) dataStore).getMap().entrySet()) {
			System.out.println(map.getKey() + "====" + map.getValue());
		}
	}

	public static void main(String[] args) {
		IDataStore<Integer, Integer> dataStore = new DataStore<>();
		IEviction<Integer> eviction = new LRUEviction<>();
		Cache<Integer, Integer> cache = new Cache<>(5, dataStore, eviction);
		cache.set(2, 90002);
		cache.set(3, 90003);
		cache.set(4, 90004);
		cache.set(5, 90005);
		cache.set(6, 90006);
		cache.showData();
		cache.set(1, 90001);
		cache.showData();
		cache.set(7, 90007);
		cache.set(7, 90008);
		cache.showData();
	}

}
