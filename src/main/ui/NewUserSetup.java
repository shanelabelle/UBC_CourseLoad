package ui;

import model.Course;
import model.CourseLoad;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class NewUserSetup extends JFrame {

    private JPanel newUserPanel;
    private JLabel firstNameLabel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JLabel lastNameLabel;
    private JTextField majorField;
    private JLabel majorLabel;
    private JLabel coursesLabel;
    private JTextField course0;
    private JButton createNewUser;
    private JLabel userNameLabel;
    private JTextField userNameField;
    private JTextField course1;
    private JTextField course2;
    private JTextField course3;
    private JTextField course4;
    private JTextField course5;
    private JLabel errorLabel;
    private UserSetup newUserSetup;
    private User user;
    private CourseLoad userCourses;
    private ArrayList<JTextField> courseFields;

    public NewUserSetup(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(newUserPanel);
        this.setSize(550,550);
        this.setLocationRelativeTo(null);

        Color fieldColor = new Color(235,245,250);

        userNameField.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));
        firstNameField.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));
        lastNameField.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));
        majorField.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));

        courseFields = new ArrayList<>();

        courseFields.add(course0);
        courseFields.add(course1);
        courseFields.add(course2);
        courseFields.add(course3);
        courseFields.add(course4);
        courseFields.add(course5);



        createNewUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    newUserSetup = new UserSetup();
                    user = newUserSetup.getUser();

                    //sets user fields
                    setNewUserFields();
                    //reads course fields and adds courses to user courseload
                    addCoursesFromFields();

                    //saves user to a new file
                    createNewUserFile();

                    //hides new user window

                    setVisible(false);

                    JFrame mainFrame = new Main("UBC CourseLoad", user);
                    mainFrame.setVisible(true);
                } catch (IOException io) {
                    userNameLabel.setText("Sorry, an error occurred while "
                            + "setting up your account, please try again.");
                } catch (Exception fieldError) {
                    errorLabel.setVisible(true);
                    errorLabel.setText(fieldError.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new NewUserSetup("UBC CourseLoad");
        frame.setVisible(true);
    }

    private void validateUserNameField() throws EmptyUserField {
        if ((userNameField.getText().isEmpty())) {
            throw new EmptyUserField();
        } else {
            user.setUserName(userNameField.getText());
        }
    }

    private void validateFirstNameField() throws EmptyFirstNameField {
        if ((firstNameField.getText().isEmpty())) {
            throw new EmptyFirstNameField();
        } else {
            user.setFirstName(firstNameField.getText());
        }
    }

    private void validateLastNameField() throws EmptyLastNameField {
        if ((lastNameField.getText().isEmpty())) {
            throw new EmptyLastNameField();
        } else {
            user.setLastName(lastNameField.getText());
        }
    }

    private void validateMajorField() throws EmptyMajorField {
        if ((majorField.getText().isEmpty())) {
            throw new EmptyMajorField();
        } else {
            user.setMajor(majorField.getText());
        }
    }

    private void setNewUserFields()
            throws EmptyMajorField, EmptyLastNameField, EmptyFirstNameField, EmptyUserField {

        validateUserNameField();
        validateFirstNameField();
        validateLastNameField();
        validateMajorField();
    }

    private void addCoursesFromFields() {
        userCourses = user.getCourseLoad();

        for (JTextField textField : courseFields) {
            if (!(textField.getText().isEmpty())) {
                Course newCourse = new Course(textField.getText().toUpperCase());
                userCourses.addCourse(newCourse);
            }
        }
    }

    private void createNewUserFile() throws UserAlreadyExists, IOException {
        File userFile = new File("./data/" + userNameField.getText() + ".txt");
        if (userFile.exists()) {
            throw new UserAlreadyExists();
        }

        //Builds user data structure
        errorLabel.setVisible(false);
        newUserSetup.saveUser();
        System.out.println(user);

    }
}
