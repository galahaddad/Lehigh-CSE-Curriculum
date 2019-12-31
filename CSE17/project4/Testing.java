import java.util.Random;
import java.util.ArrayList;

/**
 * @author Ralph Haddad
 * Testing
 */
public class Testing {

    public static void main(String[] args) {
        ArrayList<Integer> randomized = new ArrayList<>();
        ArrayList<Integer> fullSort = new ArrayList<>();
        ArrayList<Integer> quarterSort = new ArrayList<>();
        ArrayList<Integer> halfSort = new ArrayList<>();
        ArrayList<Integer> tqSort = new ArrayList<>();
        ArrayList<Integer> invertSort = new ArrayList<>();
        
        Sort.selectionSort(randomized());
        randomized.add(Sort.iterations);
        Integer [] arrayRE = fullysorted(randomized()); 
        Sort.selectionSort(arrayRE);
        fullSort.add(Sort.iterations);
        Sort.selectionSort(fourthShuffled(fullysorted(randomized())));
        quarterSort.add(Sort.iterations);
        Sort.selectionSort(halfShuffled(arrayRE));
        halfSort.add(Sort.iterations);
        Sort.selectionSort(threeQuartersShuffled(arrayRE));
        tqSort.add(Sort.iterations);
        Sort.selectionSort(inverted(arrayRE));
        invertSort.add(Sort.iterations);

        Sort.insertionSort(randomized());
        randomized.add(Sort.iterations);
        arrayRE = fullysorted(randomized()); 
        Sort.insertionSort(arrayRE);
        fullSort.add(Sort.iterations);
        Sort.insertionSort(fourthShuffled(fullysorted(randomized())));
        quarterSort.add(Sort.iterations);
        Sort.insertionSort(halfShuffled(arrayRE));
        halfSort.add(Sort.iterations);
        Sort.insertionSort(threeQuartersShuffled(arrayRE));
        tqSort.add(Sort.iterations);
        Sort.insertionSort(inverted(arrayRE));
        invertSort.add(Sort.iterations);

        Sort.bubbleSort(randomized());
        randomized.add(Sort.iterations);
        arrayRE = fullysorted(randomized()); 
        Sort.bubbleSort(arrayRE);
        fullSort.add(Sort.iterations);
        Sort.bubbleSort(fourthShuffled(fullysorted(randomized())));
        quarterSort.add(Sort.iterations);
        Sort.bubbleSort(halfShuffled(arrayRE));
        halfSort.add(Sort.iterations);
        Sort.bubbleSort(threeQuartersShuffled(arrayRE));
        tqSort.add(Sort.iterations);
        Sort.bubbleSort(inverted(arrayRE));
        invertSort.add(Sort.iterations);

        Sort.mergeSort(randomized());
        randomized.add(Sort.iterations);
        arrayRE = fullysorted(randomized()); 
        Sort.mergeSort(arrayRE);
        fullSort.add(Sort.iterations);
        Sort.mergeSort(fourthShuffled(fullysorted(randomized())));
        quarterSort.add(Sort.iterations);
        Sort.mergeSort(halfShuffled(arrayRE));
        halfSort.add(Sort.iterations);
        Sort.mergeSort(threeQuartersShuffled(arrayRE));
        tqSort.add(Sort.iterations);
        Sort.mergeSort(inverted(arrayRE));
        invertSort.add(Sort.iterations);

        Sort.quickSort(randomized());
        randomized.add(Sort.iterations);
        arrayRE = fullysorted(randomized()); 
        Sort.quickSort(arrayRE);
        fullSort.add(Sort.iterations);
        Sort.quickSort(fourthShuffled(fullysorted(randomized())));
        quarterSort.add(Sort.iterations);
        Sort.quickSort(halfShuffled(arrayRE));
        halfSort.add(Sort.iterations);
        Sort.quickSort(threeQuartersShuffled(arrayRE));
        tqSort.add(Sort.iterations);
        Sort.quickSort(inverted(arrayRE));
        invertSort.add(Sort.iterations);

        Sort.bucketSort(randomized(), 1000);
        randomized.add(Sort.iterations);
        arrayRE = fullysorted(randomized()); 
        Sort.bucketSort(arrayRE, 1000);
        fullSort.add(Sort.iterations);
        Sort.bucketSort(fourthShuffled(fullysorted(randomized())), 1000);
        quarterSort.add(Sort.iterations);
        Sort.bucketSort(halfShuffled(arrayRE), 1000);
        halfSort.add(Sort.iterations);
        Sort.bucketSort(threeQuartersShuffled(arrayRE), 1000);
        tqSort.add(Sort.iterations);
        Sort.bucketSort(inverted(arrayRE), 1000);
        invertSort.add(Sort.iterations);

        Sort.heapSort(randomized());
        randomized.add(Sort.iterations);
        arrayRE = fullysorted(randomized()); 
        Sort.heapSort(arrayRE);
        fullSort.add(Sort.iterations);
        Sort.heapSort(fourthShuffled(fullysorted(randomized())));
        quarterSort.add(Sort.iterations);
        Sort.heapSort(halfShuffled(arrayRE));
        halfSort.add(Sort.iterations);
        Sort.heapSort(threeQuartersShuffled(arrayRE));
        tqSort.add(Sort.iterations);
        Sort.heapSort(inverted(arrayRE));
        invertSort.add(Sort.iterations);

        System.out.printf("%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\t%-10s\n\n", "Sorting", "Random", "Sorted", "25%", "50%", "75%", "Inverted");
        System.out.printf("%-10s\t%-10d\t%-10d\t%-10d\t%-10d\t%-10d\t%-10d", "Selection Sort", randomized.get(0), fullSort.get(0), quarterSort.get(0), halfSort.get(0), tqSort.get(0), invertSort.get(0));
        System.out.printf("%-10s\t%-10d\t%-10d\t%-10d\t%-10d\t%-10d\t%-10d", "Insertion Sort", randomized.get(1), fullSort.get(1), quarterSort.get(1), halfSort.get(1), tqSort.get(1), invertSort.get(1));
        System.out.printf("%-10s\t%-10d\t%-10d\t%-10d\t%-10d\t%-10d\t%-10d", "Bubble Sort", randomized.get(2), fullSort.get(2), quarterSort.get(2), halfSort.get(2), tqSort.get(2), invertSort.get(2));
        System.out.printf("%-10s\t%-10d\t%-10d\t%-10d\t%-10d\t%-10d\t%-10d", "Merge Sort", randomized.get(3), fullSort.get(3), quarterSort.get(3), halfSort.get(3), tqSort.get(3), invertSort.get(3));
        System.out.printf("%-10s\t%-10d\t%-10d\t%-10d\t%-10d\t%-10d\t%-10d", "Quick Sort", randomized.get(4), fullSort.get(4), quarterSort.get(4), halfSort.get(4), tqSort.get(4), invertSort.get(4));
        System.out.printf("%-10s\t%-10d\t%-10d\t%-10d\t%-10d\t%-10d\t%-10d", "Bucket Sort", randomized.get(5), fullSort.get(5), quarterSort.get(5), halfSort.get(5), tqSort.get(5), invertSort.get(5));
        System.out.printf("%-10s\t%-10d\t%-10d\t%-10d\t%-10d\t%-10d\t%-10d", "Radix Sort", randomized.get(6), fullSort.get(6), quarterSort.get(6), halfSort.get(6), tqSort.get(6), invertSort.get(6));
        System.out.printf("%-10s\t%-10d\t%-10d\t%-10d\t%-10d\t%-10d\t%-10d", "Heap Sort", randomized.get(7), fullSort.get(7), quarterSort.get(7), halfSort.get(7), tqSort.get(7), invertSort.get(7));

    }

    public static Integer[] randomized() {
        Random myRandom = new Random();
        ArrayList<Integer>numArrL = new ArrayList<>();
        Integer [] arrL = new Integer[1000];
        for (int i=0; i<1000; i++) {
            Integer ran = myRandom.nextInt(1000);
            if(numArrL.contains(ran)) {
                i--;
            } else {
                numArrL.add(ran);
            }
        }
        for (int i=0; i<numArrL.size();i++) {
            arrL[i] = numArrL.get(i);
        }
        return arrL;
    }

    public static Integer[] fullysorted(Integer [] list) {  //uses bubble sort to return a fully sorted list
        boolean sorted = false;
        for(int k=1; k<list.length && !sorted; k++) {
            sorted =true;
            for(int i=0; i<list.length-k; i++){
                if(list[i] > (list[i+1])) {
                    //swap
                    Integer temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    sorted = false;
                }
            }
        }
        return list;
    }

    public static Integer[] fourthShuffled(Integer [] list) {
        Integer [] sorted = fullysorted(list);
        Random myRandom = new Random();
        ArrayList<Integer>numArrL = new ArrayList<>();
        for(int i = 0; i<sorted.length;i++) {
            numArrL.add(sorted[i]);
        }
        Integer [] arrL = new Integer[1000];
        for (int i=0; i<250; i++) {
            Integer ran = myRandom.nextInt(250);
            if(numArrL.contains(ran)) {
                i--;
            } else {
                numArrL.add(ran);
            }
        }
        for (int i=0; i<numArrL.size();i++) {
            arrL[i] = numArrL.get(i);
        }
        return arrL;
    }

    public static Integer[] halfShuffled(Integer [] list) {
        Integer [] sorted = fullysorted(list);
        Random myRandom = new Random();
        ArrayList<Integer>numArrL = new ArrayList<>();
        for(int i = 0; i<sorted.length;i++) {
            numArrL.add(sorted[i]);
        }
        Integer [] arrL = new Integer[1000];
        for (int i=0; i<500; i++) {
            Integer ran = myRandom.nextInt(500);
            if(numArrL.contains(ran)) {
                i--;
            } else {
                numArrL.add(ran);
            }
        }
        for (int i=0; i<numArrL.size();i++) {
            arrL[i] = numArrL.get(i);
        }
        return arrL;
    }

    public static Integer[] threeQuartersShuffled(Integer [] list) {
        Integer [] sorted = fullysorted(list);
        Random myRandom = new Random();
        ArrayList<Integer>numArrL = new ArrayList<>();
        for(int i = 0; i<sorted.length;i++) {
            numArrL.add(sorted[i]);
        }
        Integer [] arrL = new Integer[1000];
        for (int i=0; i<750; i++) {
            Integer ran = myRandom.nextInt(750);
            if(numArrL.contains(ran)) {
                i--;
            } else {
                numArrL.add(ran);
            }
        }
        for (int i=0; i<numArrL.size();i++) {
            arrL[i] = numArrL.get(i);
        }
        return arrL;
    }

    public static Integer[] inverted(Integer [] list) {
        for(int i=0;i<list.length/2;i++){
            for(int j=list.length;j>list.length/2;j--){
                Integer temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        return list;
    }

    /**
     * The results were near what was provided by the example in the assignment.
     *  Selection sort clearly is always running at O(n^2) every time for 
     * every algorithm regardless of how priorly sorted it is. Insertion and 
     * bubble sort, howver have case checks for wheter parts of the array are
     * sorted and it shows with the sorted column. Radix and bucket sort work 
     * at relatively the same speed, but with radix sort being slightly slower
     * due to inefficiencies with bucket numbers. Merge sort runs the same
     * iterations over the same amount due to its list structure. Quick sort
     * does the best on average between all the sorts, only being beaten by 
     * Heap sort, which is commonly considered the best general sorting algorithm
     * in the industry.
     */

}