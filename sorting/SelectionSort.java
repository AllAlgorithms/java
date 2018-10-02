/**
 * Java implementation of merge sort
 *
 * @author Dimitris Glynatsis
 * @email dim.glynatsis@gmail.com
 */

public class SelectionSort {
    static void selection(int[] a, int left, int right) {
        for (int i = left; i < right; i++) {
            int min = i;
            for (int j = i + 1; j <= right; j++)
                if (a[j] < a[min])
                    min = j;
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = { 5, 4, 6, 1, 3, 8 };

        SelectionSort s = new SelectionSort();
        s.selection(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }
}