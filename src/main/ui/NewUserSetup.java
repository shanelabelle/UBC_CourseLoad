package ui;

import javax.swing.*;

public class NewUserSetup extends JFrame {

    private JPanel newUserPanel;
    private JButton button1;
    private JTextArea textArea1;

    public NewUserSetup(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(newUserPanel);
        this.setSize(550,550);
        this.setLocationRelativeTo(null);

    }
}
