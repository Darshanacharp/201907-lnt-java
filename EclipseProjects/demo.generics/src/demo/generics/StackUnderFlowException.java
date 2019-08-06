package demo.generics;

public class StackUnderFlowException extends StackException {

	public StackUnderFlowException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public StackUnderFlowException() {
		super("Stack Underflow");
		// TODO Auto-generated constructor stub
	}
}
