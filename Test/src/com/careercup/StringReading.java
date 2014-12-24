package com.careercup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReading {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String inputString = br.readLine();
			String truncatedSting = inputString.substring(2, inputString.length()).substring(0,inputString.length()-3);
			System.out.println(truncatedSting);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
