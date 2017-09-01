package eviction;

public interface IEviction< K> {

	K getEvictionKey();
	void setUpdateEvictionKey(K key, Long evic);
	void deleteEvictionKey(K key);
}
