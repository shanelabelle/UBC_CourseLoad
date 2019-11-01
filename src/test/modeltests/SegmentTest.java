package modeltests;

import model.Segment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SegmentTest {

    @Test
    void testConstructor() {
        Segment seg = new Segment("Final",55);
        assertEquals("Final",seg.getType());
        assertEquals(55,seg.getWeight());
    }
}
