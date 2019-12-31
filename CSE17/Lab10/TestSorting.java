import java.util.ArrayList;
import java.util.Random;

/**
 * @author Ralph Haddad
 * TestSorting
 */
public class TestSorting {
    public static void main(String[] args) {
        Random myRandom = new Random();
        ArrayList<Integer>numArrL = new ArrayList<>();
        Integer [] arrL = new Integer[10000];
        for (int i=0; i<10000; i++) {
            Integer ran = myRandom.nextInt(10000);
            if(numArrL.contains(ran)) {
                i--;
            } else {
                numArrL.add(ran);
            }
        }
        for (int i=0; i<numArrL.size();i++) {
            arrL[i] = numArrL.get(i);
        }
        System.out.println("10000 numbers shuffled\n");
        //An array list of 100000 gives me an error and
        //for the life of me i dont know why...
        //finding runtimes and iterations
        long selectionStartTime = System.nanoTime();
        Sort.selectionSort(arrL);
        long selectionEndTime = System.nanoTime();
        long selectionIter = Sort.iterations;
        long selectionTime = selectionEndTime - selectionStartTime;

        long insertStartTime = System.nanoTime();
        Sort.insertionSort(arrL);
        long insertEndTime = System.nanoTime();
        long insertIter = Sort.iterations;
        long insertTime = insertEndTime - insertStartTime;

        long bubbleStartTime = System.nanoTime();
        Sort.bubbleSort(arrL);
        long bubbleEndTime = System.nanoTime();
        long bubbleIter = Sort.iterations;
        long bubbleTime = bubbleEndTime - bubbleStartTime;

        long mergeStartTime = System.nanoTime();
        Sort.mergeSort(arrL);
        long mergeEndTime = System.nanoTime();
        long mergeIter = Sort.iterations;
        long mergeTime = mergeEndTime - mergeStartTime;

        long quickStartTime = System.nanoTime();
        Sort.quickSort(arrL);
        long quickEndTime = System.nanoTime();
        long quickIter = Sort.iterations;
        long quickTime = quickEndTime - quickStartTime;

        long bucketSortTime = System.nanoTime();
        Sort.bucketSort(arrL, 10000);
        long bucketEndTime = System.nanoTime();
        long bucketIter = Sort.iterations;
        long bucketTime = bucketEndTime - bucketSortTime;

        long radixStartTime = System.nanoTime();
        Sort.radixSort(arrL);
        long radixEndTime = System.nanoTime();
        long radixIter = Sort.iterations;
        long radixTime = radixEndTime - radixStartTime;

        long heapStartTime = System.nanoTime();
        Sort.heapSort(arrL);
        long heapEndTime = System.nanoTime();
        long heapIter = Sort.iterations;
        long heapTime = heapEndTime - heapStartTime;



        
        
        System.out.printf("%-10s\t%-10s\t%-10s\n\n", "Sorting Alogrithm", "Number of Iterations", "Execution Time(ns)");
        System.out.printf("%-10s\t\t%-10d\t\t%-10d\n", "Selection Sort", selectionIter, selectionTime);
        System.out.printf("%-10s\t\t%-10d\t\t%-10d\n", "Insertion Sort", insertIter, insertTime);
        System.out.printf("%-10s\t\t%-10d\t\t%-10d\n", "Bubble Sort", bubbleIter, bubbleTime);
        System.out.printf("%-10s\t\t%-10d\t\t%-10d\n", "Quick Sort", quickIter, quickTime);
        System.out.printf("%-10s\t\t%-10d\t\t%-10d\n", "Bucket Sort", bucketIter, bucketTime);
        System.out.printf("%-10s\t\t%-10d\t\t%-10d\n", "Radix Sort", radixIter, radixTime);
        System.out.printf("%-10s\t\t%-10d\t\t%-10d\n", "Heap Sort", heapIter, heapTime);


    
    }

}