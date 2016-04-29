package algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 基数排序，稳定，最差时间复杂度O(n)，最优时间复杂度O(n)，平均时间复杂度O(n)，需要辅助空间O(k)，k为桶的数量
 * 
 * @author liuduo
 *
 */
public class RadixSort extends Sort {

	@Override
	public void sort(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++)
			if (a[i] > max)
				max = a[i];
		int digits = 1;
		while ((max /= 10) > 0)
			digits++;
		@SuppressWarnings("unchecked")
		List<Integer>[] buckets = new List[10];
		for (int i = 0; i < buckets.length; i++)
			buckets[i] = new ArrayList<>();
		for (int i = 1; i <= digits; i++) {
			for (int e : a)
				buckets[e / (int) Math.pow(10, i - 1) % 10].add(e);
			int j = 0;
			for (List<Integer> b : buckets)
				for (int e : b)
					a[j++] = e;
			Arrays.stream(buckets).forEach(List::clear);
		}
	}

	public static void main(String[] args) {
		new RadixSort().sort();
	}
}
