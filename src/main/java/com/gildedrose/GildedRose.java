package com.gildedrose;

import com.gildedrose.items.*;

class GildedRose {
    Item[] items;

    enum ItemType {
        NORMAL,
        QUICK_EXPIRE,
        AGED,
        CONTROLLED_AGED,
        LEGENDARY
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdatableItem updatableItem = getUpdatableItem(item);
            updatableItem.updateQuality();
            updatableItem.updateSellIn();
          /*  ItemType itemType = getItemType(item);
            if (itemType == ItemType.LEGENDARY)
                continue;
            switch (itemType) {
                case NORMAL:
                    updateNormalItem(item);
                    break;
                case AGED:
                    updateAgedItem(item);
                    break;
                case CONTROLLED_AGED:
                    updateControlledAgedItem(item);
                    break;
                case QUICK_EXPIRE:
                    updateQuickExpireItem(item);
            }
            item.sellIn = item.sellIn - 1;*/
        }
    }


    private void updateNormalItem(Item item) {
        decreaseNormalItemQuality(item, 1);
    }

    private void updateQuickExpireItem(Item item) {
        int factor = getQuickExpireFactor(item);
        decreaseNormalItemQuality(item, factor);
    }

    private int getQuickExpireFactor(Item item) {
        int factor = 1;
        if (item.name.equals("Conjured"))
            factor = 2;
        return factor;
    }

    private void decreaseNormalItemQuality(Item item, int factor) {
        int by;
        if (isExpired(item)) {
            by = 2;
        } else {
            by = 1;
        }
        decreaseQualityBy(item, by * factor);
    }

    private void updateAgedItem(Item item) {
        increaseQualityBy(item, 1);
    }

    private void updateControlledAgedItem(Item item) {
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

    private Boolean isExpired(Item item) {
        return item.sellIn <= 0;
    }

    private ItemType getItemType(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros"))
            return ItemType.LEGENDARY;
        else if (item.name.equals("Aged Brie"))
            return ItemType.AGED;
        else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
            return ItemType.CONTROLLED_AGED;
        else if (item.name.equals("Conjured"))
            return ItemType.QUICK_EXPIRE;
        else return ItemType.NORMAL;
    }


    private UpdatableItem getUpdatableItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return new AgedItem(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return new ControlledAgedItem(item);
            case "Sulfuras, Hand of Ragnaros":
                return new LegendaryItem(item);
            case "Conjured":
                return new NormalItem(item, 2);
            default:
                return new NormalItem(item);
        }
    }
}