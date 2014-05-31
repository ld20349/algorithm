package chapter1.exercise;

import edu.princeton.cs.introcs.StdOut;

/**
 * 该实现的思想是自底向上依次计算F(0)、F(1)、...F(N-1)的值， 并用一个数组来保存这些已经计算过的值，然后计算F(N)的值的时候，
 * 直接取数组里的值即可（类似于动态规划算法）。 该实现的好处是代码简单，并且效率比原始的递归算法高很多，缺点是
 * 要计算F(N)的值，必须先计算F(0)、F(1)、...F(N-1)的值，不能直接计算F(N)的值。
 * 
 * @author liuduo
 * 
 */
public class OptimizedFibonacci1 {
	private static long[] computedResults = new long[10000];

	public static long F(int N) {
		if (N == 0) {
			long result = 0l;
			computedResults[0] = result;
			return result;
		}
		if (N == 1) {
			long result = 1l;
			computedResults[1] = result;
			return result;
		}
		long result = computedResults[N - 1] + computedResults[N - 2];
		computedResults[N] = result;
		return result;
	}

	public static void main(String[] args) {
		for (int N = 0; N < 100; N++)
			StdOut.println(N + " " + F(N));
	}
}
