package algorithms.sort;

/**
 * 希尔排序，不稳定，最差时间复杂度：根据步长序列的不同而不同，已知最好的为O(n*logn*logn)，最优时间复杂度：O(n)，平均时间复杂度：
 * 根据步长序列的不同而不同，需要辅助空间O(1)
 * 
 * @author liuduo
 *
 */
public class ShellSort extends Sort {

	@Override
	public void sort(int[] a) {
		int i, j, t;
		int gap = a.length / 2;
		while (gap > 0) {
			for (i = gap; i < a.length; i++) {
				t = a[i];
				for (j = i - gap; j >= 0 && a[j] > t; j -= gap)
					a[j + gap] = a[j];
				a[j + gap] = t;
			}
			gap /= 2;
		}
	}

	public static void main(String[] args) {
		new ShellSort().sort();
	}
}
