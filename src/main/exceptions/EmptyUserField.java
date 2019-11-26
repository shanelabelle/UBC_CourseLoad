package exceptions;

public class EmptyUserField extends Exception {
    private String message;

    public EmptyUserField() {
        this.message = "Please fill out the username field.";
    }

    public String getMessage() {
        return this.message;
    }
}
