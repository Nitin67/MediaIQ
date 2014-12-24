import java.util.HashMap;
import java.util.Map;


public class Trie {

	Map<Character, Object> trieRoot=new HashMap<Character, Object>();
	
	public boolean match(String str)
	{
		Map<Character, Object> mp=trieRoot;
		for(int i=0;i<str.length();i++)
		{
			if(mp.containsKey(str.charAt(i)))
			{
				mp=(Map<Character, Object> )mp.get(str.charAt(i));
			}
			else
			{
				return false;
			}
		}
		return true;
	}
	
	
	public void insert(String str)
	{
		Map<Character, Object> mp=trieRoot;
		for(int i=0;i<str.length();i++)
		{
			if(mp.containsKey(str.charAt(i)))
			{
				
				mp=(Map<Character, Object>)mp.get(str.charAt(i));
			}
			else
			{
				Map<Character, Object> newMap=new HashMap<Character, Object>();
				mp.put(str.charAt(i), newMap);
				mp=newMap;
			}
		}
		mp.put('$', null);
		
	}
	
	public static void main(String []args)
	{
		Trie trie=new Trie();
		String str="This is my pen.";
		String str2="This is your pen.";
		str=str.replace('.', ' ');
		str2=str2.replace('.', ' ');
		str=str.replace(',', ' ');
		str2=str2.replace(',', ' ');
		String []strArray=str.split("\\s+");
		String []str2Array=str2.split("\\s+");
		for(int i=0;i<strArray.length;i++)
		{
			trie.insert(strArray[i]);
		}
		int count =0;
		for(int i=0;i<str2Array.length;i++)
		{
			if(trie.match(str2Array[i]))
				count ++;
		}
		System.out.println((count*100)/strArray.length);
		
	}
	
}
