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
        if (isExpired(item)) {
            item.quality = 0;
        } else {
            increaseQualityBy(item, getAgedItemControlledQualityIncreaseRate(item));
        }
    }


    private int getAgedItemControlledQualityIncreaseRate(Item item) {
        int by = 1;
        if (inRangeInclusive(item.sellIn, 1, 5)) {
            by = 3;
        } else if (inRangeInclusive(item.sellIn, 6, 10)) {
            by = 2;
        }
        return by;
    }


    private boolean inRangeInclusive(int number, int start, int end) {
        return start <= number && number <= end;
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