package algorithms.sort;

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
		int t = a[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (a[j] < t) {
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i + 1, r);
		return i + 1;
	}

	public static void main(String[] args) {
		new QuickSort().sort();
	}
}
