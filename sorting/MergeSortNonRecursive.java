public class NonRecursiveMergeSort<T extends Comparable<T>> {

	public T[] MergeSort(T[] M) {

		int length = M.length;
		int size = 1;
		int p;
		while (size < length) {
			p = -1;
			while (p + size < length) {
				int left = p + 1;
				int right = left + size - 1;
				if (right + size <= length) {
					p = right + size;
				} else {
					p = length;
				}
				merge(M, left, right, p);
			}
			size = size * 2;
		}

		return M;

	}


	public T[] merge(T[] M, int left, int right, int p) {
		int i = left;
		int j = right + 1;
		int k = left;
		T[] M2 = M.clone();
		for (int n = 0; n < M.length; n++) {
			M2[n] = null;
		}
		while (i <= right && j <= p) {
			if (M[i].compareTo(M[j]) <= 0) {
				M2[k] = M[i];
				i = i + 1;
			} else {
				M2[k] = M[j];
				j = j + 1;
			}
			k = k + 1;
		}
		for (int h = i; h <= right; h++) {
			M[k + (h - i)] = M[h];
		}
		for (int h = left; h <= (k - 1); h++) {
			M[h] = M2[h];
		}
		return M;

	}

}
