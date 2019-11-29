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
import java.io.IOException;
import java.util.ArrayList;

public class Main extends JFrame {
    private User user;
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
    private JLabel invalidWeightLabel;
    private JPanel homeContent;
    private JPanel courseContent;
    private JTextField courseField0;
    private JLabel courseTitle0;
    private JTextField courseField1;
    private JLabel courseTitle1;
    private JTextField courseField2;
    private JTextField courseField3;
    private JTextField courseField4;
    private JTextField courseField5;
    private JLabel courseTitle2;
    private JLabel courseTitle3;
    private JLabel courseTitle4;
    private JLabel courseTitle5;
    private JButton editCoursesButton;
    private JButton updateCourseButton;
    private ArrayList<JButton> courseButtonList;
    private CardLayout courseCards;
    private ArrayList<JTextField> segmentFields;
    private ArrayList<JTextField> weightFields;
    private CourseLoad courseLoad;
    private Course currentCourse;
    private ArrayList<JTextField> courseFields;
    private ArrayList<JLabel> courseTitles;
    private Color fieldColor;
    private UserSetup userController;


    public Main(String title, User user) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(background);
        this.pack();
        this.setSize(1920,1080);
        this.setLocationRelativeTo(null);

        screens = (CardLayout) (mainPanel.getLayout());
        courseCards = (CardLayout) (pieChartPanel.getLayout());

        this.user = user;
        this.userController = new UserSetup();

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

        //to keep track of course fields
        courseFields = new ArrayList<>();
        courseFields.add(courseField0);
        courseFields.add(courseField1);
        courseFields.add(courseField2);
        courseFields.add(courseField3);
        courseFields.add(courseField4);
        courseFields.add(courseField5);

        //to keep track of course titles
        courseTitles = new ArrayList<>();
        courseTitles.add(courseTitle0);
        courseTitles.add(courseTitle1);
        courseTitles.add(courseTitle2);
        courseTitles.add(courseTitle3);
        courseTitles.add(courseTitle4);
        courseTitles.add(courseTitle5);

        //initialize courses to uneditable
        editableCourses(false);




        courseLoad = user.getCourseLoad();

        reDrawCourseFields();


        fieldColor = new Color(0,93,166);
        segmentFields = new ArrayList<>();
        weightFields = new ArrayList<>();

        segmentFields.add(segmentName0);
        weightFields.add(weight0);

        segmentFields.add(segmentName1);
        weightFields.add(weight1);

        segmentFields.add(segmentName2);
        weightFields.add(weight2);

        segmentFields.add(segmentName3);
        weightFields.add(weight3);

        segmentFields.add(segmentName4);
        weightFields.add(weight4);

        segmentFields.add(segmentName5);
        weightFields.add(weight5);

        //Stylize all text fields
        stylizeTextFields(segmentFields);
        stylizeTextFields(weightFields);
        stylizeTextFields(courseFields);

        updateSegmentsButton.setVisible(false);
        editableSegments(false);
        invalidWeightLabel.setVisible(false);
        updateCourseButton.setVisible(false);






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
                changeCourseView(0);

            }
        });

        courseButton0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                changeCourseView(0);
            }
        });
        editSegmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                updateSegmentsButton.setVisible(true);
                invalidWeightLabel.setVisible(false);

                editableSegments(true);
            }
        });
        updateSegmentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                currentCourse.clearSegments();

                //updates the current course with the new inputted segments
                updateCurrentCourseSegments();


                editableSegments(false);

                currentCourse.sortSegments();
                reDrawSegmentFields();
                drawCourseChart();

                // need to reassign all the segments to the fields in the proper order

                updateSegmentsButton.setVisible(false);

                saveUser();

            }
        });
        courseButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCourseView(1);

            }
        });
        courseButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCourseView(2);

            }
        });
        courseButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCourseView(3);

            }
        });
        courseButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCourseView(4);

            }
        });
        courseButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCourseView(5);

            }
        });
        editCoursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                updateCourseButton.setVisible(true);

                editableCourses(true);
            }
        });
        updateCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCourseButton.setVisible(false);
                //updates the current course with the new inputted segments
                updateCourseLoad();


                editableCourses(false);

                reDrawCourseFields();

                saveUser();

            }
        });
    }


//    public static void main(String[] args) {
//
//        UserSetup setup = new UserSetup();
//        try {
//            setup.loadUser("Shane");
//        } catch (Exception bad) {
//            System.out.println("baduser");
//        }
//        User shane = setup.getUser();
//
//        JFrame mainFrame = new Main("UBC CourseLoad", shane);
//        mainFrame.setVisible(true);
//    }

    private void reDrawSegmentFields() {

        clearSegmentFields();


        int counter = 0;


        // re-draws labels based on the current status of the segment list in the current course
        while (counter < currentCourse.getSegments().size()) {
            segmentFields.get(counter).setText(currentCourse.getSegments().get(counter).getType());
            weightFields.get(counter).setText(Integer.toString(currentCourse.getSegments().get(counter).getWeight()));

            counter++;
        }
    }

    private void drawCourseChart() {
        JPanel pieChart = currentCourse.getCourseChart();
        courseChart.removeAll();
        courseChart.add(pieChart);
        courseCards.show(pieChartPanel,"courseChart");
        screens.show(mainPanel,"coursesCard");

    }

    private void editableSegments(Boolean editable) {

        if (editable == true) {

            for (JTextField textField: segmentFields) {
                textField.setEditable(true);
            }
            for (JTextField textField: weightFields) {
                textField.setEditable(true);
            }

        }

        if (editable == false) {
            for (JTextField textField: segmentFields) {
                textField.setEditable(false);
            }
            for (JTextField textField: weightFields) {
                textField.setEditable(false);
            }

        }

    }

    private void changeCourseView(int courseNumber) {

        currentCourse = user.getCourseLoad().get(courseNumber);

        courseTitle.setText(currentCourse.getCourseDescription());


        reDrawSegmentFields();

        drawCourseChart();

    }

    private void updateCurrentCourseSegments() {

        int counter = 0;
        int weight = 0;
        boolean validWeight = false;

        while (counter < segmentFields.size()) {
            try {
                if (!weightFields.get(counter).getText().isEmpty()) {
                    weight = Integer.parseInt(weightFields.get(counter).getText());
                    validWeight = true;
                }
            } catch (NumberFormatException badInt) {
                invalidWeightLabel.setVisible(true);
                validWeight = false;
            }
            if (!segmentFields.get(counter).getText().isEmpty() && validWeight) {
                currentCourse.addSegment(new Segment(segmentFields.get(counter).getText(), weight));
            }
            counter++;
        }
    }

    private void clearSegmentFields() {
        for (JTextField textField: segmentFields) {
            textField.setText("");
        }
        for (JTextField textField: weightFields) {
            textField.setText("");
        }

    }

    private void editableCourses(Boolean editable) {
        if (editable == true) {

            for (JTextField textField: courseFields) {
                textField.setEditable(true);
                textField.setVisible(true);
            }

        }

        if (editable == false) {
            for (JTextField textField: courseFields) {
                textField.setEditable(false);
                if (textField.getText().isEmpty()) {
                    textField.setVisible(false);
                }
            }

        }

    }

    private void reDrawCourseFields() {
        clearCourseFields();


        int counter = 0;

        while (counter < courseLoad.size()) {

            courseButtonList.get(counter).setText(courseLoad.get(counter).getName());
            courseFields.get(counter).setText(courseLoad.get(counter).getName());
            courseTitles.get(counter).setText(courseLoad.get(counter).getCourseDescription());
            courseButtonList.get(counter).setVisible(true);
            courseFields.get(counter).setVisible(true);
            courseTitles.get(counter).setVisible(true);

            counter = counter + 1;
        }
        hideEmptyCourseField();
    }

    private void clearCourseFields() {
        for (JTextField textField: courseFields) {
            textField.setText("");
        }
        for (JLabel label: courseTitles) {
            label.setText("");
        }
        for (JButton button: courseButtonList) {
            button.setVisible(false);
            button.setText("");
        }


    }

    private void hideEmptyCourseField() {
        for (JTextField textField: courseFields) {
            if (textField.getText().isEmpty()) {
                textField.setVisible(false);
            }
        }
    }

    private void updateCourseLoad() {

        ///updates courseload with newly modified courses

        // create temp courseload with new fields
        ArrayList<Course> newCourseList = addNewCourses();

        //adds new courses to both the previous courseload and the temp courselist


        //walks over the old courseload and removes courses that are not in the new courselist
        int removalCounter = 0;
        int size = courseLoad.size();

        while (removalCounter < courseLoad.size()) {
            Course course = courseLoad.get(removalCounter);
            if (!newCourseList.contains(course)) {
                courseLoad.removeCourse(course);
                removalCounter = 0;
            } else {
                removalCounter++;
            }
        }
    }

    private void stylizeTextFields(ArrayList<JTextField> fields) {

        for (JTextField textField : fields) {
            textField.setBorder(BorderFactory.createMatteBorder(0,0,1,0,fieldColor));
        }

    }

    private ArrayList<Course> addNewCourses() {

        ArrayList<Course> newCourseList = new ArrayList<>();

        //adds new courses to both the previous courseload and the temp courselist
        int counter = 0;
        while (counter < courseFields.size()) {
            if (!courseFields.get(counter).getText().isEmpty()) {
                newCourseList.add(new Course(courseFields.get(counter).getText().toUpperCase()));
                courseLoad.addCourse(new Course(courseFields.get(counter).getText().toUpperCase()));
            }
            counter++;
        }
        return newCourseList;
    }

    private void saveUser() {

        userController.setUser(user);
        try {
            userController.saveUser();
        } catch (IOException badSave) {
            System.out.println("Bad Save");
        }
    }

}
