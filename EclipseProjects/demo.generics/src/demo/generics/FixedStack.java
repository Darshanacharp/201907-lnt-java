package demo.generics;

public class FixedStack<X> {
	X [] values;
	int top;
	public FixedStack(int size) {
		values=(X[]) new Object[size]; //new X[size];
		top=0;
	}
	
	public void push(X value) {
		if(isFull())
			throw new StackOverFlowException(value);
		values[top++]=value;
	}

	public X pop() {
		if(isEmpty())
			throw new StackUnderFlowException();
		
		return values[--top];
	}
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==0;
	}

	public boolean isFull() {
		// TODO Auto-generated method stub
		return top==values.length;
	}

	public int size() {
		// TODO Auto-generated method stub
		return top;
	}
	
	
}
