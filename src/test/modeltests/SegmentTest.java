package modeltests;

import model.Segment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
