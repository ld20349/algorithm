package chapter1;

public class Ex1114 {
	public static int lg(final int N) {
		int i = 1;
		while (compute2Power(i) <= N)
			i++;
		return i - 1;
	}

	/**
	 * 计算2的N次方
	 */
	private static int compute2Power(final int N) {
		int result = 1;
		for (int i = 1; i <= N; i++) {
			result *= 2;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(lg(1025));
	}
}