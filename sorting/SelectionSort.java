/*
  Selection Sort according to wiki psuedocode
  https://en.wikipedia.org/wiki/Selection_sort
*/
import java.util.Arrays;

public class SelectionSort {
  static void selectionSort(int arr[]) {
    int min, temp;
    int len = arr.length;

    for (int i = 0; i < len-1; i++) {
      min = i;
      for (int j = i+1; j < len; j++) {
        if (arr[j] < arr[min]) {
          min = j;
        }
      }
      if (min != i) {
        temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
      }
    }
  }

  public static void main(String[] args) {
    int[] array = { 7, 9, 5, 1, 3 };
    System.out.println(Arrays.toString(array));

    selectionSort(array);
    System.out.println(Arrays.toString(array));
  }
}
