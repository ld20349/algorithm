package algorithms.sort;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;

public abstract class Sort {
	public static int[] a = { 5, 3, 2, 8, 9, 1, 6, 4, 0, 7 };
	public static int[] b;
	static {
		try {
			b = ArrayUtils.toPrimitive(FileUtils
					.readLines(new File("integers.txt")).stream()
					.map(Integer::parseInt).collect(Collectors.toList())
					.toArray(new Integer[0]));
		} catch (IOException e) {
			e.printStackTrace();
			b = Arrays.copyOf(a, a.length);
		}
	}

	protected void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public abstract void sort(int[] a);

	public void sort() {
		int[] a1 = Arrays.copyOf(a, a.length);
		int[] a2 = Arrays.copyOf(a, a.length);
		Arrays.sort(a1);
		sort(a2);
		if (!Arrays.equals(a1, a2)) {
			System.out.println("排序方法有误：" + Arrays.toString(a2));
			return;
		}
		int[] b1 = Arrays.copyOf(b, b.length);
		int[] b2 = Arrays.copyOf(b, b.length);
		long t1 = System.currentTimeMillis();
		Arrays.sort(b1);
		long t2 = System.currentTimeMillis();
		sort(b2);
		long t3 = System.currentTimeMillis();
		if (Arrays.equals(b1, b2)) {
			System.out.println("库函数排序时间为：" + (t2 - t1) + "毫秒");
			System.out.println("自实现排序时间为：" + (t3 - t2) + "毫秒");
		} else {
			System.out.println("排序方法有误");
		}
	}

	public static void genRandomIntegers() throws IOException {
		final int size = 100000;
		List<Integer> list = new ArrayList<>(size);
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			list.add(random.nextInt(size));
		}
		FileUtils
				.writeLines(
						new File("integers.txt"),
						list.stream().map(String::valueOf)
								.collect(Collectors.toList()));
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(Arrays.copyOfRange(b, 0, 10)));
	}
}
