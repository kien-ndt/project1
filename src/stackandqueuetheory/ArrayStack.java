package stackandqueuetheory;

public class ArrayStack {
	private int maxSize;
	private long [] arrayStack;
	private int top;
	public ArrayStack(int a) {
		maxSize=a;
		arrayStack= new long [maxSize];
		top=-1;
	}
	public void push(long a) {
		arrayStack[++top]=a;
	}
	public long pop() {
		return arrayStack[top--];
	}
	public boolean isEmpty() {
		if (top==-1) return true;
		else return false;
	}
	public boolean isFull() {
		if (top==maxSize-1) return true;
		else return false;
	}
	public int findStack(int a) {
		if (isEmpty()) return -1;
		else {
			for (int i=0;i<=top;i++)
				if (arrayStack[i]==a) return i;
			return -1;
		}
	}
	public int getTop() {
		return top;
	}
}
