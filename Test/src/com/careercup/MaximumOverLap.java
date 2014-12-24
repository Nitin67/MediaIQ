package com.careercup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MaximumOverLap {

	class IntervalArray {
		class Interval {
			public int start;
			public int end;
			public int overlapCount;
		}

		ArrayList<Interval> intervalArray = new ArrayList<Interval>();
		ArrayList<Interval> maxOverlapInterval = new ArrayList<Interval>();

		public void addToIntervalArray(Integer a, Integer b) {
			Interval interval = new Interval();
			interval.start = a;
			interval.end = b;
			findOverlap(interval, a, b);
			intervalArray.add(interval);

		}

		private boolean isOverlapping(Interval a, Interval b) {
			if (a.start >= b.start && a.start <= b.end || a.end >= b.start
					&& a.end <= b.end)
				return true;
			return false;
		}

		private void findOverlap(Interval interval, Integer a, Integer b) {
			if (intervalArray.size() > 0) {
				interval.overlapCount = 0;
			} else {

				for (Interval intervalInst : intervalArray) {
					if (isOverlapping(intervalInst, interval)) {
						interval.overlapCount = interval.overlapCount + 1;
						intervalInst.overlapCount = intervalInst.overlapCount + 1;
						int overLapCount = maxOverlapInterval.get(0).overlapCount;
						if (maxOverlapInterval.contains(intervalInst)) {
							maxOverlapInterval = new ArrayList<Interval>();
							maxOverlapInterval.add(intervalInst);
							overLapCount = intervalInst.overlapCount;
						} else if (intervalInst.overlapCount == overLapCount) {
							maxOverlapInterval.add(intervalInst);
						}

						if (maxOverlapInterval.contains(interval)) {
							maxOverlapInterval = new ArrayList<Interval>();
							maxOverlapInterval.add(interval);
							overLapCount = intervalInst.overlapCount;
						} else if (interval.overlapCount == overLapCount) {
							maxOverlapInterval.add(intervalInst);
						}
					}
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Integer ntc = Integer.valueOf(br.readLine());
			while (ntc > 0) {
				String str = br.readLine();
				String[] strArray = str.split(",");

				ntc--;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
