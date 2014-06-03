package chapter1.others;

import edu.princeton.cs.introcs.StdOut;

public class Test {
	public static int mystery(int a, int b) {
		if (b == 0)
			return 1;
		if (b % 2 == 0)
			return mystery(a * a, b / 2);
		return mystery(a * a, b / 2) * a;
	}

	public static String exR1(int n) {
		if (n <= 0)
			return "";
		return exR1(n - 3) + n + exR1(n - 2) + n;
	}

	public static String exR2(int n) {
		String s = exR2(n - 3) + n + exR2(n - 2) + n;
		if (n <= 0)
			return "";
		return s;
	}

	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid])
				hi = mid - 1;
			else if (key > a[mid])
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		StdOut.println(1+2+"3");
	}
}
