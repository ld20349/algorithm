package algorithms.sort;

/**
 * 选择排序，不稳定，最差时间复杂度O(n*n)，最优时间复杂度O(n*n)，平均时间复杂度O(n*n)，需要辅助空间O(1)
 * 
 * @author liuduo
 *
 */
public class SelectionSort extends Sort {

	@Override
	public void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int max = 0;
			for (int j = 1; j < a.length - i; j++) {
				if (a[j] > a[max]) {
					max = j;
				}
			}
			swap(a, max, a.length - 1 - i);
		}
	}

	public static void main(String[] args) {
		new SelectionSort().sort();
	}
}
