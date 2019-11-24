package model;

import network.FetchCourseDescription;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.XChartPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Course extends Block {

    private String courseName;
    private ArrayList<Segment> segments;
    private String courseDescription;
    private JPanel courseChart;

    public Course(String name) {

        this.courseName = name;
        this.segments = new ArrayList<>();
        setCourseDescription();

    }

    public String getCourseDescription() {
        return this.courseDescription;
    }

    public void setCourseDescription() {
        FetchCourseDescription fetcher = new FetchCourseDescription();
        try {
            this.courseDescription = fetcher.getCourseTitle(this.courseName);
        } catch (Exception e) {
            this.courseDescription = null;
        }
    }

    public String toString() {
        return this.courseName;
    }


    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns course name
    public String getName() {
        return this.courseName;
    }

    public void addSegment(Segment segment) {

        if (!this.segments.contains(segment)) {
            segments.add(segment);
        }
    }

    public void removeSegment(Segment segment) {

        if (this.segments.contains(segment)) {
            this.segments.remove(segment);
        }
    }

    public void sortSegments() {
        this.segments.sort(Segment::compareTo);
        Collections.sort(this.segments, Collections.reverseOrder());
    }

    public ArrayList<Segment> getSegments() {
        return this.segments;
    }

    public JPanel getCourseChart() {

        PieChart chart = new PieChart(400,400);

        for (Segment segment : segments) {
            chart.addSeries(segment.getType(),segment.getWeight());
        }

        chart.getStyler().setChartBackgroundColor(Color.WHITE);
        chart.getStyler().setPlotBorderColor(Color.WHITE);
        chart.getStyler().setChartTitleBoxVisible(false);
        this.courseChart = new XChartPanel<PieChart>(chart);
        return this.courseChart;

    }
}
