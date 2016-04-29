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
		int i = left;
		int j = mid + 1;
		int[] r = new int[right - left + 1];
		int k = 0;
		while (i <= mid && j <= right) {
			if (a[i] < a[j])
				r[k++] = a[i++];
			else
				r[k++] = a[j++];
		}
		while (i <= mid)
			r[k++] = a[i++];
		while (j <= right)
			r[k++] = a[j++];
		System.arraycopy(r, 0, a, left, r.length);
	}

	public static void main(String[] args) {
		new MergeSort().sort();
	}
}
