package exception;

//Custom exception class to handle errors related to database operations.
public class DatabaseException extends Exception {
	
//	Constructs a new DatabaseException with the specified detail message and cause
    public DatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
