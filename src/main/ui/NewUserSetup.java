package ui;

import com.sun.webkit.ColorChooser;
import exceptions.UserFileNotFound;
import model.Course;
import model.CourseLoad;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
                    newUserSetup.loadUser(userNameField.getText());

                } catch (Exception userNotFound) {
                    try {
                        newUserSetup = new UserSetup();
                        user = newUserSetup.getUser();
                        user.setUsername(userNameField.getText());
                        user.setFirstName(firstNameField.getText());
                        user.setLastName(lastNameField.getText());
                        user.setMajor(majorField.getText());
                        userCourses = user.getCourseLoad();
                        if (!(course1.getText() == "")) {
                            userCourses.addCourse(course1.getText());
                        }
                        if (!(course2.getText() == "")) {
                            userCourses.addCourse(course2.getText());
                        }
                        if (!(course3.getText() == "")) {
                            userCourses.addCourse(course3.getText());
                        }
                        if (!(course4.getText() == "")) {
                            userCourses.addCourse(course4.getText());
                        }
                        if (!(course5.getText() == "")) {
                            userCourses.addCourse(course5.getText());
                        }
                        if (!(course6.getText() == "")) {
                            userCourses.addCourse(course6.getText());
                        }
                        newUserSetup.saveUser();
                        System.out.println(user);
                    } catch (IOException io) {
                        userNameLabel.setText("Sorry, an error occured while "
                                + "setting up your account, please try again.");
                    }

                }







            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new NewUserSetup("UBC CourseLoad");
        frame.setVisible(true);
    }
}
