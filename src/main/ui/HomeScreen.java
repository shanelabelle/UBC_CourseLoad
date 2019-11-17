package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame {
    private JPanel homeScreen;
    private JPanel secondScreen;
    private JTextField textField;
    private JButton firstButton;
    private JLabel label;
    private JLabel upperLabel;
    private JPanel home;
    private JTabbedPane tabbedPane1;
    private JButton button1;
    private JList list1;
    private JProgressBar progressBar1;

    public HomeScreen(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(homeScreen);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    public static void main(String[] args) {

        JFrame frame = new HomeScreen("UBC CourseLoad");
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
