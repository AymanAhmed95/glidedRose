package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormalItemTest {

    @Test
    void givenNormalItemQualityDecreasedBy1() {
        Item[] items = new Item[]{new Item("normalItem", 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(49, app.items[0].quality);
    }

    @Test
    void givenNormalItemSellInDecreasedBy1() {
        Item[] items = new Item[]{new Item("normalItem", 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void givenNormalItemQualityDecreasedNotToNegative() {
        Item[] items = new Item[]{new Item("normalItem", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }


    @Test
    void givenNormalItemSellInDecreasedToNegative() {
        Item[] items = new Item[]{new Item("normalItem", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }


    @Test
    void givenNormalItemQualityDecreasedBy2XFaster() {
        Item[] items = new Item[]{new Item("normalItem", 0, 30)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(28, app.items[0].quality);
    }

    @Test
    void givenConjuredItemSellInDecreasedBy1() {
        Item[] items = new Item[]{new Item("Conjured", 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void givenConjuredItemQualityDecreasedBy2x() {
        Item[] items = new Item[]{new Item("Conjured", 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(48, app.items[0].quality);
    }
}
