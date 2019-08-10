package demo.generics;

public class FixedStack<X> implements Stack<X> {
	
	
	
	X [] values;
	int top;
	public FixedStack(int size) {
		values=(X[]) new Object[size]; //new X[size];
		top=0;
	}
	
	@Override
	public void push(X value) {
		if(isFull())
			throw new StackOverFlowException(value);
		values[top++]=value;
	}

	@Override
	public X pop() {
		if(isEmpty())
			throw new StackUnderFlowException();
		
		return values[--top];
	}
	

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return top==values.length;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return top;
	}
	
	
	//we can override interface defaults
	@Override
	public void clear() {
		//I dont want items be cleared
		
	}
	
	
}
