package exceptions;

/**
 *
 * @author jenniferstreit
 */
public class NameIsEmptyException extends RuntimeException {
    
    public NameIsEmptyException(String errorMessage) {
        super(errorMessage);
    }
    
    public NameIsEmptyException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
        
}
