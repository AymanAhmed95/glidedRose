package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void givenSulfurasItemQualityNotChanged() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }


    @Test
    void givenSulfurasItemSellInNotChanged() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
    }




}
