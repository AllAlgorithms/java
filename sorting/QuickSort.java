
public class QuickSort {
	public static void main(String[] args) {

		int arr[] = { 15, 10, 5, 55, 40, 60, 85, 25, 30, 15, 50 };
		quickSort(arr, 0, arr.length - 1);
		for (int val : arr) {
			System.out.print(val + " ");
		}

	}

	private static void quickSort(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			return;
		}

		int mid = (lo + hi) / 2;

		int pivot = arr[mid];

		int left = lo;
		int right = hi;

		while (left <= right) {

			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {

				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;

				left++;
				right--;

			}
		}

		quickSort(arr, lo, right);
		quickSort(arr, left, hi);
	}
}
