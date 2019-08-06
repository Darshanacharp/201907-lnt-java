package demo.generics;

public class FixedIntStack {
	int [] values;
	int top;
	public FixedIntStack(int size) {
		values=new int[size];
		top=0;
	}
	
	public void push(int value) {
		if(isFull())
			throw new StackOverFlowException(value);
		values[top++]=value;
	}

	public int pop() {
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
	
	
}
