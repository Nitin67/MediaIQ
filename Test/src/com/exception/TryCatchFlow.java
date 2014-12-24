package com.exception;


public class TryCatchFlow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			throw new Exception();
		}catch(Exception exception){
			exception.printStackTrace();
		}finally{
			System.out.println("Finally");
		}
		System.out.println("Main");
	}

}
