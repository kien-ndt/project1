package stackandqueuetheory;

import java.util.LinkedList;

public class ButtonQueue<E> {
	private LinkedList<E> list = new LinkedList<E>();
	public void enqueue(E item) {
		 list.addLast(item);
	 }
	public E dequeue() {
	     return list.poll();
	}
}