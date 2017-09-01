package utils;

import java.util.HashMap;

public class OperationUtil {

	public static HashMap<String, String>  map = new HashMap<String, String>();
	public static HashMap<String, String> reverseMap = new HashMap<String, String>();
	static {
		map.put("add", "+");
		map.put("divide", "/");
		map.put("multiply", "*");
		map.put("equal", "=");
		map.put("substract", "-");
		reverseMap.put("/", "*");
		reverseMap.put("*", "/");
		reverseMap.put("+", "-");
		reverseMap.put("-", "+");
	}
	
	public static String getCorrespondingOpertion(String operationName) throws Exception{
		if(map.containsKey(operationName)){
			return map.get(operationName);
		}else{
			throw new Exception("Unhandled Operation");
		}
		
	}
}
