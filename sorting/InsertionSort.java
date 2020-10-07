/**
* Generic Insertion Sort
* @author Jan Tabacki
*/

public class InsertionSort<T extends Comparable<? super T>> {
    
    /**
    * Sort
    * @param T[] array of not sorted elements 
    * @return T[] array of sorted element
     */
    public T[] Sort(T[] values) {
        if (values.length > 0) {
            T value = values[0];
            for (int i = 1; i < values.length; ++i) {
                value = values[i];
                int j;
                for (j = i - 1; j >= 0 && values[j].compareTo(value) > 0; --j) {
                    values[j + 1] = values[j];
                }
                values[j + 1] = value;
            }
        }
        return values;
    }
}
