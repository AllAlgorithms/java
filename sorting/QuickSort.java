/**
 * Java implementation of quick sort
 *
 * @author Tibeyev Timur (timurtibeyev@gmail.com)
 */

public class QuickSort {

    /**
     * Method responsible for sorting array.
     *
     * @param arr   array of elements
     * @param left  start of the segment to sort
     * @param right end of the segment to sort
     */
    private void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;

        int mid = (i + j) / 2;
        // Pivot element
        int v = arr[mid];

        while (i < j) {
            // Find element from the left side, which is equal or greater than pivot element
            while (arr[i] < v) {
                i++;
            }

            // Find element from the right side, which is equal or less than pivot element
            while (v < arr[j]) {
                j--;
            }

            // If such elements exist, perform swapping
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        // Recursively sort left subarray
        sort(arr, left, j);
        // Recursively sort right subarray
        sort(arr, i, right);
    }

    /**
     * Swaps two elements.
     *
     * @param arr array of elements
     * @param i   first index
     * @param j   second index
     */
    private void swap(int[] arr, int i, int j) {
        int buf = arr[i];
        arr[i] = arr[j];
        arr[j] = buf;
    }

    /**
     * Entry point, invokes sorting methods and prints resulting array.
     *
     * @param arr array to sort
     */
    public void run(int[] arr) {
        sort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    /**
     * Utility method to print array.
     *
     * @param arr array to print
     */
    private void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * {@code Main} method. Initializes {@link QuickSort} object and passes simple
     * array to sort.
     *
     * @param args cmd arguments
     */
    public static void main(String args[]) {
        int arr[] = { 100, 19, 23, 1, 4, 23, 66 };
        new QuickSort().run(arr);
    }
}