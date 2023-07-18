package ch11.Ex07;

public class WrongPasswordException extends Exception{
    public WrongPasswordException() {}
    public WrongPasswordException(String message){
        super(message);
    }
}
