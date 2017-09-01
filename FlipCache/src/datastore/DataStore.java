package datastore;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class DataStore<K,V> implements IDataStore{

	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private HashMap<K, V> m = new HashMap<>();

	
	@Override
	public void set(Object key, Object value) {
		set(key, value, System.currentTimeMillis());
	}
	public void set(Object key, Object value, Object e){
		System.out.println("In put method waiting to acquire lock");
		rwl.writeLock().lock();
		System.out.println("In put method acquired write lock");
		try {
			m.put((K)key, (V)value);
		} finally {
			rwl.writeLock().unlock();
			System.out.println("In put method released write lock");
		}
	}

	@Override
	public void delete(Object key) {
		System.out.println("In get method waiting to acquire lock");
		rwl.readLock().lock();
		System.out.println("In get method acquired read lock");

		try {
			m.remove(key);
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
			if(m.containsKey(key)){
				return m.get(key);
			}else{
				return null;
			}
			
		} finally {
			rwl.readLock().unlock();
			System.out.println("In get method released read lock");
		}
	}
	
	public HashMap<K, V> getMap(){
		return m;
	}
}
