package stackandqueuetheory;

public class ArrayStringStack {
		private int maxSize;
		private String [] arrayStack;
		private int top;
		public ArrayStringStack(int a) {
			maxSize=a;
			arrayStack= new String [maxSize];
			top=-1;
		}
		public void push(String a) {
			arrayStack[++top]=a;
		}
		public String pop() {
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
		public int findStack(String a) {
			if (isEmpty()) return -1;
			else {
				for (int i=0;i<=top;i++)
					if (arrayStack[i].equals(a)) return i;
				return -1;
			}
		}
		public int getTop() {
			return top;
		}
		public String getValue(int a) {
			return arrayStack[a];
		}
}

