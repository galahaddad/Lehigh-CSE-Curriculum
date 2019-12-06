import java.util.ArrayList;

/**
 * Heap
 */
public class Heap <E extends Comparable<E>>{
    private ArrayList<E> list ;

    public Heap() {
        list = ArrayList<>();
    }

    public Heap(E[] data) {
        list = ArrayList<>();
        for(int i=0; i<data.length; i++)
            add(data[i]);
    }

    public void add(E item) {
        list.add(item);
        int currentIndex=list.size()-1;
        while(currentIndex>0) {
            int parentIndex=(currentIndex-1)/2;
            E current = list.get(currentIndex);
            E parent = list.get(parentIndex);
            if(current.compareTo(parent)>0) {
                list.set(currentIndex, parent);
                list.set(parentIndex, current);
            } else {
                break;
            }
            currentIndex = parentIndex;
        }
    }

    public E remove() {
        // … code from previous slides
        // swap if current is less than the maximum
        E current = list.get(currentIndex);
        max = list.get(maxIndex);
        if(list.get(current.compareTo(max) < 0)) {
            list.set(maxIndex, current);
            list.set(currentIndex, max);
            currentIndex = maxIndex;
        } else {
            break; // the tree is a heap
        }
        return removedItem;
    }

    
    
}