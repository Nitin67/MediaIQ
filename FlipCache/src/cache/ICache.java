package cache;

import java.io.IOException;

import Exception.CacheException;

public interface ICache<K,V> {

	public Object get(K key) throws IOException,CacheException;
	public void delete(K key) throws IOException;
	void set(K key, V value) throws IOException;
}
