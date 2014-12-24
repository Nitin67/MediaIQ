package com.walmart.demo;

import java.io.*;
import java.util.Scanner;

public class TakingInputFromkeyBoard {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter num of brac");
		String s = in.nextLine();

		System.out.println(s);
		InputStreamReader inputReader = new InputStreamReader(System.in);
		BufferedReader bufReader = new BufferedReader(inputReader);

		try {
			System.out.println("Enter your name :" + "\n");
			String name = bufReader.readLine();
			System.out.println("Enter your age:" + "\n");
			String age = bufReader.readLine();
			int ageOfPerson = Integer.parseInt(age);
			System.out.println("Name : " + name + "Age : " + ageOfPerson);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
