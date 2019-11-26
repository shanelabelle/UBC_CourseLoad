package exceptions;

public class UserAlreadyExists extends Exception {

    private String message;

    public UserAlreadyExists() {
        this.message = "Sorry, that username already exists.";
    }

    public String getMessage() {
        return this.message;
    }
}
