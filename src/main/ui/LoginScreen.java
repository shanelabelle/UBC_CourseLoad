package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class LoginScreen extends JFrame {
    private JPanel loginScreen;
    private JLabel logo;
    private JTextField userName;
    private JLabel userNameLabel;
    private JButton login;
    private JButton newUser;
    private JLabel or;
    private UserSetup userSetup;

    public LoginScreen(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(loginScreen);
        this.setSize(550,550);
        this.setLocationRelativeTo(null);

        // user setup methods
        this.userSetup = new UserSetup();

        ImageIcon icon = new ImageIcon("images/Logo_blue.png");
        this.setIconImage(icon.getImage());


        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    userSetup.loadUser(userName.getText());
                    userNameLabel.setText("Welcome" + userSetup.getUser().getFirstName() + "!");
                    setVisible(false);
                    JFrame frame = new NewUserSetup("UBC Courseload");
                    frame.setVisible(true);
                } catch (Exception userNameError) {
                    userNameLabel.setText("Sorry, that username does not exist. Please enter a valid username.");
                    //add time sleep then return to the original username label
                }



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
