package jaBankClasses;

public class DuplicatedObjectException extends Exception{
	
    public DuplicatedObjectException() {

    }

    public DuplicatedObjectException(String message) {
    	super(message);
    }

    public DuplicatedObjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicatedObjectException(Throwable cause) {
        super(cause);
    }

}
