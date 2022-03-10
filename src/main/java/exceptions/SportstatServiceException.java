package exceptions;

/**
 *
 * @author jenniferstreit
 */
public class SportstatServiceException extends RuntimeException {
    public SportstatServiceException(String errorMessage) {
        super(errorMessage);
    }
    public SportstatServiceException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
}
