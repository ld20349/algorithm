package algorithms.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 基数排序
 * 
 * @author liuduo
 *
 */
public class RadixSort extends Sort {

	@Override
	public void sort(int[] a) {
		List<List<Integer>> buckets = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			buckets.add(new ArrayList<>());
		}
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		int digits = getTotalDigits(max);
		for (int i = 1; i <= digits; i++) {
			for (int e : a) {
				buckets.get(getSpecifyDigitValue(e, i)).add(e);
			}
			int j = 0;
			for (List<Integer> bucket : buckets) {
				for (int e : bucket) {
					a[j++] = e;
				}
			}
			buckets.forEach(List::clear);
		}
	}

	private int getTotalDigits(int n) {
		int i = 1;
		while ((n /= 10) > 0)
			i++;
		return i;
	}

	private int getSpecifyDigitValue(int n, int i) {
		int digits = getTotalDigits(n);
		if (i > digits) {
			return 0;
		}
		int r = getLastDigit(n / (int) Math.pow(10, i - 1));
		return r;
	}

	private int getLastDigit(int n) {
		for (int i = 0; i < 10; i++) {
			if ((n + i) % 10 == 0) {
				return (10 - i) % 10;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		new RadixSort().sort();
	}
}
