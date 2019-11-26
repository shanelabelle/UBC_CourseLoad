package ui;


import model.Course;
import model.CourseLoad;
import model.Segment;
import model.User;

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
    private JPanel courseChart;
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
    private JButton editSegmentsButton;
    private JButton updateSegmentsButton;
    private JLabel weightLabel;
    private JLabel segmentLabel;
    private ArrayList<JButton> courseButtonList;
    private CardLayout courseCards;
    private ArrayList<JTextField> segmentFields;
    private ArrayList<JTextField> weightFields;
    private CourseLoad courseLoad;
    private Course currentCourse;


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
        courseButtonList.add(courseButton0);
        courseButtonList.add(courseButton1);
        courseButtonList.add(courseButton2);
        courseButtonList.add(courseButton3);
        courseButtonList.add(courseButton4);
        courseButtonList.add(courseButton5);


        courseLoad = user.getCourseLoad();

        int counter = 0;

        while (counter < courseLoad.size()) {
            courseButtonList.get(counter).setVisible(true);
            courseButtonList.get(counter).setText(courseLoad.get(counter).getName());
            counter = counter + 1;
        }


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

        courseButton0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Course course = user.getCourseLoad().get(0);
                currentCourse = user.getCourseLoad().get(0);

                courseTitle.setText(course.getCourseDescription());

                course.addSegment(new Segment("Final",50));
                course.addSegment(new Segment("Midterm",25));
                course.addSegment(new Segment("Assignments",25));

                reDrawSegmentFields(currentCourse);

                JPanel pieChart = course.getCourseChart();
                courseChart.removeAll();
                courseChart.add(pieChart);
                courseCards.show(pieChartPanel,"courseChart");
                screens.show(mainPanel,"coursesCard");

            }
        });
        editSegmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                updateSegmentsButton.setVisible(true);
                for (JTextField textField: segmentFields) {
                    textField.setEditable(true);
                }
                for (JTextField textField: weightFields) {
                    textField.setEditable(true);
                }
            }
        });
        updateSegmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int counter = 0;
                int weight = 0;

                currentCourse.clearSegments();

                //updates the current course with the new inputted segments

                while (counter < segmentFields.size()) {
                    try {
                        if (!weightFields.get(counter).getText().isEmpty()) {
                            weight = Integer.parseInt(weightFields.get(counter).getText());
                        }
                    } catch (NumberFormatException badInt) {
                        weightLabel.setText("Weight(%) - Invalid Weight");
                    }
                    if (!segmentFields.get(counter).getText().isEmpty()
                            && !weightFields.get(counter).getText().isEmpty()) {
                        currentCourse.addSegment(new Segment(segmentFields.get(counter).getText(), weight));
                    }

                    counter++;
                }

                for (JTextField textField: segmentFields) {
                    textField.setEditable(false);
                    textField.setText("");
                }
                for (JTextField textField: weightFields) {
                    textField.setEditable(false);
                    textField.setText("");
                }

                currentCourse.sortSegments();
                reDrawSegmentFields(currentCourse);

                // need to reassign all the segments to the fields in the proper order

                updateSegmentsButton.setVisible(false);

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

    public void reDrawSegmentFields(Course current) {


        int counter = 0;


        // re-draws labels based on the current status of the segment list in the current course
        while (counter < current.getSegments().size()) {
            segmentFields.get(counter).setText(current.getSegments().get(counter).getType());
            weightFields.get(counter).setText(Integer.toString(current.getSegments().get(counter).getWeight()));

            counter++;
        }

        //returns fields to un-editable state
        for (JTextField textField: segmentFields) {
            textField.setEditable(false);
        }
        for (JTextField textField: weightFields) {
            textField.setEditable(false);
        }

    }
}
