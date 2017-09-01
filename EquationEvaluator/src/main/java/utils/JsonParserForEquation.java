package utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParserForEquation {

	static ObjectMapper mapper = new ObjectMapper();
	public static JsonNode getJsonNodeFromFilePath(String filePath) throws JsonProcessingException, IOException{
	
		return mapper.readTree(new File(filePath));
	}
	
	public static JsonNode getJsonNodeFromKey(String key, JsonNode node) throws JsonProcessingException, IOException{
		
		return node.get(key);
	}
}
