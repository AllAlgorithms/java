import java.util.*;
import java.io.*;


abstract class Heap{
	protected int capacity;
	protected int size;
	protected int []items;
	
	public Heap()
	{
		this.capacity = 10;
		this.size = 0;
		this.items = new int[capacity];
	}
	
	public int getLeftChildIndex(int parentindex){
		return 2*parentindex+1;
	}

	public int getRightChildIndex(int parentindex){
		return 2*parentindex+2;
	}
	
	public int getParentIndex(int childIndex){
		return (childIndex-1)/2;
	}
	
	public boolean hasLeftChild(int parentindex)
	{
		return getLeftChildIndex(parentindex) < size;
	}
	
	
	public boolean hasRightChild(int parentindex)
	{
		return getRightChildIndex(parentindex) < size;
	}
	
	public boolean hasParent(int index){
		return getParentIndex(index) >= 0;
	}
	
	public int leftChild(int parentindex){
		return items[getLeftChildIndex(parentindex)];
	}
	
	public int rightChild(int parentindex){
		return items[getRightChildIndex(parentindex)];
	}

	public int parent(int index)
	{
		return items[getParentIndex(index)];
	}
	
	public void swap(int indexone,int indextwo){
		int temp = items[indexone];
		items[indexone] = items[indextwo];
		items[indextwo] = temp;
	}
	
	public void add(int item)
	{
		items[size] = item;
		size++;
		heapifyUp();
	}
	public void isEmpty(String name)
	{
		if(size == 0)
		{
			System.out.println(name+"cant poll");
		}
	}
	
	public int poll()
	{
		isEmpty("its empty");
		
		int item = items[0];
		items[0] = items[size-1];
		size--;
		
		heapifyDown();
		return item;
	}
	
	public void print()
	{
		for(int i=0;i<size;i++)
		{
			System.out.print(items[i]);
		}
	}
	
	public abstract void heapifyDown();
	
	public abstract void heapifyUp();
	
}
class MaxHeap extends Heap
{
	public void heapifyDown()
	{
		int index = 0;
		
		while(hasLeftChild(index)){
			int smallerChildIndex = getLeftChildIndex(index);
			
			if(hasRightChild(index) && rightChild(index) > leftChild(index))
			{
				smallerChildIndex = getRightChildIndex(index);
			}
			
			if(items[index] > items[smallerChildIndex])
			{
				break;
			}
			else{
					swap(index,smallerChildIndex);
			}
			index = smallerChildIndex;
		}
	}
	
	
	public void heapifyUp()
	{
		int index = size - 1;
		while(hasParent(index) && parent(index) < items[index]){
			swap(getParentIndex(index),index);
			index = getParentIndex(index);
		}
	}
	
	public static void main(String []args)
	{
		Scanner ob = new Scanner(System.in);
		int n = ob.nextInt();
		Heap myHeap = new MaxHeap();
		for(int i=0;i<n;i++)
		{
			myHeap.add(ob.nextInt());
		}
		
		myHeap.print();
		System.out.println("Element removed:"+myHeap.poll());
		myHeap.print();
	}
}

