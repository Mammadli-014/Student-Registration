package exceptions;

import java.io.IOException;
import java.security.InvalidParameterException;

public class InvalidNumberException extends InvalidParameterException {
    private String message="Number is invalid";
    public InvalidNumberException(String message) throws IOException {
        super(message);
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public InvalidNumberException() throws IOException {

    }
}
