package com.ds.map;


public class MyMap<K, V> {
	private final Integer INITIAL_SIZE = 16;
	private int size;
	private int currentMaxSize;
	@SuppressWarnings("unchecked")
	private MapEntry<K, V>[] map = new MapEntry[INITIAL_SIZE];

	public MyMap() {
		currentMaxSize = INITIAL_SIZE;
	}

	public void put(K key, V value) {
		if (size == currentMaxSize) {
			increaseCapacity();
		}
		MapEntry<K, V> mapEntry = findMapEntry(key);
		if (mapEntry == null) {
			mapEntry = new MapEntry<K, V>(key, value);
			map[size++] = mapEntry;
		}
		mapEntry.setValue(value);
	}

	public V getValue(K key) {
		MapEntry<K, V> mapEntry = findMapEntry(key);
		if (mapEntry != null) {
			return mapEntry.getValue();
		}
		return null;
	}

	public void remove(K key) {
		int i = 0;
		for (MapEntry<K, V> mapEntry : map) {
			K entryKey = mapEntry.getKey();
			if (key.equals(entryKey)) {
				removeAndShift(i);
				size--;
			}
			i++;
		}
	}

	private void removeAndShift(int i) {
		i++;
		for (; i < size; i++) {
			map[i - 1] = map[i];
		}
	}

	public MapEntry<K, V> findMapEntry(K key) {
		for (MapEntry<K, V> mapEntry : map) {
			K entryKey = mapEntry.getKey();
			if (key.equals(entryKey)) {
				return mapEntry;
			}
		}
		return null;
	}

	private void increaseCapacity() {
		currentMaxSize = currentMaxSize * 2;
		MapEntry<K, V>[] newMap = new MapEntry[currentMaxSize];
		int i = 0;
		for (MapEntry<K, V> mapEntry : map) {
			newMap[i] = mapEntry;
			i++;
		}
		map = newMap;
	}
}
