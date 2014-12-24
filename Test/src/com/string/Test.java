package com.string;

public class Test {
 public static void main(String[] args){
	 
 }
 
 public static void perm(StringBuffer s, int index){
	 int strlen  =s.length();
	 System.out.println(s);
	 for(int i=0;i<s.length()+1;i++){
	 s=s.insert(i,s.charAt(index));
	 perm(s,index+1);
	 //s.re(s.charAt(i));
	 }

 }
}
