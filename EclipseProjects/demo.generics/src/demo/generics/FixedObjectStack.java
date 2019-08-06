package demo.generics;

public class FixedObjectStack {
	Object [] values;
	int top;
	public FixedObjectStack(int size) {
		values=new Object[size];
		top=0;
	}
	
	public void push(Object value) {
		if(isFull())
			throw new StackOverFlowException();
		values[top++]=value;
	}

	public Object pop() {
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
