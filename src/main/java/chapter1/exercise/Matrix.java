package chapter1.exercise;

import edu.princeton.cs.introcs.StdOut;

public class Matrix {
	/**
	 * 打印矩阵
	 */
	public static void print(double[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				StdOut.print(a[i][j] + " ");
			}
			StdOut.println();
		}
	}

	/**
	 * 向量点乘
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static double dot(double[] x, double[] y) {
		double result = 0.0;
		for (int i = 0; i < x.length; i++)
			result += x[i] * y[i];
		return result;
	}

	/**
	 * 矩阵和矩阵之积
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double[][] mult(double[][] a, double[][] b) {
		double[][] result = new double[a.length][b[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				double[] row = a[i];
				double[] column = new double[row.length];
				for (int k = 0; k < column.length; k++) {
					column[k] = b[k][j];
				}
				result[i][j] = dot(row, column);
			}
		}
		return result;
	}

	/**
	 * 转置矩阵
	 * 
	 * @param a
	 * @return
	 */
	public static double[][] transpose(double[][] a) {
		double[][] result = new double[a[0].length][a.length];
		for (int i = 0; i < result.length; i++)
			for (int j = 0; j < result[0].length; j++)
				result[i][j] = a[j][i];
		return result;
	}

	/**
	 * 矩阵和向量之积
	 * 
	 * @param a
	 * @param x
	 * @return
	 */
	public static double[] mult(double[][] a, double[] x) {
		double[][] b = new double[x.length][1];
		for (int i = 0; i < b.length; i++)
			b[i][0] = x[i];
		double[][] mult = mult(a, b);
		double[] result = new double[mult.length];
		for (int i = 0; i < result.length; i++)
			result[i] = mult[i][0];
		return result;
	}

	/**
	 * 向量和矩阵之积
	 * 
	 * @param y
	 * @param a
	 * @return
	 */
	public static double[] mult(double[] y, double[][] a) {
		double[][] b = new double[1][y.length];
		for (int i = 0; i < y.length; i++)
			b[0][i] = y[i];
		double[][] mult = mult(b, a);
		double[] result = new double[a[0].length];
		for (int i = 0; i < result.length; i++)
			result[i] = mult[0][i];
		return result;
	}

	public static void main(String[] args) {
		/*
		 * 测试打印矩阵
		 */
		double[][] m = { { 0, 3, 1 }, { 5, 2, 8 } };
		print(m);
		StdOut.println("=====================");
		/*
		 * 测试向量点乘
		 */
		double[] x = { 1, 2, 3 };
		double[] y = { 4, 5, 6 };
		StdOut.println(dot(x, y));
		StdOut.println("=====================");
		/*
		 * 测试矩阵和矩阵之积
		 */
		double[][] a = { { 3, 0, 0, 7 }, { 0, 0, 0, -1 }, { 0, 2, 0, 0 } };
		double[][] b = { { 4, 1 }, { 0, 0 }, { 1, -1 }, { 0, 2 } };
		double[][] result = mult(a, b);
		print(result);
		StdOut.println("=====================");
		/*
		 * 测试转置矩阵
		 */
		double[][] c = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		print(transpose(c));
		StdOut.println("=====================");
		/*
		 * 测试矩阵和向量之积
		 */
		double[][] d = { { 1, 2, 3 }, { 4, 5, 6 } };
		double[] p = { 7, 8, 9 };
		double[] result2 = mult(d, p);
		for (int i = 0; i < result2.length; i++) {
			StdOut.println(result2[i]);
		}
		StdOut.println("=====================");
		/*
		 * 测试向量和矩阵之积
		 */
		double[] e = { 1, 2, 3 };
		double[][] q = { { 4, 5 }, { 6, 7 }, { 8, 9 } };
		double[] result3 = mult(e, q);
		for (int i = 0; i < result3.length; i++) {
			StdOut.println(result3[i]);
		}
	}
}
