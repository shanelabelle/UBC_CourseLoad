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
    private JButton newUser;
    private JLabel or;

    public LoginScreen(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(loginScreen);
        this.setSize(550,550);
        this.setLocationRelativeTo(null);

        ImageIcon icon = new ImageIcon("images/Logo_blue.png");
        this.setIconImage(icon.getImage());


        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame frame = new NewUserSetup("UBC Courseload");
                frame.setVisible(true);


            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new LoginScreen("UBC CourseLoad");
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
