package chapter1.exercise;

import edu.princeton.cs.introcs.StdOut;

public class OptimizedFibonacci {
	private static long[] result = new long[10000];
	static {
		for (int i = 0; i < result.length; i++) {
			result[i] = -1l;
		}
	}

	public static long F(int N) {
		if (N == 0) {
			long value = 0;
			result[0] = value;
			return value;
		}
		if (N == 1) {
			long value = 1;
			result[1] = value;
			return value;
		}

		long first;
		if (result[N - 1] == -1) {
			first = F(N - 1);
			result[N - 1] = first;
		} else {
			first = result[N - 1];
		}
		long second;
		if (result[N - 2] == -1) {
			second = F(N - 2);
			result[N - 2] = second;
		} else {
			second = result[N - 2];
		}
		long value = first + second;
		result[N] = value;
		return value;
	}

	public static void main(String[] args) {
		for (int N = 0; N < 100; N++)
			StdOut.println(N + " " + F(N));
	}
}
