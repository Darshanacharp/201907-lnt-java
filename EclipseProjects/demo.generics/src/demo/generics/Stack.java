package demo.generics;

public interface Stack<X> {

	void push(X value);

	X pop();

	

	boolean isFull();

	int size();
	
	default boolean isEmpty() { return size()==0;}
	
	default void clear() {
		while(!isEmpty())
			pop();
	}

	default Stack<X> pushMany(X...items){
		for(X item:items)
			push(item);
		
		return this;
	}
	
	
	static <X> Stack<X> createDynamicStack(X ...values){
		var stack=new DynamicStack<X>();
		stack.pushMany(values);
		return stack;
	}
	
	
	
	
}