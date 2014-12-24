package com.codechef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WITMATH {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long best = 1;
		long phiBest = 1;
		double bestRatio = Double.MAX_VALUE;
		 
		int limit = 10000000;
		int lowerbound = 2000;
		int upperbound = 5000;
		Object[] primes = ESieve(lowerbound, upperbound);
		 
		for (int i = 0; i < primes.length; i++) {
		    for (int j = i+1; j < primes.length; j++) {
		        long n = ((Long)primes[i]) *((Long) primes[j]);
		        if (n > limit) break;
		 
		        long phi = (((Long)primes[i]) - 1) * (((Long)primes[j]) - 1);
		        double ratio = ((double) n) / phi;
		 
		        if (isPerm(n, phi) && bestRatio > ratio) {
		            best = n;
		            phiBest = phi;
		            bestRatio = ratio;
		        }
		    }
		}

	}
	 public static Object[] ESieve(int lowerLimit, int upperLimit) {

         int sieveBound = (int)(upperLimit - 1) / 2;
         int upperSqrt = ((int)Math.sqrt(upperLimit) - 1) / 2;

         Map<Integer,Boolean> PrimeBits = new HashMap<Integer,Boolean>();
         PrimeBits.put(sieveBound, true);
         for (int i = 1; i <= upperSqrt; i++) {
             if (PrimeBits.get(i)!=null&&PrimeBits.get(i)) {
                 for (int j = i * 2 * (i + 1); j <= sieveBound; j += 2 * i + 1) {
                     PrimeBits.put(j, false);
                 }
             }
         }

         List<Long> numbers = new ArrayList<Long>((int)(upperLimit / (Math.log(upperLimit) - 1.08366)));

         if (lowerLimit < 3) {
             numbers.add((long) 2);
             lowerLimit = 3;
         }

         for (int i = (lowerLimit-1)/2; i <= sieveBound; i++) {
             if (PrimeBits.get(i)!=null&&PrimeBits.get(i)) {
                 numbers.add((long) (2 * i + 1));
             }
         }

         return  numbers.toArray();
     }

	 private static boolean isPerm(long m, long n) {
         int[] arr = new int[10];

         long temp = n;
         while (temp > 0) {
             arr[(int) (temp % 10)]++;
             temp /= 10;
         }

         temp = m;
         while (temp > 0) {
             arr[(int) (temp % 10)]--;
             temp /= 10;
         }


         for (int i = 0; i < 10; i++) {
             if (arr[i] != 0) {
                 return false;
             }
         }
         return true;
     }


}
