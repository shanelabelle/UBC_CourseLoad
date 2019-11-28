package model;

import network.FetchCourseDescription;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.style.PieStyler;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Course implements Iterable<Segment> {

    private String courseName;
    private ArrayList<Segment> segments;
    private String courseDescription;
    private JPanel courseChart;

    public Course(String name) {

        this.courseName = name;
        this.segments = new ArrayList<>();
        setCourseDescription();
        this.segments.add(new Segment("Final",100));

    }

    public Boolean contains(Segment segment) {
        return this.segments.contains(segment);
    }

    public String getCourseDescription() {
        return this.courseDescription;
    }

    private void setCourseDescription() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Course segments = (Course) o;
        return Objects.equals(courseName, segments.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName);
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

    public void clearSegments() {
        this.segments = new ArrayList<>();
    }

    public ArrayList<Segment> getSegments() {
        return this.segments;
    }

    public XChartPanel getCourseChart() {

        PieChart chart = new PieChart(400,400);

        for (Segment segment : segments) {
            chart.addSeries(segment.getType(),segment.getWeight());
        }

        chart.getStyler().setChartBackgroundColor(Color.WHITE);
        chart.getStyler().setPlotBorderColor(Color.WHITE);
        chart.getStyler().setChartTitleBoxVisible(false);
        chart.getStyler().setAnnotationType(PieStyler.AnnotationType.valueOf("LabelAndPercentage"));
        return new XChartPanel<PieChart>(chart);

    }

    @Override
    public Iterator<Segment> iterator() {
        return this.segments.iterator();
    }
}
