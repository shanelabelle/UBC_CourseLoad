package exceptions;

public class EmptyMajorField extends Exception {
    private String message;

    public EmptyMajorField() {
        this.message = "Please fill out the major field.";
    }

    public String getMessage() {
        return this.message;
    }
}
