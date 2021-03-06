package cz.fi.muni.pa165.exceptions;

/**
 * Exception converted by ExceptionHandler to INTERNAL_SERVER_ERROR HTTP status.
 */
public class ServerException extends RuntimeException {
    public ServerException(String message) {
        super(message);
    }

    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerException(Throwable cause) {
        super(cause);
    }
}
