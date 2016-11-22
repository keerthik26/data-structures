package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element != null){
		LLNode<E> node = new LLNode<E>(element);
		LLNode<E> parent = tail.prev;
		node.prev = parent;
		node.next = tail;
		parent.next = node;
		tail.prev = node;
		size++;
		return true;
		}else{
			throw new NullPointerException();
		}
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) throws IndexOutOfBoundsException
	{
		// TODO: Implement this method.
		
		
		if(index < 0 || index >= size ){
			throw new IndexOutOfBoundsException();//"Index is out of limits"
		}else{
			LLNode<E> currentNode = head.next;
			for(int i=0;i<index; i++){
				currentNode = currentNode.next;
			}
			return currentNode.data;
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(index < 0 || index > size ){
			throw new IndexOutOfBoundsException();//"Index is out of limits"
		}else if(element == null){
			throw new NullPointerException();
		}else{
			LLNode<E> node = new LLNode<E>(element);	
			if(head.next == tail){
				head.next = node;
				node.prev = head;
				node.next=tail;
				tail.prev=node;
			}else if(index == size){
				LLNode<E> prevNode = tail.prev;
				prevNode.next = node;
				node.prev = prevNode;
				node.next = tail;
				tail.prev = node;
			}else{
			LLNode<E> currentNode = head;
			for(int i=0;i<=index; i++){
				currentNode = currentNode.next;
			}					
			LLNode<E> prevNode = currentNode.prev;
			//LLNode<E> nextNode = currentNode.next;
			prevNode.next = node;
			currentNode.prev = node;
			node.prev = prevNode;
			node.next = currentNode;
			}
			size++;
			
		}
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index < 0 || index >= size ){
			throw new IndexOutOfBoundsException();//"Index is out of limits"
		}else{
			LLNode<E> currentNode = head.next;
			for(int i=0;i<index; i++){
				currentNode = currentNode.next;
			}
			LLNode<E> prevNode = currentNode.prev;
			LLNode<E> nextNode = currentNode.next;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			size--;
			return currentNode.data;
		}
		
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index < 0 || index >= size ){
			throw new IndexOutOfBoundsException();//"Index is out of limits"
		}else if(element == null){
			throw new NullPointerException();
		}else{
			LLNode<E> currentNode = head.next;
			for(int i=0;i<index; i++){
				currentNode = currentNode.next;
			}
			E data = currentNode.data;
			currentNode.data = element;
			return data;
		}
		
	}
	
	public String toString() {
		String str = "";
		for(int i=0;i<size;i++){
			str += this.get(i) +" --> ";
		}
		
		//System.out.println(str);
		return str;
		
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode(E e, LLNode<E> before, LLNode<E> after) 
	{
		this.data = e;
		this.prev = before;
		this.next = after;
		before.next = this;
		next.prev = this;
	}

}
