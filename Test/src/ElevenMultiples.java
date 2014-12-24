import java.util.Arrays;

public class ElevenMultiples {
	static int[] sum = new int[50];
	static int[] startSum = new int[50];
	static boolean[] hasEvenDigit = new boolean[50];
	static int noOfPieces = 0;
	static long count = 0;

	public static void main(String[] args){
		String[] pieces = new String[]{"687045939630", "997856158148599044", "2014910234712225061", "9658113323175370226", "1584118137", "67925153345598920", "6960366756", "863413844386808834", "799302243562410012", "44481835751", "8004606814733183", "19623906615609", "23859998326058162", "461385591582", "9261878982390119", "1569373294276", "318106951168934", "65389049931", "12791173342", "507877942026", "3947173045690", "472425746178910", "524552931853595", "40771812249667850232", "563988469071932", "28147819070", "797007158858587", "5716177008624223", "387565700495309324", "4716621063133318"};
		 int count =  countMultiples(pieces);
		 System.out.println(count);
	}
	public static int countMultiples(String[] pieces) {
		noOfPieces = pieces.length;
		for (int j = 0; j < noOfPieces; j++) {
			String stringVal = pieces[j];
			int length = stringVal.length();
			hasEvenDigit[j] = false;
			if (length % 2 == 0)
				hasEvenDigit[j] = true;
			boolean start = true;
			startSum[j] = 0;
			sum[j] = 0;
			for (int i = 0; i < length; i++) {
				if (start) {
					startSum[j] += Character.digit(stringVal.charAt(i), 10);
					start = false;
				} else {
					sum[j] += Character.digit(stringVal.charAt(i), 10);
					start = true;
				}

			}
		}
		countMultiples(pieces, "", 0, 0, true,0,startSum,sum,hasEvenDigit);
		return (int)count%1000000007;
	}

	public static void countMultiples(String[] pieces, String stringVal, int stringStartSum, int stringSum, boolean hasEven,int lastIndex,int[] startSum,int[] sum,boolean[] hasEvenDigit) {

		if (pieces.length < 1) {
			int passingStartSum = stringStartSum;
			int passingSum = stringSum;
			if (hasEven) {
				passingStartSum += startSum[lastIndex];
				passingSum += sum[lastIndex];
			} else {
				passingSum += startSum[lastIndex];
				passingStartSum += sum[lastIndex];
			}
			int diff = passingStartSum - passingSum;
			if (diff == 0 || diff % 11 == 0)
				count += 1;
		} else {
			for (int i = 0; i < pieces.length; i++) {
				String[] newPieces = concatAll(Arrays.copyOfRange(pieces, 0, i-1<0?0:i),Arrays.copyOfRange(pieces, i+1>pieces.length?pieces.length:i+1, pieces.length));
				int[] newStartSum = concatAll(Arrays.copyOfRange(startSum, 0, i-1<0?0:i),Arrays.copyOfRange(startSum, i+1>startSum.length?startSum.length:i+1, startSum.length));
				int[] newSum = concatAll(Arrays.copyOfRange(sum, 0, i-1<0?0:i),Arrays.copyOfRange(sum, i+1>sum.length?sum.length:i+1, sum.length));
				boolean[] newHasEven = concatAll(Arrays.copyOfRange(hasEvenDigit, 0, i-1<0?0:i),Arrays.copyOfRange(hasEvenDigit, i+1>hasEvenDigit.length?hasEvenDigit.length:i+1, hasEvenDigit.length));
				String newString = stringVal + pieces[i];
				int passingStartSum = stringStartSum;
				int passingSum = stringSum;
				if (hasEven) {
					passingStartSum += startSum[i];
					passingSum += sum[i];
				} else {
					passingSum += startSum[i];
					passingStartSum += sum[i];
				}
				boolean passingHasEven = hasEvenDigit[i]==hasEven;
				countMultiples(newPieces, newString,
						passingStartSum, passingSum, passingHasEven,i,newStartSum,newSum,newHasEven);
			}
		}
	}
	
	public static <T> T[] concatAll(T[] first, T[]... rest) {
		  int totalLength = first.length;
		  for (T[] array : rest) {
		    totalLength += array.length;
		  }
		  T[] result = Arrays.copyOf(first, totalLength);
		  int offset = first.length;
		  for (T[] array : rest) {
		    System.arraycopy(array, 0, result, offset, array.length);
		    offset += array.length;
		  }
		  return result;
		}
	public static int[] concatAll(int[] first, int[]... rest) {
		  int totalLength = first.length;
		  for (int[] array : rest) {
		    totalLength += array.length;
		  }
		  int[] result = Arrays.copyOf(first, totalLength);
		  int offset = first.length;
		  for (int[] array : rest) {
		    System.arraycopy(array, 0, result, offset, array.length);
		    offset += array.length;
		  }
		  return result;
		}
	public static boolean[] concatAll(boolean[] first, boolean[]... rest) {
		  int totalLength = first.length;
		  for (boolean[] array : rest) {
		    totalLength += array.length;
		  }
		  boolean[] result = Arrays.copyOf(first, totalLength);
		  int offset = first.length;
		  for (boolean[] array : rest) {
		    System.arraycopy(array, 0, result, offset, array.length);
		    offset += array.length;
		  }
		  return result;
		}
}
