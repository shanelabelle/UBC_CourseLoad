package ui;

import model.Block;
import model.User;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.XChartPanel;

import javax.smartcardio.Card;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame {
    private JPanel background;
    private JButton homeButton;
    private JLabel logo;
    private JButton coursesButton;
    private JPanel homePanel;
    private JPanel coursesPanel;
    private JPanel pieChartPanel;
    private JPanel studyTrackerPanel;
    private JPanel sideBarPanel;
    private JPanel mainPanel;
    private JLabel userNameLabel;
    private JLabel majorLabel;
    private JLabel courseLoadLabel;
    private JLabel dashboardLabel;
    private CardLayout screens;
    private JButton courseButton0;
    private JButton courseButton1;
    private JButton courseButton2;
    private JButton courseButton3;
    private JButton courseButton4;
    private JButton courseButton5;
    private JPanel courseChart1;
    private ArrayList<JButton> courseButtonList;
    private ArrayList<String> courseNames;
    private CardLayout courseCards;

    public Main(String title, User user) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(background);
        this.pack();
        this.setSize(550,550);
        this.setLocationRelativeTo(null);

        screens = (CardLayout) (mainPanel.getLayout());
        courseCards = (CardLayout) (pieChartPanel.getLayout());

        userNameLabel.setText(user.getFirstName() + " " + user.getLastName());
        majorLabel.setText(user.getMajor());

        courseLoadLabel.setBorder(new EmptyBorder(5, 10, 5, 10));


        courseButtonList = new ArrayList<>();
        courseNames = new ArrayList<>();
        courseButtonList.add(courseButton0);
        courseButtonList.add(courseButton1);
        courseButtonList.add(courseButton2);
        courseButtonList.add(courseButton3);
        courseButtonList.add(courseButton4);
        courseButtonList.add(courseButton5);

        for (Block block : user.getCourseLoad()) {
            courseNames.add(block.getName());
        }

        int counter = 0;

        while (counter < courseNames.size()) {
            courseButtonList.get(counter).setVisible(true);
            courseButtonList.get(counter).setText(courseNames.get(counter));
            counter = counter + 1;
        }

        PieChart chart = new PieChart(400,400);
        chart.addSeries("Final",24);
        chart.addSeries("Midterm", 10);
        JPanel pieChart1 = new XChartPanel<PieChart>(chart);
        courseChart1.add(pieChart1);

        courseCards.show(pieChartPanel,"courseChart1");





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

        UserSetup setup = new UserSetup();
        try {
            setup.loadUser("Shane");
        } catch (Exception bad) {
            System.out.println("baduser");
        }
        User shane = setup.getUser();

        JFrame mainFrame = new Main("UBC CourseLoad", shane);
        mainFrame.setVisible(true);
    }
}
