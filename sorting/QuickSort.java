
// Quick Sort implementation in Java  by Neville Antony

class QuickSort 
{ 
    int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            if (arr[j] <= pivot) 
            { 
                i++; 
                int tmp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = tmp; 
            } 
        } 

        int tmp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = tmp; 
  
        return i+1; 
    } 
  

    void sort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 

            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 

    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
  
    public static void main(String args[]) 
    { 
        int arr[] = {89, 47, 78, 21, 76, 99, 32}; 
        int n = arr.length; 
  
        QuickSort myobj = new QuickSort(); 
        myobj.sort(arr, 0, n-1); 
  
        System.out.println("The Sorted array"); 
        printArray(arr); 
    }    	
  }
