package in.conceptarchitect.restclient;

public class ServiceException extends RuntimeException {

	private int responseCode;

	public ServiceException(String message, int responseCode) {
		// TODO Auto-generated constructor stub
		super(message);
		this.responseCode=responseCode;
	}

	public ServiceException(String message, Exception ex) {
		// TODO Auto-generated constructor stub
		super(message,ex);
	}

	public int getResponseCode() {
		return responseCode;
	}

}
