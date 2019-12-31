import java.util.ArrayList;

/**
 * Sort
 */
public class Sort {
    public static Integer iterations = 0;

    /**
     * @return the iterations of most recently used sorting algorithm
     */
    public static long getIterations() {
        return iterations;
    }

    /*********************************************************************
     * slectionSort Algorithm, O(n^2)
     * @param <E> generic E
     * @param list list to be sorted
     */
    public static <E extends Comparable<E>> void selectionSort(E[] list) {
        iterations=0;
        int minIndex;
        for (int i=0; i<list.length-1; i++) {
            iterations++;
            minIndex = findMin(list, i);
            E temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }
    /**
     * findMin for selectionSort
     * @param <E> gneric E
     * @param list list to be sorted
     * @param start beginning index
     * @return the index of the min value
     */
    public static <E extends Comparable<E>> int findMin(E[] list, int start){
        E min = list[start]; int index = start;
        for (int i=start; i<list.length; i++){
            iterations++;
            if (list[i].compareTo(min) < 0){
                min = list[i];
                index = i;
            }
        }
        return index;
    }

    /*********************************************************************
     * insertionSort alogrithm, O(n^2)
     * @param list list to be sorted
     */
    public static <E extends Comparable<E>> void insertionSort(E[] list) {
        iterations=0;
        for(int i=1; i<list.length;i++) {
            iterations++;
            insert(list, i);
        }
    }
    /**
     * insert method to insert a new member and move the
     * array in conjunction
     * @param list list being sorted
     * @param i current position
     */
    private static <E extends Comparable<E>> void insert(E[] list, int i) {
        E currentVal = list[i];
        while(i>0 && currentVal.compareTo(list[i-1]) > 0) {
            iterations++;
            list[i]=list[i-1];
            i--;
        }
        list[i]=currentVal;
    }

    /*********************************************************************
     * bubbleSort algorithm, O(n^2)
     * An exchange category sort
     * @param list list to be sorted
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        iterations=0;
        boolean sorted = false;
        for(int k=1; k<list.length && !sorted; k++) {
            iterations++;
            sorted =true;
            for(int i=0; i<list.length-k; i++){
                iterations++;
                if(list[i].compareTo(list[i+1]) > 0) {
                    iterations++;
                    //swap
                    E temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    /*********************************************************************
     * mergeSort algorithm, O(n log n) - log linear
     * @param list list to be sorted
     */
    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        iterations=0;
        if(list.length > 1) {   //base case
            iterations++;
            Comparable[] firstHalf = new Comparable[list.length/2];
            Comparable[] secondHalf = new Comparable[list.length-list.length/2];
            System.arraycopy(list, 0, firstHalf, 0, list.length/2);
            System.arraycopy(list, list.length/2, secondHalf, 0, list.length-list.length/2);
            mergeSort(firstHalf);
            mergeSort(secondHalf);
            merge((E[])firstHalf, (E[])secondHalf, list);
        }
    }
    /**
     * merge method for mergeSort
     * @param list1 the first list split from the parent method
     * @param list2 the second list split from the main method
     * @param list the final combined and sorted list
     */
    public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] list) {
        int list1Index=0;
        int list2Index=0;
        int listIndex=0;
        while(list1Index<list1.length && list2Index<list2.length) {
            iterations++;
            if(list1[list1Index].compareTo(list2[list2Index]) < 0) {
                iterations++;
                list[listIndex++] = list1[list1Index++];
            } else {
                iterations++;
                list[listIndex++] = list2[list2Index++];
            }
        }
        while(list1Index<list1.length) {
            iterations++;
            list[listIndex++] = list1[list1Index++];
        }
        while(list2Index<list2.length) {
            iterations++;
            list[listIndex++] = list2[list2Index++];
        }
    }

    /*********************************************************************
     * quickSort algorithm, O(n log n), average case | O(n^2), worst case
     * quickSort is a recursive sorting algorithm
     * @param list list to be sorted
     */
    public static <E extends Comparable<E>> void quickSort(E[] list) {
        iterations=0;
        quickSort(list, 0, list.length-1);
    }

     /**
      * quickSort overloaded method to partition the list recursively
      * @param list list to be sorted
      * @param first first member
      * @param last last member
      */
    public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
        if(last>first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex-1);
            quickSort(list, pivotIndex+1, last);
        }
    }
    /**
     * partition method for parent quickSort parent method
     * @param list list to be sorted
     * @param first first member of the array, set as pivot
     * @param last last member of the array
     * @return small index
     */
    public static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
        E pivot;
        int index, smallIndex;
        pivot = list[first];    //pivot is first element
        smallIndex = first;
        for(index=first+1; index<=last; index++) {
            iterations++;
            if (list[index].compareTo(pivot) < 0) {
                smallIndex++;
                swap(list, smallIndex, index);
            }
            swap(list, first, smallIndex);
        }
        return smallIndex;
    }
    /**
     * swaps two indecies within a list
     * @param list list being modified
     * @param a first index
     * @param b second index
     * @return modified list
     */
    private static <E extends Comparable<E>> E[] swap(E[] list, int a, int b) {
        iterations++;
        E temp = list[a];
        list[a] = list[b];
        list[b] = temp;
        return list;
    }

    /*********************************************************************
     * bucketSort alogrithm / radixSort algorithm O(d.n)
     *  Creating the bucket -> O(t)
     *  Distributing data to buckets -> O(n)
     *  Move data from buckets to list -> O(n)
     * Time Complexity: O(n+t)
     * Space Complexity: O(n+t)
     * not desireable for large t
     * @param list
     * @param t
     */
    public static void bucketSort(Integer[] list, int t) {
        iterations=0;
        ArrayList<ArrayList<Integer>> buckets;
        buckets = new ArrayList<>(t+1);
        for(int i=0; i<t+1; i++) {
            iterations++;
            buckets.add(new ArrayList<>());
        }
        //distribute data on buckets
        for(int i=0; i<list.length; i++) {
            iterations++;
            ArrayList<Integer> bucket = buckets.get(list[i]);
            bucket.add(list[i]);
            buckets.set(list[i], bucket);
        }
        //move data from the buckets back to the list
        int k = 0;
        for(int i=0; i<buckets.size(); i++) {
            iterations++;
            ArrayList<Integer> bucket = buckets.get(i);
            for(int j=0; j<bucket.size(); j++) {
                iterations++;
                list[k++] = bucket.get(j);
            }

        }

    }

    /*********************************************************************
     * radixSort algorithm
     * Classifying data into buckets O(n)
     * Classifying for each position O(d)
     * Time Complexity O(d.n)
     *  
     * @param list
     * @param t
     */
    public static void radixSort(Integer[] list) {
        iterations=0;
        ArrayList<ArrayList<Integer>> buckets;
        buckets = new ArrayList<>(10);
        for(int i=0; i<10; i++) {
            iterations++;
            buckets.add(new ArrayList<>());
        }
        //distribute data on buckets
        int max = getMax(list);

        for (int exp=1; max/exp>0; exp*=10){
            for(int i=0; i<list.length; i++) {
                iterations++;
                int bucketNum = (list[i]/exp)%10;
                buckets.get(bucketNum).add(list[i]);
            }
            int k = 0;
            for(int i=0; i<buckets.size(); i++) {
                iterations++;
                ArrayList<Integer> bucket = buckets.get(i);
                for(int j=0; j<bucket.size(); j++) {
                    iterations++;
                    list[k++] = bucket.get(j);
                }
            }
            for(int i=0; i<buckets.size();i++) {
                iterations++;
                buckets.get(i).clear();
            }
        }
        //move data from the buckets back to the list
    }

    public static int getMax(Integer[]list) {
        int max = list[0];
        for (int i=0; i<list.length;i++) {
            iterations++;
            if (list[i] > max) {
                max = list[i];
            }
        }
        return max;
    }

    /*********************************************************************
     * heapSort alogrithm, O(n) main task, O(n log n) time complexity
     * @param <E> generic class E
     * @param list list of type E
     * @return the iterations
     */
    public static <E extends Comparable<E>> long heapSort(E[] list) {
        iterations=0;
        Heap<E> heap = new Heap<>(list);
        for(int i=list.length-1;i>=0; i--) {
            iterations++;
            list[i] = heap.remove();
        }
        iterations += heap.getIterations();
        return iterations;
    }

}