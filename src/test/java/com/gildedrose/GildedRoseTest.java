package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {


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
    void givenAgedBrieItemSellInDecreasedBy1() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void givenAgedBrieItemQualityIncreasedBy1() {
        Item[] items = new Item[]{new Item("Aged Brie", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }


    @Test
    void givenAgedBrieSellInNegativeQualityIncreasedBy1(){
        Item[] items = new Item[]{new Item("Aged Brie", -1, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void givenAgedBrieItemQualityIncreasedNotToAboveMax() {
        Item[] items = new Item[]{new Item("Aged Brie", 5, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }


    @Test
    void givenBackstageItemSellInDecreasedBy1() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }

    @Test
    void givenBackstageItemQualityIncreasedBy2() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void givenBackstageItemQualityIncreasedBy3() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
    }


    @Test
    void givenBackstageItemQualityIncreasedNotToAboveMax() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }


    @Test
    void givenBackstageItemSellInExpiredQualityDecreasedTo0() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", -1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }


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
