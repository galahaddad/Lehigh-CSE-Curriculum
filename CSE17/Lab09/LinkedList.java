import java.util.Iterator;

public class LinkedList<E> implements List<E>{
	// Data members
	private Node<E> head, tail;
	private int size;
	// Constructors
	public LinkedList() {
		head = tail = null;
		size = 0;
	}
	public LinkedList(E[] elements) {
		for(int i=0; i<elements.length; i++)
			add(elements[i]);
	}
	// Methods
	public int size() {
		return size;
	}
	public E getFirst() {
		if(size == 0)
			return null;
		else
			return head.element;
	}
	public E getLast() {
		if (size == 0)
			return null;
		else
			return tail.element;
	}
	public void addFirst(E item) {
		Node<E> newNode = new Node<E>(item);
		newNode.next = head;
		head = newNode;
		size++;
		if (tail == null)
			tail = head;
	}
	public void addLast(E item) {
		Node<E> newNode = new Node<>(item);
		if(tail == null)
			head = tail = newNode;
		else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	public void add(int index, E item) {
		if(index == 0)
			addFirst(item);
		else if (index >= size)
			addLast(item);
		else {
			Node<E> current = head;
			for(int i=0; i<index; i++) {
				current = current.next;
			}
			Node<E> temp = current.next;
			current.next = new Node<>(item);
			(current.next).next = temp;
			size++;
		}
	}
	public E removeFirst() {
		if (size == 0)
     		return null;
		Node<E> temp = head;
		head = head.next;
		size--;
		if(head == null)
			tail = null;
		return temp.element;
	}
	public E removeLast() {
		if (size == 0)
     		return null;
		Node<E> current = head;
		for(int i=0; i<size-2; i++)
			current = current.next;
		Node<E> temp = tail;
		if(head == tail) {
			head = tail = null;
			size = 0;
		}
		else {
			tail = current;
			tail.next = null;
			size--;
		}
		return temp.element;
	}
	public E remove(int index) {
		if (index <0 || index >= size)
     		return null;
		Node<E> temp;
		Node<E> current = head;
		for (int i=0; i<index-1; i++)
			current = current.next;
		temp = current.next;
		current.next = current.next.next;
		size--;
		return temp.element;
	}
	public String toString() {
		String output = "[";
		Node<E> current = head;
		for(int i=0; i<size; i++) {
			output += current.element;
			current = current.next;
			if (i < size-1)
				output += ", ";
		}
		output += "]";
		return output;
	}
	public void clear() {
		size = 0;
		head=tail=null;
	}
	private void checkIndex(int index) {
	  if (index >= size || index < 0)
	    throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
	}
	public E get(int index) {
		if(size == 0)
			return null;
		checkIndex(index);
		Node<E> current = head;
		for(int i=0; i<index; i++)
			current = current.next;
		//current = current.next;
		return current.element;

	}
	public int indexOf(Object e) {
		Node<E> current = head;
		for (int i=0; i<size; i++) {
			if (current.element.equals(e))
				return i;
			current = current.next;
		}
		return -1;
	}
	public int lastIndexOf(Object e) {
		Node<E> current = head;
		for (int i=size-1; i>=0; i--) {
			if (current.element.equals(e))
				return i;
			current = current.next;
		}
		return -1;
	}
	public E set(int index, E item) {
		if (index < 0 || index >= size)
			return null;
		Node<E> current = head;
		for (int i=0; i<index; i++)
			current = current.next;
		E temp = current.element;
		current.element = item;
		return temp;
	}
	public boolean contains(Object e) {
		Node<E> current = head;
		while(current != null) {
		  if(e.equals(current.element)) {
			return true;
		  }
		  current = current.next;
		}
		return false;
	}
	public Iterator<E> iterator(){
		   return new LinkedListIterator();
	}
	// Class Linked List Iterator
	private class LinkedListIterator implements Iterator<E>{
		   private Node<E> current = head;
		   public boolean hasNext() {
			   return current != null;
		   }
		   public E next() {
			   E temp = current.element;
			   current = current.next;
			   return temp;
		   }
		   public void remove() {
			   if(current == null)
				   throw new IllegalStateException();
			   LinkedList.this.remove(indexOf(current));
		   }
	   }
	private class Node<E>{
		E element;
		Node<E> next;
		Node(E item){
			element = item;
			next = null;
		}
	}
	public int searchComparisons(E item) {
		Node<E> current = head;
		int count = 0;
		for (int i=0; i<size; i++) {
			count++;
			if (current.element.equals(item))
				break;
			current = current.next;
		}
		return count;
	}
}
