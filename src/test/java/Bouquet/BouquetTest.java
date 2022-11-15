package Bouquet;

import Decorations.Decorations;
import Flowers.Flowers;
import Flowers.Rose;
import Flowers.Tulip;
import Flowers.Color.*;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BouquetTest {

    @Test
    void addToBouquet() throws ParseException {
        Bouquet bq = new Bouquet();
        Rose r1 = new Rose();
        Rose r2 = new Rose();
        bq.AddToBouquet(r1);
        bq.AddToBouquet(r2);
        assertEquals(2,bq.flowersArr.size());
    }

    @Test
    void addDecor() {
        Bouquet bq = new Bouquet();
        Decorations dc1 = new Decorations("123", 1.0);
        Decorations dc2 = new Decorations("123", 1.0);
        Decorations dc3 = new Decorations("123", 1.0);
        bq.AddDecor(dc1);
        bq.AddDecor(dc1);
        bq.AddDecor(dc1);
        assertEquals(3, bq.decorArr.size());
    }

    @Test
    void removeFlower() throws ParseException {
        Bouquet bq = new Bouquet();
        Rose r1 = new Rose();
        Rose r2 = new Rose();
        bq.AddToBouquet(r1);
        bq.AddToBouquet(r2);
        bq.RemoveFlower(r1);
        assertEquals(1,bq.flowersArr.size());
    }

    @Test
    void testRemoveFlower() throws ParseException {
        Bouquet bq = new Bouquet();
        Rose r1 = new Rose();
        Rose r2 = new Rose();
        bq.AddToBouquet(r1);
        bq.AddToBouquet(r2);
        bq.RemoveFlower(0);
        bq.RemoveFlower(0);
        assertEquals(0,bq.flowersArr.size());
    }

    @Test
    void removeDecorations() {
        Decorations dc1 = new Decorations("123", 1.0);
        Decorations dc2 = new Decorations("123", 1.0);
        ArrayList<Decorations> decorArr = new ArrayList<Decorations>();
        decorArr.add(dc1);
        decorArr.add(dc2);
        decorArr.remove(dc2);
        assertEquals(1, decorArr.size());
    }

    @Test
    void testRemoveDecorations() {
        Decorations dc1 = new Decorations("123", 1.0);
        Decorations dc2 = new Decorations("123", 1.0);
        Decorations dc3 = new Decorations("123", 1.0);
        ArrayList<Decorations> decorArr = new ArrayList<Decorations>();
        decorArr.add(dc1);
        decorArr.add(dc2);
        decorArr.add(dc3);
        decorArr.remove(1);
        decorArr.remove(0);
        assertEquals(1, decorArr.size());
    }

    @Test
    void findPrice() throws ParseException {
        Bouquet bq = new Bouquet();
        Rose r1 = new Rose();
        Rose r2 = new Rose();
        bq.AddToBouquet(r1);
        bq.AddToBouquet(r2);
        assertEquals(150.00, bq.FindPrice());
    }

    @Test
    void findShortestStem() throws ParseException {
        Bouquet bq = new Bouquet();
        Rose r1 = new Rose();
        Rose r3 = new Rose();
        Rose r2 = new Rose();
        r2.ChangeStem(9.60);
        bq.AddToBouquet(r1);
        bq.AddToBouquet(r2);
        bq.AddToBouquet(r3);
        bq.FindShortestStem();
        assertEquals(9.6, bq.flowersArr.get(0).stem_len);
    }
            @Test
    void findFreshest() throws ParseException {
        Bouquet bq = new Bouquet();
        Rose r1 = new Rose();
        Tulip r3 = new Tulip();
        Rose r2 = new Rose();
        bq.AddToBouquet(r1);
        bq.AddToBouquet(r2);
        bq.AddToBouquet(r3);
        bq.FindFreshest();
        assertEquals("19.10.2022", bq.flowersArr.get(0).ArrivalDate);
    }
}