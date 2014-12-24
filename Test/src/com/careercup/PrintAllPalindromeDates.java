package com.careercup;

public class PrintAllPalindromeDates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Date Format MMDDYYYY
		String date1 = "01012000";
		String date2 = "01013000";
		Integer year1 = Integer.valueOf(date1.substring(4));
		Integer year2 = Integer.valueOf(date2.substring(4));
		for (Integer i = year1; i <= year2; i++) {
			reverseGetDateMonth(i);
		}

	}

	private static void reverseGetDateMonth(Integer i) {
		char[] charArray = i.toString().toCharArray();
		Integer date = Character.getNumericValue(charArray[1]) * 10
				+ Character.getNumericValue(charArray[0]);
		Integer month = Character.getNumericValue(charArray[3]) * 10
				+ Character.getNumericValue(charArray[2]);
		if (month <= 12 && month >= 1 && date >= 1 && date <= 31) {
			if (month % 2 == 1) {
				printDate(month, date, i);
			} else if (month == 02) {
				if ((i % 4 == 0 && date <= 29) || (i % 4 > 0 && date <= 28)) {
					printDate(month, date, i);
				}
			} else {
				printDate(month, date, i);
			}
		}
	}

	private static void printDate(Integer month, Integer date, Integer year) {
		
		System.out.printf("%1$02d%2$02d%3$04d%n",month,date,year);
	}

}
