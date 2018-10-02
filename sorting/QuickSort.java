/**
 * Java implementation of quick sort
 *
 * @author Dimitris Glynatsis
 * @email dim.glynatsis@gmail.com
 */

public class QuickSort {
    /*
     * If the array has less than 1 elements, the algorithm stops. Else the array is
     * modified using the partition method that puts a[i] in its position, for all i
     * between left and right, and reorders the rest so the recursive calls complete
     * the sorting accordingly
     */
    static void quicksort(int[] a, int left, int right) {
        if (right <= left)
            return;
        int i = partition(a, left, right);
        quicksort(a, left, i - 1);
        quicksort(a, i + 1, right);
    }

    /*
     * The variable v is asigned the value of a[right] and i,j are the left and
     * right indexes. the partition loop increases i and decreases j, while not
     * changing the property that no element that s left from i is bigger than v and
     * no element that is right from j is less than v. When the two indexes meet, we
     * complete the partition swapping a[i] with a[r], an action that results in
     * putting v in a[i] without having larger elements right from v and smaller
     * left from it The partition loop is implemented as an infinite loop and breaks
     * when the indexes meet.
     */
    static int partition(int[] a, int left, int right) {
        int i = left - 1, j = right, v = a[right];
        while (true) {
            while (a[++i] < v)
                ;
            while (v < a[j]) {
                j--;
                if (j == left)
                    break;
            }
            if (i >= j)
                break;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        int temp = a[i];
        a[i] = a[right];
        a[right] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] a = { 5, 1, 3, 6, 7, 9, 6, 212 };
        QuickSort q = new QuickSort();
        q.quicksort(a, 0, a.length - 1);
        int i;
        for (i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }
}