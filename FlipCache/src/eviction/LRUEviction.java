package eviction;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUEviction<K> implements IEviction<K>{
	 
	LinkedList<EvictionData<K>> list = new LinkedList<>();
	HashMap<K, EvictionData<K>> map = new HashMap<>();
	
	@Override
	public K getEvictionKey() {
		if(!list.isEmpty())
			return list.getLast().key;
		return null;
	}

	@Override
	public void setUpdateEvictionKey(K key, Long evic) {
		EvictionData ed =  new EvictionData<>();
		ed.data = evic;
		ed.key = key;
		if(map.containsKey(key)){
			EvictionData<K> data = map.get(key);
			list.remove(data);
		}
		map.put(key, ed);
		list.add(0, ed);
	}

	@Override
	public void deleteEvictionKey(K key) {
		EvictionData<K> data = map.get(key);
		list.remove(data);
		map.remove(key);
	}

}
