package ui;

import model.Block;
import model.Course;
import model.User;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.XChartPanel;

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
    private JPanel segmentPanel;
    private JLabel courseTitle;
    private JPanel courseSegments1;
    private JTextField segmentName0;
    private JTextField weight0;
    private JTextField segmentName1;
    private JTextField segmentName2;
    private JTextField segmentName3;
    private JTextField segmentName4;
    private JTextField segmentName5;
    private JTextField weight1;
    private JTextField weight2;
    private JTextField weight3;
    private JTextField weight4;
    private JTextField weight5;
    private JButton editSegments;
    private JButton updateSegments;
    private ArrayList<JButton> courseButtonList;
    private ArrayList<Block> courses;
    private CardLayout courseCards;
    private ArrayList<JTextField> segmentFields;
    private ArrayList<JTextField> weightFields;


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
        courses = new ArrayList<>();
        courseButtonList.add(courseButton0);
        courseButtonList.add(courseButton1);
        courseButtonList.add(courseButton2);
        courseButtonList.add(courseButton3);
        courseButtonList.add(courseButton4);
        courseButtonList.add(courseButton5);

        for (Block block : user.getCourseLoad()) {
            courses.add(block);
        }

        int counter = 0;

        while (counter < courses.size()) {
            courseButtonList.get(counter).setVisible(true);
            courseButtonList.get(counter).setText(courses.get(counter).getName());
            counter = counter + 1;
        }

        PieChart chart = new PieChart(400,400);
        chart.addSeries("Final",24);
        chart.addSeries("Midterm", 10);
        chart.getStyler().setChartBackgroundColor(Color.WHITE);
        chart.getStyler().setPlotBorderColor(Color.WHITE);
        chart.getStyler().setChartTitleBoxVisible(false);
        JPanel pieChart1 = new XChartPanel<PieChart>(chart);
        courseChart1.add(pieChart1);
        courseCards.show(pieChartPanel,"courseChart1");

        Color fieldColor = new Color(0,93,166);
        segmentFields = new ArrayList<>();
        weightFields = new ArrayList<>();

        segmentName0.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));
        weight0.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));
        segmentFields.add(segmentName0);
        weightFields.add(weight0);
        segmentName1.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));
        weight1.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));
        segmentFields.add(segmentName1);
        weightFields.add(weight1);
        segmentName2.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));
        weight2.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));
        segmentFields.add(segmentName2);
        weightFields.add(weight2);
        segmentName3.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));
        weight3.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));
        segmentFields.add(segmentName3);
        weightFields.add(weight3);
        segmentName4.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));
        weight4.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));
        segmentFields.add(segmentName4);
        weightFields.add(weight4);
        segmentName5.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));
        weight5.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));
        segmentFields.add(segmentName5);
        weightFields.add(weight5);






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
