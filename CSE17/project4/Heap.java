import java.util.ArrayList;

/**
 * HeapSort algorithm, uses a binary tree
 * Has a time complexity of O(n log n)
 */
public class Heap <E extends Comparable<E>> {
    private static int iterations = 0;  //iteration counter
    private ArrayList<E> list ;

    public Heap() {
        list = new ArrayList<>();
    }

    public Heap(E[] data) {
        list = new ArrayList<>();
        for (int i = 0; i<data.length;i++) {
            iterations++;
            add(data[i]);
        }
        
    }

    /**
     * add an item to the tree, O(n)
     * @param item
     */
    public void add(E item) {
        list.add(item);
        int currentIndex=list.size()-1;
        while(currentIndex>0) {
            iterations++;
            int parentIndex=(currentIndex-1)/2;
            E current = list.get(currentIndex);
            E parent = list.get(parentIndex);
            if(current.compareTo(parent) > 0) {
                iterations++;
                list.set(currentIndex, parent);
                list.set(parentIndex, current);
            } else {
                break;
            }
            currentIndex = parentIndex;
        }
    }

    /**
     * remove an item from the tree, O(n)
     * @return removed item
     */
    public E remove() {
        if(list.size()==0) return null;
        E removedItem = list.get(0);
        list.set(0, list.get(list.size()-1));
        list.remove(list.size()-1);
        int currentIndex = 0;

        while(currentIndex<list.size()) {
            iterations++;
            int left = 2*currentIndex+1;
            int right = 2*currentIndex+2;
            //find max of the two children
            if(left>=list.size()) break;    //reached the end
            int maxIndex = left;
            E max = list.get(maxIndex);
            if(right < list.size()) {
                iterations++;
                if(max.compareTo(list.get(right)) < 0) {
                    iterations++;
                    maxIndex = right;
                }
            }
            E current = list.get(currentIndex);
            max = list.get(maxIndex);
            if(list.get(currentIndex).compareTo(max) > 0) {
                iterations++;
                list.set(maxIndex, current);
                list.set(currentIndex, max);
                currentIndex = maxIndex;
            } else {
                break; // the tree is a heap
            }
        }

        // swap if current is less than the maximum
        
        
        return removedItem;
    }

    /**
     * @return the iterations
     */
    public static int getIterations() {
        return iterations;
    }

}
