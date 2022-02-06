package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateNormalItem(item);
            } else {
                if (item.name.equals("Aged Brie")) {
                    updateAgedItem(item);
                } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    updateAgedItemControlled(item);
                }
            }
            item.sellIn = item.sellIn - 1;
        }
    }


    private void updateNormalItem(Item item) {
        int by;
        if (isExpired(item)) {
            by = 2;
        } else {
            by = 1;
        }
        decreaseQualityBy(item, by);
    }

    private void updateAgedItem(Item item) {
        increaseQualityBy(item, 1);
    }

    private void updateAgedItemControlled(Item item) {
        if (item.sellIn > 0) {
            if (item.quality < 50) {
                item.quality++;
                if (item.sellIn <= 10) {
                    item.quality++;
                    if (item.sellIn <= 5) {
                        item.quality++;
                    }
                }
            }
        } else {
            item.quality = 0;
        }
    }


    private Boolean isExpired(Item item) {
        return item.sellIn <= 0;
    }

    private void increaseQualityBy(Item item, int by) {
        if (item.quality < 50) {
            item.quality += by;
        }
    }

    private void decreaseQualityBy(Item item, int by) {
        if (item.quality > 0) {
            item.quality -= by;
        }
    }
}