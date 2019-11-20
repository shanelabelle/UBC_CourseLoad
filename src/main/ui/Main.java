package ui;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JPanel background;
    private JButton homeButton;
    private JLabel homeIcon;
    private JLabel logo;

    public Main(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(background);
        this.pack();
        this.setSize(550,550);
        this.setLocationRelativeTo(null);


    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {

        JFrame mainFrame = new Main("UBC CourseLoad");
        mainFrame.setVisible(true);
    }
}
