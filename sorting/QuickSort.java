import java.util.Random;

public class QuickSort {

    static int []array;

    static void Sort(int begin, int end){
        if(begin < end){
            int partition = Partition(begin,end);
            Sort(begin,partition - 1);
            Sort(partition,end);
        }
    }

    static int Partition(int begin,int end){
        int i = begin;
        int j = end;
        int pivot = array[(i + j) /2];
        while(i <= j){
            while(array[i] < pivot) i++;
            while(array[j] > pivot) j--;
            if(i <= j){
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }

    public static void main(String []args){
        Random rand = new Random();
        array = new int[10];

        for(int i = 0 ; i < array.length ; i++){
            array[i] = rand.nextInt(50);
        }

        Sort(0,array.length - 1);

        for(int number : array){
            System.out.print(number + " ");
        }
    }
}
