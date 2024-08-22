package exception;


This class extends the built-in `Exception` class to provide a specific exception type for validation-related issues.
public class ValidationException extends Exception {
	
//	Constructs a new ValidationException with the specified detail message
	public ValidationException(String message) {
	        super(message);
	    }
}
