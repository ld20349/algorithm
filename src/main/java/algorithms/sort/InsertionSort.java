package algorithms.sort;

/**
 * 插入排序，稳定，最差时间复杂度O(n*n)，最优时间复杂度O(n)，平均时间复杂度O(n*n)，需要辅助空间O(1)
 * 
 * @author liuduo
 *
 */
public class InsertionSort extends Sort {

	@Override
	protected void sort(int[] a) {
		int i, j, t;
		for (i = 1; i < a.length; i++) {
			t = a[i];
			for (j = i - 1; j >= 0 && a[j] > t; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = t;
		}
	}

	public static void main(String[] args) {
		new InsertionSort().sort();
	}
}
