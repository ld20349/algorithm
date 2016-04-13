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
		int digits = 1;
		while ((max /= 10) > 0)
			digits++;
		for (int i = 1; i <= digits; i++) {
			for (int e : a) {
				buckets.get((e / (int) Math.pow(10, i - 1)) % 10).add(e);
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

	public static void main(String[] args) {
		new RadixSort().sort();
	}
}
