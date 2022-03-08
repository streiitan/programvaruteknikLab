package exceptions;

/**
 *
 * @author jenniferstreit
 */
public class SportExistsException extends RuntimeException {
    public SportExistsException(String errorMessage) {
        super(errorMessage);
    }
    public SportExistsException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}
