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

    public Course(String name) {

        this.courseName = name;
        this.segments = new ArrayList<>();
        setCourseDescription();
        this.segments.add(new Segment("Final",100));

    }
    // REQUIRES: a segment to check
    // MODIFIES: none
    // EFFECTS: returns TRUE if the segment is in the course
    // returns FALSE if the segment is NOT in the course
    public Boolean contains(Segment segment) {
        return this.segments.contains(segment);
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns string of the course description
    public String getCourseDescription() {
        return this.courseDescription;
    }

    // REQUIRES: none
    // MODIFIES: this
    // EFFECTS: fetches the course description from the web API and sets the the course description
    private void setCourseDescription() {
        FetchCourseDescription fetcher = new FetchCourseDescription();
        try {
            this.courseDescription = fetcher.getCourseTitle(this.courseName);
        } catch (Exception e) {
            this.courseDescription = null;
        }
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns string of course name
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

    // REQUIRES: a segment to add
    // MODIFIES: this
    // EFFECTS: adds the segment to the course if it is not already there
    public void addSegment(Segment segment) {

        if (!this.segments.contains(segment)) {
            segments.add(segment);
        }
    }

    // REQUIRES: a segment to remove
    // MODIFIES: this
    // EFFECTS: removes the segment from the course if it is currently there
    public void removeSegment(Segment segment) {

        if (this.segments.contains(segment)) {
            this.segments.remove(segment);
        }
    }

    // REQUIRES: none
    // MODIFIES: this
    // EFFECTS: sorts the segments in the course from highest weight to smallest weight
    public void sortSegments() {
        this.segments.sort(Segment::compareTo);
        Collections.sort(this.segments, Collections.reverseOrder());
    }

    // REQUIRES: NONE
    // MODIFIES: this
    // EFFECTS: clears all segments currently in the course
    public void clearSegments() {
        this.segments = new ArrayList<>();
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: returns a the list of course segments
    public ArrayList<Segment> getSegments() {
        return this.segments;
    }

    // REQUIRES: none
    // MODIFIES: none
    // EFFECTS: creates an XchartPanel piechart with each of the current segments
    // and returns it to be displayed
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
