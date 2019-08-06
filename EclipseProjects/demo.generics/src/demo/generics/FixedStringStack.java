package demo.generics;

public class FixedStringStack {
	String [] values;
	int top;
	public FixedStringStack(int size) {
		values=new String[size];
		top=0;
	}
	
	public void push(String value) {
		if(isFull())
			throw new StackOverFlowException();
		values[top++]=value;
	}

	public String pop() {
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
