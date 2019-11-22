package ui;

import model.User;

import javax.swing.*;
import java.awt.*;
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
    private JProgressBar loadUserProgress;
    private UserSetup userSetup;

    public LoginScreen(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(loginScreen);
        this.pack();
        this.setSize(550,550);
        this.setLocationRelativeTo(null);

        // user setup methods
        this.userSetup = new UserSetup();

        ImageIcon icon = new ImageIcon("images/Logo_blue.png");
        this.setIconImage(icon.getImage());

        Color fieldColor = new Color(235,245,250);

        userName.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));



        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    userSetup.loadUser(userName.getText());
                    User user = userSetup.getUser();
                    loadUserProgress.setIndeterminate(true);
                    loadUserProgress.setVisible(true);
                    userNameLabel.setText("Welcome" + userSetup.getUser().getFirstName() + "!");
                    JFrame mainFrame = new Main("UBC CourseLoad", user);
                    mainFrame.setVisible(true);
                    setVisible(false);
                } catch (Exception userNameError) {
                    Color badUserColor = new Color(245,91,98);
                    Font badUserFont = new Font("Open Sans", Font.BOLD,11);
                    userNameLabel.setForeground(badUserColor);
                    userNameLabel.setFont(badUserFont);
                    userNameLabel.setText("Sorry, that username does not exist. Please enter a valid username.");
                    //add time sleep then return to the original username label
                }



            }
        });
        newUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame newUserFrame = new NewUserSetup("UBC Courseload");
                newUserFrame.setResizable(false);
                newUserFrame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {

        JFrame loginFrame = new LoginScreen("UBC CourseLoad");
        loginFrame.setResizable(false);
        loginFrame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
