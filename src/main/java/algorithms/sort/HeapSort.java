package algorithms.sort;

/**
 * 堆排序，不稳定
 * 
 * @author liuduo
 *
 */
public class HeapSort extends Sort {

	@Override
	public void sort(int[] a) {
		MaxHeap mh = new MaxHeap(a);
		mh.buildMaxHeap();
		mh.heapSort();
	}

	public static void main(String[] args) {
		new HeapSort().sort();
	}
}

class MaxHeap {
	int[] heap;
	int size;

	public MaxHeap(int[] heap) {
		this.heap = heap;
		this.size = heap.length;
	}

	public int parent(int i) {
		return (i - 1) / 2;
	}

	public int left(int i) {
		return 2 * i + 1;
	}

	public int right(int i) {
		return 2 * i + 2;
	}

	public void buildMaxHeap() {
		for (int i = size / 2 - 1; i >= 0; i--) {
			maxify(i);
		}
	}

	private void maxify(int i) {
		int l = left(i);
		int r = right(i);
		int largest;
		if (l < size && heap[l] > heap[i]) {
			largest = l;
		} else {
			largest = i;
		}
		if (r < size && heap[r] > heap[largest]) {
			largest = r;
		}
		if (largest == i || largest >= size) {
			return;
		}
		int t = heap[i];
		heap[i] = heap[largest];
		heap[largest] = t;
		maxify(largest);
	}

	public void heapSort() {
		for (int i = 0; i < heap.length; i++) {
			int t = heap[0];
			heap[0] = heap[size - 1];
			heap[size - 1] = t;
			size--;
			maxify(0);
		}
	}
}
