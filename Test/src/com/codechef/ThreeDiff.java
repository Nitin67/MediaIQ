package com.codechef;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class SortedArrayList<T> extends ArrayList<T> {

	@SuppressWarnings("unchecked")
	public void insertSorted(T value) {
		add(value);
		Comparable<T> cmp = (Comparable<T>) value;
		for (int i = size() - 1; i > 0 && cmp.compareTo(get(i - 1)) < 0; i--)
			Collections.swap(this, i, i - 1);
	}
}

public class ThreeDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileInputStream fs = null;
		FileOutputStream fo = null;
		try {
			fs = new FileInputStream(new File(args[0]));
			fo = new FileOutputStream(new File(args[1]));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataInputStream fileIn = new DataInputStream(fs);
		DataOutputStream fileOut = new DataOutputStream(fo);
		Integer countOfTestCase = 0;
		try {
			countOfTestCase = Integer.valueOf(fileIn.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 1; i <= countOfTestCase; i++) {
			String str = null;
			try {
				str = fileIn.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[] strArray = str.split(" ");
			SortedArrayList<Integer> srt = new SortedArrayList<Integer>();
			srt.insertSorted(Integer.valueOf(strArray[0]));
			srt.insertSorted(Integer.valueOf(strArray[1]));
			srt.insertSorted(Integer.valueOf(strArray[2]));
			try {
				fileOut.writeBytes(modulo(
						(srt.get(0)) * (srt.get(1) - 1) * (srt.get(2) - 2))
						.toString()+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(modulo((srt.get(0)) * (srt.get(1) - 1)
					* (srt.get(2) - 2)));
		}
		try {
			fileIn.close();
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

	private static Integer modulo(int i) {
		return i;
	}

}
