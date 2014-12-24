package com.walmart.demo;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class NetworkingInJava {

	public static void main(String[] args) {
		try {
			InetAddress address = InetAddress.getLocalHost();
			System.out.println(address + "---- " + address);
			address = InetAddress.getByName("www.studytonight.com");
			System.out.println(address + "---- " + address);
			InetAddress ad[] = InetAddress.getAllByName("www.google.com");
			for (int i = 0; i < ad.length; i++) {
				System.out.println(ad[i]);
			}
			System.out.println(address.getHostName());
			System.out.println(address.getAddress());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		try {
			URL url = new URL("http://www.studytonight.com/index");
			System.out.println(url.getHost());
			System.out.println(url.getProtocol());
			System.out.println(url.getPort());
			System.out.println(url.getFile());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
