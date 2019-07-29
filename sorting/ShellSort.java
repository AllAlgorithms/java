/**
 * Java implementation of merge sort
 *
 * @author Dimitris Glynatsis
 * @email dim.glynatsis@gmail.com
 */

public class ShellSort {

    static void shell(int[] a) {
        int l = 0, r = a.length - 1, h;
        for (h = 0; h <= (r - 1) / 9; h = 3 * h + 1)
            ;
        for (; h > 0; h /= 3)
            for (int i = l + h; i <= r; i++) {
                int j = i, v = a[i];
                while (j >= l + h && v < a[j - h]) {
                    a[j] = a[j - h];
                    j -= h;
                }
                a[j] = v;
            }
    }

    public static void main(String[] args) {
        int[] a = { 5, 6, 4, 9, 13, 3, 7 };
        
        ShellSort s = new ShellSort();

        s.shell(a);

        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

}