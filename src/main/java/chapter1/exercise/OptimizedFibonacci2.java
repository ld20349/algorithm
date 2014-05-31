package chapter1.exercise;

import edu.princeton.cs.introcs.StdOut;

/**
 * 该实现的思想是缓存已经计算过了的F(N)的结果。 该实现的优点是可以在任何时候都直接调用F(N)（无论N等于几），
 * 而不必像OptimizedFibonacci1那样必须自底向上依次计算完毕F(0)、F(1)、...F(N-1)之后，
 * 才能计算得到F(N)的值，缺点是代码比较复杂，不够简洁。
 * 
 * @author liuduo
 * 
 */
public class OptimizedFibonacci2 {
	private static long[] cache = new long[10000];
	static {
		for (int i = 0; i < cache.length; i++) {
			cache[i] = -1l;
		}
	}

	public static long F(int N) {
		if (cache[N] != -1l)
			return cache[N];

		if (N == 0) {
			cache[0] = 0l;
			return cache[0];
		}
		if (N == 1) {
			cache[1] = 1l;
			return cache[1];
		}
		long first;
		if (cache[N - 1] != -1l)
			first = cache[N - 1];
		else {
			cache[N - 1] = F(N - 1);
			first = cache[N - 1];
		}
		long second;
		if (cache[N - 2] != -1l)
			second = cache[N - 2];
		else {
			cache[N - 2] = F(N - 2);
			second = cache[N - 2];
		}
		cache[N] = first + second;
		return cache[N];
	}

	public static void main(String[] args) {
		System.out.println(50 + " " + F(50));
		for (int N = 0; N < 100; N++)
			StdOut.println(N + " " + F(N));
	}
}
