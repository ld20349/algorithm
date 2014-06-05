package chapter1.exercise;

import edu.princeton.cs.introcs.StdOut;

public class Binomial {
	public static double binomial(int N, int k, double p) {
		if (N == 0 && k == 0)
			return 1.0;
		if (N < 0 || k < 0)
			return 0.0;
		return (1 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
	}

	public static void main(String[] args) {
		StdOut.println(binomial(100, 50, 0.25));
	}
}
