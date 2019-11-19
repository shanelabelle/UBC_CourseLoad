package ui;

import javax.swing.*;

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

    public NewUserSetup(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(newUserPanel);
        this.setSize(550,550);
        this.setLocationRelativeTo(null);

    }

    public static void main(String[] args) {

        JFrame frame = new NewUserSetup("UBC CourseLoad");
        frame.setVisible(true);
    }
}
