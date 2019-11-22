package ui;

import exceptions.*;
import model.CourseLoad;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class NewUserSetup extends JFrame {

    private JPanel newUserPanel;
    private JLabel firstNameLabel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JLabel lastNameLabel;
    private JTextField majorField;
    private JLabel majorLabel;
    private JLabel coursesLabel;
    private JTextField course1;
    private JButton createNewUser;
    private JLabel userNameLabel;
    private JTextField userNameField;
    private JTextField course2;
    private JTextField course3;
    private JTextField course4;
    private JTextField course5;
    private JTextField course6;
    private JLabel errorLabel;
    private UserSetup newUserSetup;
    private User user;
    private CourseLoad userCourses;

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


        createNewUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    newUserSetup = new UserSetup();
                    user = newUserSetup.getUser();
                    if ((userNameField.getText().isEmpty())) {
                        throw new EmptyUserField();
                    } else {
                        user.setUsername(userNameField.getText());
                        }
                    if ((firstNameField.getText().isEmpty())) {
                        throw new EmptyFirstNameField();
                    } else {
                        user.setFirstName(firstNameField.getText());
                    }
                    if ((lastNameField.getText().isEmpty())) {
                        throw new EmptyLastNameField();
                    } else {
                        user.setLastName(lastNameField.getText());
                    }
                    if ((majorField.getText().isEmpty())) {
                        throw new EmptyMajorField();
                    } else {
                        user.setMajor(majorField.getText());
                    }

                    userCourses = user.getCourseLoad();
                    if (!(course1.getText().isEmpty())) {
                        userCourses.addCourse(course1.getText());
                    }
                    if (!(course2.getText().isEmpty())) {
                        userCourses.addCourse(course2.getText());
                    }
                    if (!(course3.getText().isEmpty())) {
                        userCourses.addCourse(course3.getText());
                    }
                    if (!(course4.getText().isEmpty())) {
                        userCourses.addCourse(course4.getText());
                    }
                    if (!(course5.getText().isEmpty())) {
                        userCourses.addCourse(course5.getText());
                    }
                    if (!(course6.getText().isEmpty())) {
                        userCourses.addCourse(course6.getText());
                    }
                    File userFile = new File("./data/" + userNameField.getText() + ".txt");
                    if (userFile.exists()) {
                        throw new UserAlreadyExists();
                    }

                    //Builds user data structure
                    errorLabel.setVisible(false);
                    newUserSetup.saveUser();
                    System.out.println(user);

                    JFrame mainFrame = new Main("UBC CourseLoad", user);
                    mainFrame.setVisible(true);
                } catch (IOException io) {
                    userNameLabel.setText("Sorry, an error occurred while "
                            + "setting up your account, please try again.");
                } catch (EmptyUserField emptyUser) {
                    errorLabel.setVisible(true);
                    errorLabel.setText("Please fill out the username field.");

                } catch (EmptyFirstNameField emptyFirstNameField) {
                    errorLabel.setVisible(true);
                    errorLabel.setText("Please fill out the first name field.");
                } catch (EmptyLastNameField emptyLastNameField) {
                    errorLabel.setVisible(true);
                    errorLabel.setText("Please fill out the last name field.");
                } catch (EmptyMajorField emptyMajorField) {
                    errorLabel.setVisible(true);
                    errorLabel.setText("Please fill out the major field.");
                } catch (UserAlreadyExists alreadyExists) {
                    errorLabel.setVisible(true);
                    errorLabel.setText("Sorry, that username already exists."
                            + " Please enter a different username.");
                }
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new NewUserSetup("UBC CourseLoad");
        frame.setVisible(true);
    }
}
