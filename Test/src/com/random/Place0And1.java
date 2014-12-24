package com.random;

public class Place0And1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = {0,1,1,1,1,0,0,1};
		int pos_0 = 0;
		int pos_1 = 1;

		for (int i = 0; i < a.length; i++) {
			//
			// We have been waiting for a zero to be placed at the correct
			// location.
			//
			if (pos_0 < pos_1) {
				if (a[i] == 0) {
					int t = a[i];
					a[i] = a[pos_0];
					a[pos_0] = t;
					pos_0 += 2;

					//
					// If we had a 1 already at the right place, increment
					// pos_1.
					//
					if (a[pos_1] == 1)
						pos_1 += 2;
				}
			}

			//
			// We have been waiting for a one to be placed at the correct
			// location.
			//
			else {
				if (a[i] == 1) {
					int t = a[i];
					a[i] = a[pos_1];
					a[pos_1] = t;
					pos_1 += 2;

					//
					// If we had a 0 already at the right place, increment
					// pos_0.
					//
					if (a[pos_0] == 0)
						pos_0 += 2;
				}
			}
		}
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
	}

}
