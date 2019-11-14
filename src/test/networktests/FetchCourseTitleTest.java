package networktests;

import network.FetchCourseTitle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FetchCourseTitleTest {
    FetchCourseTitle fetcher;

    @BeforeEach
    public void setup(){
        this.fetcher = new FetchCourseTitle();
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
}
