package exceptions;

/**
 *
 * @author jenniferstreit
 */
public class ObjectIsEmptyException extends RuntimeException {
    
    public ObjectIsEmptyException(String errorMessage) {
        super(errorMessage);
    }
    
    public ObjectIsEmptyException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
    
}
