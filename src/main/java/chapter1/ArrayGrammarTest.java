package chapter1;

public class ArrayGrammarTest {
	public static void main(String[] args) {
		double[] a;
		a = new double[10];
		for (double e : a) {
			System.out.println(e);
		}
		System.out.println(a);

		int[] b = { 5, 2, 6, 3, 1, 7, 9 };
		System.out.println(b.length);
		for (int e : b) {
			System.out.println(e);
		}

		int[] c = new int[] { 5, 2, 6, 3, 1, 7, 9 };
		System.out.println(c.length);
		for (int e : c) {
			System.out.println(e);
		}
		
		boolean[] d = new boolean[10];
		for (boolean e : d) {
			System.out.println(e);
		}
	}
}
