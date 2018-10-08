public class BinarySearchRecursive {
 
    public static int binarySearch(int[] arr, int toSearch, int start, int end) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (arr[mid] > toSearch) {
            return binarySearch(arr, toSearch, start, mid - 1);
        } else if (arr[mid] < toSearch) {
            return binarySearch(arr, toSearch, mid + 1, end);
        }
        return mid;
    }
 
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 7, 8, 11};
        int toSearch = 8;
 
        int index = binarySearch(arr, toSearch, 0, arr.length);
 
        if (index == -1) {
            System.out.println(toSearch + " not found");
        } else {
            System.out.println(toSearch + " found at index " + index);
        }
    }
}