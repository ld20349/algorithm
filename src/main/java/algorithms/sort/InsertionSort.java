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
		for (j = 1; j <= a.length - 1; j++) {
			t = a[j];
			for (i = j - 1; i >= 0 && a[i] > t; i--) {
				a[i + 1] = a[i];
			}
			a[i + 1] = t;
		}
	}

	public static void main(String[] args) {
		new InsertionSort().sort();
	}
}
