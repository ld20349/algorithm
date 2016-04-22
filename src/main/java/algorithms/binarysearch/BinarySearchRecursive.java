package algorithms.binarysearch;

public class BinarySearchRecursive {
	public static int binarySearch(int[] a, int key) {
		return binarySearch(a, 0, a.length - 1, key);
	}

	private static int binarySearch(int[] a, int start, int end, int key) {
		if (start > end)
			return -1;
		int mid = start + (end - start) / 2; // 直接平均可能会溢出，所以用此算法
		if (a[mid] > key)
			return binarySearch(a, start, mid - 1, key);
		if (a[mid] < key)
			return binarySearch(a, mid + 1, end, key);
		return mid; // 最后检测相等是因为多数搜寻状况不是大于就是小于
	}

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(binarySearch(a, -5));
	}
}
