package modeltests;

import model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    Course course;

    @BeforeEach
    void setUp() {
        course = new Course("CPSC 210");
    }

    @Test
    void getCourseName() {
        assertEquals("CPSC 210", course.getCourseName());

    }
}