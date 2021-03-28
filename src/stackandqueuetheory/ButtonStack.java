package stackandqueuetheory;

import java.util.LinkedList;

public class ButtonStack<E>{
	private LinkedList<E> list = new LinkedList<E>();
	
	public void push(E item) {
		 list.addLast(item);
	}
	
	public E pop() {
	     return list.pollLast();
	}
		
}
