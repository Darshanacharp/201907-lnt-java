package in.conceptarchitect.threading;

public class ThreadInterruptedException extends RuntimeException {

	public ThreadInterruptedException() {
		
	}

	public ThreadInterruptedException(String message) {
		super(message);
		
	}

	public ThreadInterruptedException(Throwable cause) {
		super(cause);
		
	}

	public ThreadInterruptedException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ThreadInterruptedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
