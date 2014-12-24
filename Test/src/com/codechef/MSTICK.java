package com.codechef;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

public class MSTICK {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		String[] sticksTime = null;
		Integer queryCount = 0;
		try {
			Integer n = Integer.parseInt(br.readLine());
			sticksTime = br.readLine().split(" ");
			queryCount = Integer.parseInt(br.readLine());
			while(queryCount>0){
				String[] range = br.readLine().split(" ");
				Double[] minMaxArray = findMinMaxArray(range,sticksTime);
				Double totalTime = minMaxArray[2]+(((minMaxArray[1]-minMaxArray[2])/2)>minMaxArray[0]?((minMaxArray[1]-minMaxArray[2])/2):minMaxArray[0]);
				DecimalFormat df=new DecimalFormat("0.0");
				bw.write(df.format(totalTime));
				queryCount--;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}

	private static Double[] findMinMaxArray(String[] range, String[] sticksTime) {
		Double[] minMaxArray = {0.0,0.0,99999999.0};
		Integer rangeMin = Integer.parseInt(range[0]);
		Integer rangeMax = Integer.parseInt(range[1]);
		int i =0;
		while(i<sticksTime.length){
			if(i<rangeMin||i>rangeMax){
				minMaxArray[0] = minMaxArray[0]>Integer.parseInt(sticksTime[i])?minMaxArray[0]:Integer.parseInt(sticksTime[i]);
			}else{
				minMaxArray[1] = minMaxArray[1]>Integer.parseInt(sticksTime[i])?minMaxArray[1]:Integer.parseInt(sticksTime[i]);
				minMaxArray[2] = minMaxArray[2]<Integer.parseInt(sticksTime[i])?minMaxArray[2]:Integer.parseInt(sticksTime[i]);
			}
			i++;
		}
		return minMaxArray;
	}
}
