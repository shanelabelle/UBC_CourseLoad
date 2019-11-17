package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private JPanel loginScreen;
    private JLabel logo;
    private JTextField userName;
    private JLabel userNameLabel;
    private JButton login;

    public LoginScreen(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(loginScreen);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("images/Logo_blue.png");
        this.setIconImage(icon.getImage());




    }

    public static void main(String[] args) {

        JFrame frame = new LoginScreen("UBC CourseLoad");
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
