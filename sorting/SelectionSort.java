package demos;

import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);//user input using scanner
		System.out.println("Enter the size of the array");//taking size of the array from user
		int size=sc.nextInt();
		
		int array[]=new int[size];//declaring array of n elements to be sorted
		System.out.println("Enter"+ size + "elements to sort");
		for(int i=0;i<size;i++)//taking array elements from user and storing them in array
		{
			array[i]=sc.nextInt();
		}
		
		System.out.println("Array before sort");
		for(int i=0;i<size;i++)//taking array elements from user and storing them in array
		{
			System.out.print(array[i]+ " ");//Printing elements of array before sorting in a single line
		}
		
		SelectionSorting(array);
	}
	
	public static void SelectionSorting(int array[]){
		
		for(int i=0;i<array.length;i++)
		{
			for(int j=i+1;j<array.length;j++)
			{
				if(array[i]>array[j])//if i'th element of array is greater than j'th element swap the elements
				{
					int temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		
		System.out.println("Array after sorting");
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i]+ " ");//Printing elements of array after sorting in a single line
		}
		
	}
}
