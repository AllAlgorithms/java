public class HeapSortMinHeap<T extends Comparable<T>>{
	public T[] heapSort(T[] M) {
		int n = M.length - 1;
		for (int i = n / 2; i >= 0; i--) {
			heapify(i, n, M);
		}
		for (int i = n; i > 0; i--) {
			T h1 = M[0];
			T h2 = M[i];
			M[i] = h1;
			M[0] = h2;
			heapify(0, i - 1, M);
		}
		return M;
	}

	public T[] heapify(int i, int r, T[] M) {
		T a = M[i];
		int j = 2 * i;
		while (j <= r) {
			if (j < r && M[j + 1].compareTo(M[j]) < 0) {
				j++;
			}
			if (a.compareTo(M[j]) > 0) {
				M[i] = M[j];
				i = j;
				j = 2 * i;

			} else {
				j = r + 1;
			}
		}
		M[i] = a;
		return M;
	}

	public void sort(T[] M) {
		heapSort(M);
	}
}
