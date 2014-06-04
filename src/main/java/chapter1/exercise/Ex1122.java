package chapter1.exercise;

import java.util.Arrays;

import edu.princeton.cs.introcs.StdOut;

public class Ex1122 {
	public static void main(String[] args) {
		int[] a = { 3, 5, 1, 9, 7, 18, 15, 10, 20 };
		Arrays.sort(a);
		StdOut.println(rank(4, a));
	}

	public static int rank(int key, int[] a) {
		return rank(key, a, 0, a.length - 1, 1);
	}

	public static int rank(int key, int[] a, int lo, int hi, int depth) {
		for (int i = 1; i <= depth - 1; i++)
			StdOut.print("\t");
		StdOut.println("lo=" + lo + ",hi=" + hi);

		if (lo > hi)
			return -1;
		int mid = lo + (hi - lo) / 2;
		if (key < a[mid])
			return rank(key, a, lo, mid - 1, ++depth);
		else if (key > a[mid])
			return rank(key, a, mid + 1, hi, ++depth);
		else
			return mid;
	}
}
