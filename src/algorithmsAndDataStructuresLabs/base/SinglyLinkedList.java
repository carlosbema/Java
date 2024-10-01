package algorithmsAndDataStructuresLabs.base;

public class SinglyLinkedList<E> {
    
    private static class Node<E> {
		private E element;
		private Node<E> next;
		
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		
		public E getElement() { return element; }
		public Node<E> getNext() { return next; }
		public void setNext(Node<E> n) { next = n; }
	}
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	public int size() {
		int count = 0;
		Node<E> walker = head;
		while (walker != null) {
			walker = walker.getNext();
			count++;
		}
		return count;
	}

	public boolean isEmpty() { return size == 0; }
	
	public E first() {
		if (isEmpty()) return null;
		return head.getElement();
	}
	
	public E last() {
		if (isEmpty()) return null;
		return tail.getElement();
	}
	
	public void addFirst(E e) {
		head = new Node<>(e, head);
		if (size == 0)
			tail = head;
		size++;
	}
	
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (isEmpty())
			head = newest;
		else
			tail.setNext(newest);
		tail = newest;
		size++;
	}
	
	public E removeFirst() {
		if (isEmpty()) return null;
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0)
			tail = null;
		return answer;
	}

	public E penultimo(){
		if (size < 2) throw new IllegalStateException("A lista deve ter mais de 2 negocio");
		Node<E> walk = head;
		while(walk.getNext().getNext() != null){
			walk = walk.getNext();
		}
		return walk.getElement();
	}

	public E removeLast(){
		if(size < 2) throw new IllegalStateException("A lista deve ter mais de 2 negocio");
		if (isEmpty()) return null;
		Node<E> walk = head;
		while(walk.getNext().getNext() != null){
			walk = walk.getNext();
		}
		E answer = walk.getNext().getElement();
		tail = walk.getNext();
		return answer;
	}
	
	public String toString() {
	    StringBuilder sb = new StringBuilder("(");
	    Node<E> walk = head;
	    while (walk != null) {
	      sb.append(walk.getElement());
	      if (walk != tail)
	        sb.append(", ");
	      walk = walk.getNext();
	    }
	    sb.append(")");
	    return sb.toString();
	}
}