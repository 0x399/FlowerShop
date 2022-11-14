package Flowers;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class FlowersTest {

    @org.junit.jupiter.api.Test
    void testSetPrice() throws ParseException {
        Rose r1 = new Rose();
        r1.setPrice(12.00);
        assertEquals(r1.getPrice(), 12.00);
    }

    @org.junit.jupiter.api.Test
    void changeStem() throws ParseException {
        Rose r1 = new Rose();
        r1.ChangeStem(11.60);
        assertEquals(r1.stem_len, 11.60);
    }

    @org.junit.jupiter.api.Test
    void changeColor() throws ParseException {
        Rose r1 = new Rose();
        r1.changeColor(7);
        assertEquals(r1.color, Color.beige);
    }


    @org.junit.jupiter.api.Test
    void changeDate() throws ParseException {
        Rose r1 = new Rose();
        r1.changeDate("11.02.2022");
        assertEquals(r1.ArrivalDate, "11.02.2022");
    }

}