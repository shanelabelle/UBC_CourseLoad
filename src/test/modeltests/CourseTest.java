package modeltests;

import model.Course;
import model.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void addSegmentTest() {
        course.addSegment(segment1);
        assertTrue(course.contains(segment1));

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


}