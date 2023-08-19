package customException;

public class InvalidLocatorException extends RuntimeException{
	
	public InvalidLocatorException(String message) {
		super(message);
	}
}
