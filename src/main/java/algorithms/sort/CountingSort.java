package algorithms.sort;

/**
 * 计数排序，稳定，最差时间复杂度O(n+k)，最优时间复杂度O(n+k)，平均时间复杂度O(n+k)，需要辅助空间O(n+k)
 * 
 * @author liuduo
 *
 */
public class CountingSort extends Sort {

	@Override
	public void sort(int[] a) {
		int min = a[0];
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
			if (a[i] > max) {
				max = a[i];
			}
		}
		int[] c = new int[max - min + 1];
		for (int e : a) {
			c[e - min]++;
		}
		for (int i = 1; i < c.length; i++) {
			c[i] = c[i] + c[i - 1];
		}
		int[] r = new int[a.length];
		for (int e : a) {
			r[c[e - min] - 1] = e;
			c[e - min]--;
		}
		System.arraycopy(r, 0, a, 0, r.length);
	}

	public static void main(String[] args) {
		new CountingSort().sort();
	}
}
