package algorithms.sort;

/**
 * 归并排序，稳定，最差时间复杂度O(n*logn)，最优时间复杂度O(n)，平均时间复杂度O(n*logn)，需要辅助空间O(n)
 * 
 * @author liuduo
 *
 */
public class MergeSort extends Sort {

	@Override
	public void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	private void sort(int[] a, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			sort(a, left, mid);
			sort(a, mid + 1, right);
			merge(a, left, mid, right);
		}
	}

	private void merge(int[] a, int left, int mid, int right) {
		int[] r = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) {
			if (a[i] < a[j]) {
				r[k++] = a[i++];
			} else {
				r[k++] = a[j++];
			}
		}
		while (i <= mid) {
			r[k++] = a[i++];
		}
		while (j <= right) {
			r[k++] = a[j++];
		}
		for (int l = 0; l < r.length; l++) {
			a[left + l] = r[l];
		}
	}

	public static void main(String[] args) {
		// int[] t = { 1, 2, 4, 8, 3, 5, 7, 9 };
		// new MergeSort().merge(t, 0, 3, 7);
		// System.out.println(Arrays.toString(t));
		new MergeSort().sort();
	}
}
