package algorithms.binarysearch;

public class BinarySearchNonRecursive {
	public static int binarySearch(int[] a, int key) {
		int start = 0;
		int end = a.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2; // 直接平均可能会溢出，所以用此算法
			if (a[mid] < key)
				start = mid + 1;
			else if (a[mid] > key)
				end = mid - 1;
			else
				return mid; // 最后检测相等是因为多数搜寻状况不是大于就是小于
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(binarySearch(a, -11));
	}
}
