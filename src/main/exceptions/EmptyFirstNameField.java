package exceptions;

public class EmptyFirstNameField extends Exception {
    private String message;

    public EmptyFirstNameField() {
        this.message = "Please fill out the first name field.";
    }

    public String getMessage() {
        return this.message;
    }


}
