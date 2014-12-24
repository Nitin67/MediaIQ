package com.walmart.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputOutputStream {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number ::");
		char c = (char) br.read();
		System.out.println("c : " + c);
		BufferedReader br1 = new BufferedReader(
				new InputStreamReader(System.in));
		String s = br1.readLine();
		System.out.println(s);
		File f = new File("file.txt");
		FileWriter fw = new FileWriter(f);
		String str = "String to be written to file";
		fw.write(str);
		fw.close();
		FileReader fr = new FileReader(f);
		BufferedReader br2 = new BufferedReader(fr);
		while ((str = br2.readLine()) != null) {
			System.out.println(str);

			FileOutputStream fos = new FileOutputStream("file1.txt");
			String stt = "String to be written through stream";

		}
	}
}
