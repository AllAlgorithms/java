package com.company;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = input.nextInt();
        int[] array = new int[size];
        int search;
        int start = 0;
        int end = size;
        int mid;
        boolean found = false;
        //Enter elements in array
        for (int i = 0; i < size; ++i){
            System.out.print("Enter element: ");
            array[i] = input.nextInt();
        }

        System.out.println("Enter element which you want to search: ");
        search = input.nextInt();
        while ((!found) && (start <= end)){
            mid = (start+end)/2;
            if (search == array[mid]){
                found = true;
            }
            else {
                if (search > array[mid]){
                    start = mid + 1;
                }
                else {
                    end = mid - 1;
                }
            }
            if (found){
                System.out.print("Element found");
            }
        }
    }
}
