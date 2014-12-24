import java.util.HashMap;


public class GenericMethod {

	
	public static <K,V> boolean compare(HashMap<K,V> map1,HashMap<K, V> map2)
	{
		K key= map1.keySet().iterator().next();
		K key1=map2.keySet().iterator().next();
		V value=map1.entrySet().iterator().next().getValue();
		V value1=map2.entrySet().iterator().next().getValue();
		return ((key==key1)&&(value==value1));
		
		
	}
}
