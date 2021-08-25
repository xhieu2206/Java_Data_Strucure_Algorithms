package funix.assignment;

public class EmptyStackException extends RuntimeException {
    public EmptyStackException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public EmptyStackException(String errorMessage) {
    }
}
