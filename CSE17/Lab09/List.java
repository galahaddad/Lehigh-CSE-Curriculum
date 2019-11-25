import java.util.Collection;
public interface List<E> extends Collection<E>{
  void add(int index, E item);
  E get(int index);
  int indexOf(Object e);
  int lastIndexOf(Object e);
  E remove(int index);
  E set(int index, E item);
  // Default defintions of the methods from the interface Collection
  @Override
  default boolean add(E item) {
	  add(size(), item);
	  return true;
  }
  @Override
  default boolean isEmpty() {
	  return size()==0;
  }
  @Override
  default boolean remove(Object e) {
	  if (indexOf(e) >= 0) {
		  remove(indexOf(e));
		  return true;
	  }
	  return false;
  }
  @Override
  default boolean containsAll(Collection<?> c) {
	  for(Object e: c)
		  if (indexOf(e) == -1)
			  return false;
	  return true;
  }
  @Override
  default boolean addAll(Collection<? extends E> c) {
	  boolean changed = false;
	  for(Object e: c)
		  if (indexOf(e) < 0) {
			  add((E) e);
			  changed = true;
		  }
	  return changed;
  }
  @Override
  default boolean removeAll(Collection<?> c) {
	  boolean changed = false;
	  for(Object e: c)
		  if (indexOf(e) >= 0) {
			  remove(e);
			  changed = true;
		  }
	  return changed;
  }
  @Override
  default boolean retainAll(Collection<?> c) {
	  boolean changed = false;
	  for(int i=0; i<size(); i++)
		  if (c.contains(get(i))) {
			  remove(get(i));
			  changed = true;
		  }
	  return changed;
  }
  @Override
  default Object[] toArray() {
	  Object[] objects = new Object[size()];
	  for(int i=0; i<size(); i++)
		  objects[i] = get(i);
	  return objects;
  }
  @Override
  default <T> T[] toArray(T[] array) {
	  for(int i=0; i<size(); i++)
		  array[i] = (T) get(i);
	  return array;
  }
}
