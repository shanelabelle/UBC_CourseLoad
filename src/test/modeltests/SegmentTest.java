package modeltests;

import model.Course;
import model.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SegmentTest {
    Segment seg;

    @BeforeEach
    void setup() {
        this.seg = new Segment("Final",55);
    }

    @Test
    void testConstructor() {
        assertEquals("Final",seg.getType());
        assertEquals(55,seg.getWeight());
    }

    @Test
    void testGetType() {
        assertEquals("Final", seg.getType());
    }

    @Test
    void testGetWeight() {
        assertEquals(55,seg.getWeight());
    }

    @Test
    void equalsTestTrue() {
        Segment otherSegment = new Segment("Final",55);
        assertEquals(seg, otherSegment);
    }

    @Test
    void equalsTestAllDifferent() {
        Segment otherSegment = new Segment("Midterm",25);
        assertNotEquals(seg, otherSegment);

    }

    @Test
    void equalsTestDiffType() {
        Segment otherSegment = new Segment("Midterm",55);
        assertFalse(seg.equals(otherSegment));

    }

    @Test
    void equalsTestDiffWeight() {
        Segment otherSegment = new Segment("Final",25);
        assertFalse(seg.equals(otherSegment));
    }

    @Test
    void equalsTestNull() {
        assertFalse(seg.equals(null));
    }

    @Test
    void equalsTestSame() {
        assertEquals(seg,seg);
    }

    @Test
    void equalsTestOtherObj() {
        Course course = new Course("CPSC 121");

        assertFalse(course.equals(seg));
    }

    @Test
    void hashCodeTest() {
        Segment otherSegment = new Segment("Final",55);
        assertEquals(seg.hashCode(),otherSegment.hashCode());

    }

}
