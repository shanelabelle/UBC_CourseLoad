package ui;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel background;
    private JButton homeButton;
    private JLabel homeIcon;
    private JLabel logo;
    private JButton coursesButton;
    private JLabel coursesLabel;
    private JPanel homePanel;
    private JPanel coursesPanel;
    private JPanel pieChartPanel;
    private JPanel studyTrackerPanel;
    private JPanel sideBarPanel;
    private JPanel mainPanel;
    private CardLayout screens;

    public Main(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(background);
        this.pack();
        this.setSize(550,550);
        this.setLocationRelativeTo(null);

        screens = (CardLayout) (mainPanel.getLayout());


        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screens.show(mainPanel,"homeCard");

            }
        });
        coursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screens.show(mainPanel,"coursesCard");

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public static void main(String[] args) {

        JFrame mainFrame = new Main("UBC CourseLoad");
        mainFrame.setVisible(true);
    }
}
