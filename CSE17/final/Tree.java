import java.util.Collection;


public interface Tree<E> extends Collection<E>{
	public boolean search(E item);
	public boolean insert(E item);
	public boolean delete(E item);
	public void inorder();
	public void preorder();
	public void postorder();
	public int size();
	public boolean isEmpty();
	public void clear();
	// default definitions of the methods from the interface Collection
    // toArray() left to be defined in the concrete classes (BST)
	public default boolean add (E item) {
		return insert(item);
	}
	public default boolean contains (Object item) {
		return search((E) item);
	}
	public default boolean remove (Object item) {
		return delete((E) item);
	}
	public default boolean containsAll(Collection<?> c) {
		for (Object obj: c) {
			if (!contains(obj))
				return false;
		}
		return true;
	}
	public default boolean addAll(Collection<? extends E> c) { // union
		boolean changed = false;
		for (Object obj: c) {
			if (!contains(obj)) {
				add((E) obj);
				changed = true;
			}
		}
		return changed;
	}
	public default boolean removeAll(Collection<?> c) { // difference
		boolean changed = false;
		for (Object obj: c) {
			if (contains(obj)) {
				delete((E) obj);
				changed = true;
			}
		}
		return changed;
	}
	public default boolean retainAll(Collection<?> c) { // intersection
		boolean changed = false;
		Object[] list = toArray();
		for (int i=0; i<list.length; i++) {
			if (!c.contains(list[i])) {
				remove((E) list[i]);
				changed = true;
			}
		}
		return changed;
	}

}
