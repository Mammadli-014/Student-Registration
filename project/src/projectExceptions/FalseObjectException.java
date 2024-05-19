package projectExceptions;

import java.io.IOException;

public class FalseObjectException extends IOException {
    private String message="False object entered";

    public FalseObjectException() throws RuntimeException{
        super();
    }

    public FalseObjectException(String cause){
        super(cause);
        this.message = cause;
    }

    @Override
    public String getMessage() {
        return message;
    }
}