package ch11.customException;

public class InsufficientException extends Exception{
    public InsufficientException() {

    }

    public InsufficientException(String message){
        super(message);
    }
}
