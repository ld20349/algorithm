package algorithms.sort;

/**
 * 快速排序，不稳定，最差时间复杂度O(n*n)，最优时间复杂度O(n*logn)，平均时间复杂度O(n*logn)，需要辅助空间O(1)
 * 
 * @author liuduo
 *
 */
public class QuickSort extends Sort {

	@Override
	public void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	private void sort(int[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			sort(a, p, q - 1);
			sort(a, q + 1, r);
		}
	}

	private int partition(int[] a, int p, int r) {
		int i = p - 1;
		for (int j = p; j < r; j++)
			if (a[j] < a[r])
				swap(a, ++i, j);
		swap(a, i + 1, r);
		return i + 1;
	}

	public static void main(String[] args) {
		new QuickSort().sort();
	}
}
