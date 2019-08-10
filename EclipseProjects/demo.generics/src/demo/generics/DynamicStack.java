package demo.generics;

public class DynamicStack<T> implements Stack<T> {

	class Node{
		T value;
		Node next;
	}
	
	Node top=null;
	int count=0;
	
	@Override
	public void push(T value) {
		// TODO Auto-generated method stub
		Node n=new Node();
		n.value=value;
		n.next=top;
		top=n;
		count++;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new StackUnderFlowException();
		
		Node n=top;
		top=top.next;
		count--;
		return n.value;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

}
