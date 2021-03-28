package stackandqueuetheory;

import javafx.scene.control.Button;

public class ArrayButton {
	private int maxSize;
	private Button [] arrayStack;
	private int top;
	public ArrayButton(int a) {
		maxSize=a;
		arrayStack= new Button [maxSize];
		top=-1;
	}
	public void push(Button a) {
		arrayStack[++top]=a;
	}
	public Button pop() {
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
	public int findStack(Button a) {
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
	public void disableButtonInStack(boolean a) {
		for (int i=0;i<=top;i++) {
			arrayStack[i].setDisable(a);
		}
	}
}
