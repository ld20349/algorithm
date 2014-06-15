package chapter1.exercise;

import edu.princeton.cs.introcs.StdOut;

public class Ex1129 {
	public static int rank(int key, int[] a) {
		int count = 0;
		for (int e : a) {
			if (e < key)
				count++;
			else
				break;
		}
		return count;
	}

	public static int count(int key, int[] a) {
		int count = 0;
		for (int e : a) {
			if (e == key)
				count++;
			else if (e > key)
				break;
		}
		return count;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 4, 5, 5, 5, 6, 7, 8, 8, 9 };
		StdOut.println(rank(5, a));
		StdOut.println(count(5, a));
	}
}
