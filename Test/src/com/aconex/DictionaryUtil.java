package com.aconex;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * This is the Dictionary object that can be used to initialize a user specific
 * dictionary. Dictionary has to be of format:
 * 
 * <Number>:Char1,Char2,Char3...,CharN; e.g
 * 
 * 2=A,B,C:3=D,E,F:4=G,H,I:5=J,K,L:6=M,N,O:7=P,Q,R,S:8=T,U,V:9=W,X,Y,Z
 * 
 * and argument to start program would be
 * 
 * -Ddictionary="2=A,B,C:3=D,E,F:4=G,H,I:5=J,K,L:6=M,N,O:7=P,Q,R,S:8=T,U,V:9=W,X,Y,Z"
 * 
 */
public class DictionaryUtil {
	public Map<Integer, String[]> dictionary = new HashMap<Integer, String[]>();
	public DictionaryUtil(String str) {
		if (str == null) {
			// Default dictionary.
			str = "2=A,B,C:3=D,E,F:4=G,H,I:5=J,K,L:6=M,N,O:7=P,Q,R,S:8=T,U,V:9=W,X,Y,Z";
		}
		String[] strInput = str.split(":");
		if (strInput != null && strInput.length > 0) {
			for (String dictionaryString : strInput) {
				String[] temp = dictionaryString.split("=");
				String array = temp[1];
				if (array == null) {
					System.out.println("Invalid Dictionary");
					try {
						throw new Exception("Invalid Dictionary");
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					String[] dictionaryStringArray = array.split(",");
					Integer index = null;
					try {
						index = Integer.valueOf(temp[0]);
					} catch (NumberFormatException e) {
						System.out.println("Invalid Dictionary");
					}
					dictionary.put(index, dictionaryStringArray);
				}
			}
		} else {
			try {
				throw new Exception("Invalid Dictionary");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String[] getArray(int n) {
		switch (n) {
		case 1:
			return dictionary.get(1);
		case 2:
			return dictionary.get(2);
		case 3:
			return dictionary.get(3);
		case 4:
			return dictionary.get(4);
		case 5:
			return dictionary.get(5);
		case 6:
			return dictionary.get(6);
		case 7:
			return dictionary.get(7);
		case 8:
			return dictionary.get(8);
		case 9:
			return dictionary.get(9);
		case 0:
			return dictionary.get(0);
		default:
			return null;
		}
	}
}
