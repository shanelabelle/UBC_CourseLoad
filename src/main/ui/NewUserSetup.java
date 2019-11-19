package ui;

import com.sun.webkit.ColorChooser;

import javax.swing.*;
import java.awt.*;

public class NewUserSetup extends JFrame {

    private JPanel newUserPanel;
    private JLabel firstNameLabel;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JLabel lastNameLabel;
    private JTextField majorField;
    private JLabel majorLabel;
    private JLabel coursesLabel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton createNewUser;
    private JLabel userNameLabel;
    private JTextField userNameField;

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

    }

    public static void main(String[] args) {

        JFrame frame = new NewUserSetup("UBC CourseLoad");
        frame.setVisible(true);
    }
}
