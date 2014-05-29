package chapter1.exercise;

public class Ex1120 {
	public static double LN(int N) {
		if (N == 1)
			return Math.log(N);
		return LN(N - 1) + Math.log(N);
	}

	public static void main(String[] args) {
		double a = Math.log(120);
		double b = LN(5);
		System.out.println(a);
		System.out.println(b);
	}
}
