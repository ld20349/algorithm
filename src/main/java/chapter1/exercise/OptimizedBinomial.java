package chapter1.exercise;

public class OptimizedBinomial {
	/**
	 * 已经计算过的值保存下来,这样在递归调用的时候不用重新计算，直接取值即可。
	 * 注意：因为要保存binomial(-1,-1,p)、binomial(-1
	 * ,0,p)、binomial(0,-1,p)、binomial(2,-1,p)、...
	 * binomial(N,-1,p)这样的值，所以缓存的时候N和k都加了1以应付数组下标为负数的情况，
	 * 即computedResults[N+1][k+1]=binomial(N,k,p)
	 */
	private static double[][] computedResults = new double[200][200];

	public static double binomial(int N, int k, double p) {
		if (N == 0 && k == 0)
			return 1.0;
		if (N < 0 || k < 0)
			return 0.0;
		return (1.0 - p) * computedResults[N - 1 + 1][k + 1] + p
				* computedResults[N - 1 + 1][k - 1 + 1]; // 注意computedResults中的N和k都要加1
	}

	public static void main(String[] args) {
		int N = 100;
		int k = 50;
		double p = 0.25;
		for (int i = -1; i <= N; i++) {
			for (int j = -1; j <= k; j++) {
				// 已经计算过的值保存下来。注意computedResults中的N和k都要加1
				computedResults[i + 1][j + 1] = binomial(i, j, p);
			}
		}
		System.out.println(computedResults[101][51]); // 注意computedResults中的N和k都要加1
	}
}
