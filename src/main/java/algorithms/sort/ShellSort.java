package algorithms.sort;

/**
 * 希尔排序
 * 
 * @author liuduo
 *
 */
public class ShellSort extends Sort {

	@Override
	public void sort(int[] a) {
		int step = a.length / 2;
		while (step > 0) {
			for (int i = step; i < a.length; i++) {
				int t = a[i];
				int j;
				for (j = i - step; j >= 0 && a[j] > t; j -= step)
					a[j + step] = a[j];
				a[j + step] = t;
			}
			step = step / 2;
		}
	}

	public static void main(String[] args) {
		new ShellSort().sort();
	}
}
