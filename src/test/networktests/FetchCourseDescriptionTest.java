package networktests;

import network.FetchCourseDescription;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FetchCourseDescriptionTest {
    FetchCourseDescription fetcher;

    @BeforeEach
    public void setup(){
        this.fetcher = new FetchCourseDescription();
    }

    @Test
    void getCourseTitleTestGood() {
        try {
            String courseTitle = fetcher.getCourseTitle("CPSC 210");
            assertEquals("Software Construction",courseTitle);
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    void createCourseURLTest() {
        String url = fetcher.createCourseUrl("CPSC 210");
        assertEquals("https://ubc-courses-api.herokuapp.com/2019W/CPSC/210/", url);
    }

}
