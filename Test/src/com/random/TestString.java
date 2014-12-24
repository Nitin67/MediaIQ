package com.random;

public class TestString {
 public static void main(String[] args){
	 String str = "; customerName::Tania ; accountNumber::123 ; formType::Pre Interaction ; formId::Preinteraction ; account_pre::Linksys ; issue_pre::Internet Connectivity ; ssn_pre::Windows 7 ; customerPhone::(510) 381-7231 ; customerEmail::t@f.com";
	 String[] sa = str.split(";");
	 int countPi = 0;
	 String[] piFormDetail = new String[10];
	 if (sa != null&&sa.length>0) {
			for (String s : sa) {
				String[] temp = s.split(":");
				if(temp.length>2){
					piFormDetail[countPi] = temp[2];
				countPi++;
				}
			}
		}
	 String[] ssa = sa[1].split(":");
	 System.out.println(ssa[1]);;
 }
}
