package chapter1.exercise;

import chapter1.algorithm.Euclidean;

public class Ex1130 {
	public static void main(String[] args) {
		int N = 5;
		boolean[][] a = new boolean[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (Euclidean.gcd(i, j) == 1)
					a[i][j] = true;
				else
					a[i][j] = false;

		MatrixOps.printMatrix(a);
	}
}
