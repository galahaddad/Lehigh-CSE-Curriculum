import java.util.ArrayList;

/**
 * GenericGrid
 */
public class GenericGrid <E> {
    private ArrayList<ArrayList<E>> list = new ArrayList<ArrayList<E>>();

    public GenericGrid() {
        list = new ArrayList<ArrayList<E>>();
    }

    public GenericGrid(E[][] dataArray) {
        list = new ArrayList<ArrayList<E>>(dataArray.length);
        for (int i=0;i<dataArray.length;i++) {
            ArrayList<E> r = new ArrayList<E>();
            for (int j=0; j<dataArray[i].length;j++) {
                r.add(j,dataArray[i][j]);
            }
            list.add(r);
        }
    }

    public E get(int i, int j) {
        return list.get(i).get(j);
    }

    public void set(int i, int j, E item) {
        list.get(i).set(j, item);
    }

    public int rows() {
        return list.size();
    }

    public int columns() {
        return list.get(0).size();
    }

    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        for (int i=0;i<list.size();i++) {
            sBuilder.append("[");
            for (int j=0; j<list.get(i).size();j++) {
                sBuilder.append(list.get(i).get(j)).append(", ");
            }
            sBuilder.append("]\n");
        } 
        return sBuilder.toString();   
    }
    
}