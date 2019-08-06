package demo.generics;

public class StackOverFlowException extends StackException {

	Object value;
	public Object getValue() {
		return value;
	}
	public StackOverFlowException(Object value) {
		// TODO Auto-generated constructor stub
		super("Overflow while pushing "+value);
		this.value=value;
	}
	
	public StackOverFlowException() {
		super("Overflow while pushing");
	}

}
