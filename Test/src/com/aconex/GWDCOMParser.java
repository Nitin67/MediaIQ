package com.aconex;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class GWDCOMParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = System.getProperty("input.file");
		if (fileName == null || fileName == "")
			fileName = args[0];
		InputStreamReader input = null;
		try {
			input = new InputStreamReader(new FileInputStream(fileName));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		if (input != null) {
			BufferedReader reader = new BufferedReader(input);
			String str = null;
			try {
				str = reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Stack<XMLNode> nodeStack = new Stack<XMLNode>();
			while(str!=null&&!str.equals("")){
				XMLNode node = new XMLNode(str);
				nodeStack.push(node);
				try {
					str = reader.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
