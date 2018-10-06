/*
    Program to find a particular key in the array (Linear-search)
*/

import java.util.Scanner;

class LinearSearch{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many elements the array have?");
        System.out.print("Answer : ");
        try{
            int[] arr = new int[sc.nextInt()];
            System.out.println("Enter elements one by one");
            for(int i = 0 ; i < arr.length; i++){
                System.out.print("Enter arr["+i+"] : ");
                arr[i] = sc.nextInt();
            }
            System.out.print("Enter the key you want to find : ");
            int index = searchForKey(arr, sc.nextInt());
            if(index == -1){
                System.out.println("Sorry! Key is not in the array");
            }else{
                System.out.println("Key found on index -> "+index);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static int searchForKey(int[] arr, int key){
        /*
            This function looks for the key in the array and returns index when key found and -1 if key is not in the array.
        */
        for(int i=0; i < arr.length; i++){
            // Searching elements one by one
            if(arr[i] == key){
                //returns index if found
                return i;
            }
        }
        //if failed to find key return -1
        return -1;
    }
}