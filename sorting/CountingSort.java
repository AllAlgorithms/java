/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author miqdad
 */
public class CountingSort {

    static int[] countingSort(int[] nums, int maxNumber) {
        int[] temp = new int[maxNumber + 1];
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            while (temp[i] > 0) {
                result[index++] = i;
                temp[i]--;
            }
        }

        return result;
    }

    static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 5, 6, 7, 1, 9, 0, 8, 6 };
        nums = countingSort(nums, 10);
        printArray(nums);
    }
}
