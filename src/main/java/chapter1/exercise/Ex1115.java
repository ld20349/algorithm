package chapter1.exercise;

public class Ex1115 {
	public static int[] histogram(final int[] a, final int M) {
		int[] b = new int[M];
		for (int i = 0; i < b.length; i++) {
			int count = 0;
			for (int e : a)
				if (i == e)
					count++;
			b[i] = count;
		}
		return b;
	}

	public static void main(String[] args) {
		int[] a = { 1, 5, 3, 6, 4, 2 };
		int M = 4;
		for (int e : histogram(a, M)) {
			System.out.println(e);
		}
		// 0 1 1 1
	}
}
