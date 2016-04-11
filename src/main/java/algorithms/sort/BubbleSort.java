package algorithms.sort;

/**
 * 冒泡排序，稳定，最差时间复杂度O(n*n)，最优时间复杂度O(n)，平均时间复杂度O(n*n)，需要辅助空间O(1)
 * 
 * @author liuduo
 *
 */
public class BubbleSort extends Sort {

	@Override
	public void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		new BubbleSort().sort();
	}
}
