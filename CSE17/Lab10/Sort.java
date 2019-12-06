/**
 * Sort
 */
public class Sort {

    

    public static <E extends Comparable<E>> void selectionSort(E[] list) {
        int minIndex;
        for (int i=0; i<list.length-1; i++) {
            minIndex = findMin(list, i);
            E temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }
    public static <E extends Comparable<E>> int findMin(E[] list, int start){
        E min = list[start]; int index = start;
        for (int i=start; i<list.length; i++){
            if (list[i].compareTo(min) < 0){
            min = list[i];
            index = i;
            }
        }
        return index;
    }

}