package com.encryption;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "cwp_olap_ssrs_user";
		StandardPBEStringEncryptor sp = new StandardPBEStringEncryptor ();
		sp.setPassword("jasypt");
		str = sp.encrypt(str);
		System.out.println("ENC("+str+")");
		

	}

}
