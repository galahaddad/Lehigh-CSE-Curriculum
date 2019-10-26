/**
 * Pair
 */
public class Pair <E1, E2>{
    private E1 first;
    private E2 second;

    public Pair (E1 first, E2 second){
        this.first=first;
        this.second=second;
    }

    /**
     * @param first the first to set
     */
    public void setFirst(E1 first) {
        this.first = first;
    }

    /**
     * @param second the second to set
     */
    public void setSecond(E2 second) {
        this.second = second;
    }

    /**
     * @return the first
     */
    public E1 getFirst() {
        return first;
    }

    /**
     * @return the second
     */
    public E2 getSecond() {
        return second;
    }

    /**
     * @return the string of both gneric members of the arraylist
     */
    public String toString() {
        return "(" +first.toString()+", "+second.toString()+")";
    }

    /**
     * @param obj object being compared
     * @return true when the first member is equal
     */
    public boolean equals(Object obj) {
        Pair<E1, E2> pairObjects = (Pair<E1, E2>) obj;
        return pairObjects.getFirst().equals(first) && pairObjects.getSecond().equals(second);
    }

}