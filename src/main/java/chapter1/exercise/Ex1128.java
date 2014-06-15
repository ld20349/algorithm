package chapter1.exercise;

import edu.princeton.cs.introcs.StdOut;

public class Ex1128 {
	public static int[] deleteDuplicateElements(int[] a) {
		/*
		 * 初始化要返回的不重复元素构成的数组result，每个元素的初始值都设为-1， 因输入数组中的每个元素的值都是非负的，所以-1可代表非法值
		 */
		int[] result = new int[a.length];
		for (int i = 0; i < result.length; i++)
			result[i] = -1;

		int prev = -1; // 每次要比较的前一个元素的值
		int index = 0; // 下一个可用的数组result的元素的索引
		for (int i = 0; i < a.length; i++) {
			if (a[i] != prev) {
				result[index] = a[i];
				index++;
				prev = a[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] whitelist = { 1, 2, 3, 4, 4, 5, 5, 5, 6, 7, 8, 8, 9 };
		int[] result = deleteDuplicateElements(whitelist);
		for (int e : result) {
			if (e != -1)
				StdOut.println(e);
			else
				break;
		}
	}
}
