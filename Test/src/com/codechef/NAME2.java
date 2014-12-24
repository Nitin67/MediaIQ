package com.codechef;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NAME2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		Integer tc = 0;
		try {
			tc = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (tc > 0) {
			String strIn = "";
			try {
				strIn = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String[] strName = strIn.split(" ");
			if (isSubString(strName)) {
				try {
					bw.write("YES");
					if(tc!=1)
						bw.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					bw.write("NO");
					if(tc!=1)
						bw.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			tc--;
		}
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isSubString(String[] strName) {
		int mLength = strName[0].length();
		int wLength = strName[1].length();
		if (wLength < mLength) {
			String temp = strName[0];
			strName[0] = strName[1];
			strName[1] = temp;
			temp = null;
			wLength = wLength + mLength;
			mLength = wLength - mLength;
			wLength = wLength - mLength;
		}
		int i = 0;
		int k = 0;
		for (char c : strName[0].toCharArray()) {
			
			if (i == 0) {
				i = strName[1].indexOf(c);
				if (i <0)
					return false;
				k = i;
				i++;
			} else {
				k = strName[1].indexOf(c, k);
				if (k <0)
					return false;
			}
		}
		return true;
	}

}
