package com.codechef;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.InputMismatchException;

public class MAXDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int tCount = in.readInt();
		while(tCount>0){
			int itemCount = in.readInt();
			int k = in.readInt();
			int[] itemsWeight = new int[itemCount];
			int i = 0,sum=0;
			while(i<itemCount){
				itemsWeight[i] = in.readInt();
				sum+=itemsWeight[i];
				i++;
			}
			int[] kthLargest = kthLargest(itemsWeight,itemCount-k);
			int kthLargestSum = 0;
			for(int n:kthLargest)
				kthLargestSum+=n;
			out.printLine(2*kthLargestSum - sum);
			tCount--;
		}
		out.close();
	}

	public static int[] kthLargest(int[] givenArray, int k) {
		int[] sortedArray = new int[k];
		for (int i = 0; i < givenArray.length; i++) {
			int temp = givenArray[i];
			for (int j = 0; j < sortedArray.length; j++) {
				if (!(sortedArray[j] == 0)) {
					int a = sortedArray[j];
					if (a < temp) {
						sortedArray[j] = temp;
						temp = a;
					}
				} else {
					sortedArray[j] = temp;
					break;
				}
			}
		}
		return sortedArray;
	}
	
}

class InputReader {
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;

	public InputReader(InputStream stream) {
		this.stream = stream;
	}

	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	public int readInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	public String readString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuffer res = new StringBuffer();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}

	static boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	public String next() {
		return readString();
	}
}

class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(outputStream);
	}

	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

	public void print(Object... objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}

	public void printLine(Object... objects) {
		print(objects);
		writer.println();
	}

	public void close() {
		writer.close();
	}
}
