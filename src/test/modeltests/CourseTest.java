package modeltests;

import model.Course;
import model.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.style.PieStyler;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    Course course;
    Segment segment1;
    Segment segment2;

    @BeforeEach
    void setUp() {
        course = new Course("CPSC 210");
        segment1 = new Segment("Final", 45);
        segment2 = new Segment("Midterm", 25);
    }

    @Test
    void getCourseNameTest() {
        assertEquals("CPSC 210", course.getName());

    }

    @Test
    void toStringTest() {
        assertEquals(course.getName(),"CPSC 210");
    }

    @Test
    void getCourseDescriptionTest() {
        assertEquals("Software Construction",course.getCourseDescription());
    }


    @Test
    void addSegmentTestAlreadyThere() {
        course.addSegment(segment1);
        course.addSegment(segment1);

        assertEquals(2, course.getSegments().size());
    }
    @Test
    void addSegmentTest() {
        course.addSegment(segment1);
        assertTrue(course.contains(segment1));

    }

    @Test
    void removeSegmentTestEmpty() {
        course.removeSegment(segment1);
        assertFalse(course.contains(segment1));
    }

    @Test
    void removeSegmentTest() {
        course.addSegment(segment1);
        course.addSegment(segment2);
        assertTrue(course.contains(segment1));
        assertTrue(course.contains(segment2));

        course.removeSegment(segment2);
        assertFalse(course.contains(segment2));

    }

    @Test
    void sortSegmentTest() {

        course.clearSegments();

        course.addSegment(segment2);
        course.addSegment(segment1);

        assertEquals(segment2, course.getSegments().get(0));
        assertEquals(segment1, course.getSegments().get(1));

        course.sortSegments();

        assertEquals(segment1, course.getSegments().get(0));
        assertEquals(segment2, course.getSegments().get(1));

    }

    @Test
    void equalsTestTrue() {
        Course otherCourse = new Course("CPSC 210");

        assertEquals(course,otherCourse);
    }

    @Test
    void equalsTestFalse() {
        Course otherCourse = new Course("PHYS 333");

        assertNotEquals(course,otherCourse);
    }

    @Test
    void equalsTestOtherObj() {
        Segment segment = new Segment("Final",55);
        assertNotEquals(segment,course);
    }

    @Test
    void equalsTestNull() {
        assertFalse(course.equals(null));
    }

    @Test
    void equalsTestSame() {
        assertEquals(course,course);
    }

    @Test
    void clearSegmentsTest() {

        course.addSegment(segment1);
        course.addSegment(segment2);
        assertFalse(course.getSegments().isEmpty());

        course.clearSegments();
        assertTrue(course.getSegments().isEmpty());

    }

    @Test
    void getSegmentsTest() {
        ArrayList<Segment> segments = new ArrayList<>();
        course.clearSegments();
        course.addSegment(segment1);
        course.addSegment(segment2);

        segments.add(segment1);
        segments.add(segment2);

        assertEquals(segments, course.getSegments());
    }

    @Test
    void getCourseChartTest() {
        PieChart chart = new PieChart(400,400);
        chart.addSeries("Final", 100);
        chart.getStyler().setChartBackgroundColor(Color.WHITE);
        chart.getStyler().setPlotBorderColor(Color.WHITE);
        chart.getStyler().setChartTitleBoxVisible(false);
        chart.getStyler().setAnnotationType(PieStyler.AnnotationType.valueOf("LabelAndPercentage"));
        XChartPanel<PieChart> panel = new XChartPanel(chart);

        assertEquals(panel.getPreferredSize(),course.getCourseChart().getPreferredSize());

    }

    @Test
    void hashCodeTest() {
        Course otherCourse = new Course("CPSC 210");
        assertEquals(course.hashCode(),otherCourse.hashCode());
    }

    @Test
    void iteratorTest() {
        ArrayList<Segment> segments = new ArrayList<>();
        segments.add(new Segment("Final",100));

        assertEquals(course.iterator().next(),segments.get(0));
    }


}