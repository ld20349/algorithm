package algorithms.sort;

/**
 * 计数排序，稳定，最差时间复杂度O(n)，最优时间复杂度O(n)，平均时间复杂度O(n)，需要辅助空间O(k)，k为桶的数量
 * 
 * @author liuduo
 *
 */
public class CountingSort extends Sort {

	@Override
	public void sort(int[] a) {
		int min, max;
		min = max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min)
				min = a[i];
			if (a[i] > max)
				max = a[i];
		}
		int[] c = new int[max - min + 1];
		for (int e : a)
			c[e - min]++;
		for (int i = 1; i < c.length; i++)
			c[i] += c[i - 1];
		int[] r = new int[a.length];
		for (int e : a)
			r[--c[e - min]] = e;
		System.arraycopy(r, 0, a, 0, a.length);
	}

	public static void main(String[] args) {
		new CountingSort().sort();
	}
}
