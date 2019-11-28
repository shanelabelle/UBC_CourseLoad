package ui;

public class EmptyLastNameField extends Exception {

    private String message;

    public EmptyLastNameField() {
        this.message = "Please fill out the last name field.";
    }

    public String getMessage() {
        return this.message;
    }
}
