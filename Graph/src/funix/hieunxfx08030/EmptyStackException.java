package funix.hieunxfx08030;

public class EmptyStackException extends RuntimeException {
    public EmptyStackException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public EmptyStackException(String errorMessage) {
    }
}
