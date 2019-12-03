public class BST<E extends Comparable<E>> implements Tree<E>{
	// Data members
	private TreeNode<E> root;
	private int size;

	private class TreeNode<E>{
		E data;
		TreeNode<E> left;
		TreeNode<E> right;
		TreeNode(E item){
			data = item;
			left = right= null;
		}
	}
	// Constructors
	BST(){
		root = null; size = 0;
	}
	BST(E[] dataArray){
		for(int i=0; i<dataArray.length;i++)
			insert(dataArray[i]);
	}
	//methods
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return (size == 0);
	}

	public void clear() {
		root = null;
	}
	public boolean search(E item) {
		TreeNode<E> current = root;
		while (current != null) {
			if( item.compareTo(current.data) < 0)
				current = current.left;
			else if (item.compareTo(current.data)> 0)
				current = current.right;
			else
				return true;
		}
		return false;
	}
	public boolean insert(E item) {
		if (root == null)
			root = new TreeNode<>(item);
		else {
			TreeNode<E> parent, current;
			parent = null; current = root;
			while (current != null) {
				if(item.compareTo(current.data) < 0) {
					parent = current;
					current = current.left;
				}
				else if (item.compareTo(current.data) > 0) {
					parent = current;
					current = current.right;
				}
				else
					return false;
			}
			if (item.compareTo(parent.data)< 0)
				parent.left = new TreeNode<>(item);
			else
				parent.right = new TreeNode<>(item);
		}
		size++;
		return true;

	}
	public boolean delete(E item) {
		TreeNode<E> parent, current;
		parent = null; current = root;
		while (current != null) {
			if (item.compareTo(current.data) < 0) {
				parent = current;
				current = current.left;
			}
			else if (item.compareTo(current.data) > 0) {
				parent = current;
				current = current.right;
			}
			else
				break;
		}
		if (current == null) // item not in the tree
			return false;
		if(current.left == null) // No left child
			if (parent == null) // root changed
				root = current.right;
			else {
				if (item.compareTo(parent.data) < 0 )
					parent.left = current.right;
				else
					parent.right = current.right;

			}
		else { // current has a left child
			TreeNode<E> rightMostParent = current;
			TreeNode<E> rightMost = current.left;
			while (rightMost.right != null) { // going right
				rightMostParent = rightMost;
				rightMost = rightMost.right;
			}
			current.data = rightMost.data;
			//delete rigthMost node
			if (rightMostParent.right == rightMost)
				rightMostParent.right = rightMost.left;
			else
				rightMostParent.left = rightMost.left;
		}
		size--;
		return true;

	}
	public void inorder() {
		inorder(root);
	}
	private void inorder(TreeNode<E> node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}
	public void preorder() {
		preorder(root);
	}
	private void preorder(TreeNode<E> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}
	public void postorder() {
		postorder(root);
	}
	private void postorder(TreeNode<E> node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data + " ");
		}
	}
	// toArray() implemented using the BST iterator
	public  Object[] toArray() {
		Object[] list = new Object[size()];
		InorderIterator iterator = iterator();
		for (int i=0; i<size(); i++) {
			list[i] = iterator.next();
		}
		return list;
	}
	public <T> T[] toArray(T[] array) {
		T[] list = array;
		InorderIterator iterator = iterator();
		for (int i=0; i<size(); i++) {
			list[i] = (T)(iterator.next());
		}
		return list;
	}
	public InorderIterator iterator(){
		return new InorderIterator();
	}
	// Class InorderIterator to access the nodes of the BST
	private class InorderIterator implements java.util.Iterator<E>{
		private java.util.ArrayList<E> list = new java.util.ArrayList<>();
		private int current = 0;
		public InorderIterator() {
			inorder();
		}
		private void inorder() {
			inorder(root);
		}
		private void inorder(TreeNode<E> node) {
			if (node != null) {
				inorder(node.left);
				list.add(node.data);
				inorder(node.right);
			}
		}
		public boolean hasNext() {
			if (current < list.size())
				return true;
			return false;
		}
		public E next() {
			return list.get(current++);
		}
		public void remove() {
			if(current == 0)
				throw new IllegalStateException();
			delete(list.get(current--));
			list.clear();
			inorder();// rebuild the list
		}
	}
	public int searchComparisons(E item) {
		TreeNode<E> current = root;
		int count = 0;
		while (current != null) {
			if( item.compareTo(current.data) < 0) {
				current = current.left;
				count++;
			} else if (item.compareTo(current.data)> 0) {
				current = current.right;
				count++;
			} else {
				break;
			}
		}
		return count;
	}
}
