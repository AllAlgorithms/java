public class QuickSort {

	public static void main(String[] args) {

		int[] arr = { 20, 10 };
		// int[] arr = { 2, 8, 1, 0, 7, 3, 9, 5 };

		quickSort(arr, 0, arr.length - 1);
		for (int val : arr) {
			System.out.print(val + " ");
		}
		System.out.println(".");
	}

	public static void quickSort(int[] arr, int lo, int hi) {

		if (lo > hi) {
			return;
		}

		int pivot = arr[hi];
		int pivotidx = partitioning(arr, pivot, lo, hi);
		quickSort(arr, lo, pivotidx - 1);
		quickSort(arr, pivotidx + 1, hi);

	}

	public static int partitioning(int[] arr, int pivot, int lo, int hi) {

		int pidx = lo;
		int itr = lo;

		// 0 to pidx - 1 --> <= pivot
		// pidx to itr - 1 --> > pivot

		while (itr <= hi) {

			if (arr[itr] <= pivot) {
				int temp = arr[pidx];
				arr[pidx] = arr[itr];
				arr[itr] = temp;
				pidx++;
				itr++;
			} else {
				itr++;
			}

		}

		return pidx - 1;
	}
}