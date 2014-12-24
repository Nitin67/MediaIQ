package com.walmart.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class StudentInfo implements Serializable {
	String name;
	transient String rid;
	static String contact;

	public StudentInfo(String name, String rid, String contact) {
		this.name = name;
		this.rid = rid;
		this.contact = contact;
		// TODO Auto-generated constructor stub
	}

}

public class SerializationDesTest {

	public static void main(String[] args) {
		StudentInfo studentInfo = new StudentInfo("nitin", "Iec2009054",
				"7847042963");

		try {
			FileOutputStream fos = new FileOutputStream("student.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(studentInfo);
			oos.close();
			fos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			FileInputStream fis = new FileInputStream("student.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			StudentInfo s = (StudentInfo) ois.readObject();

			System.out.println(s.name);
			System.out.println(s.rid);
			System.out.println(s.contact);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
