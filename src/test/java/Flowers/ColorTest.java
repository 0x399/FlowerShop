package Flowers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    @Test
    void getTypeByOrdinal() {
        assertEquals(Color.white, Color.getTypeByOrdinal(0));
        assertEquals(Color.black, Color.getTypeByOrdinal(1));
        assertEquals(Color.red, Color.getTypeByOrdinal(2));
        assertEquals(Color.yellow, Color.getTypeByOrdinal(3));
    }
}