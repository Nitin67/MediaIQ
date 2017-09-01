package datastore;

public interface IDataStore<K,V> {

	void set(K key, V value);
	void delete(K key);
	V get(K key);
}
