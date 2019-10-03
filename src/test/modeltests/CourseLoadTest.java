package modeltests;

import model.CourseLoad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourseLoadTest {
    CourseLoad courseload;


    @BeforeEach
    void setUp() {
        courseload = new CourseLoad();
    }

    @Test
    void addCourse() {
        courseload.addProject("CPSC 210");

        assertEquals(courseload.getProjectList().get(0).toString(), "CPSC 210");
    }

    @Test
    void removeCourse() {
        courseload.addProject("CPSC 210");
        courseload.removeProject("CPSC 210");

        assertTrue(courseload.getProjectList().isEmpty());
    }

    @Test
    void getCourseList() {
        courseload.addProject("CPSC 210");
        courseload.addProject("PHYS 333");
        courseload.addProject("MATH 302");

        ArrayList<String> coursecheck = new ArrayList();

        coursecheck.add("CPSC 210");
        coursecheck.add("PHYS 333");
        coursecheck.add("MATH 302");

        int i = 0;

        while (i < coursecheck.size()){
            assertEquals(courseload.getProjectList().get(i).toString(), coursecheck.get(i));
            i++;
        }
    }

    @Test
    void getNumberOfCourses() {
    }
}