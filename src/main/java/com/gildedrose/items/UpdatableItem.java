package com.gildedrose.items;

import com.gildedrose.Item;

public abstract class UpdatableItem {
    protected Item item;

    public UpdatableItem(Item item) {
        this.item = item;
    }

    public abstract void updateQuality();

    public void updateSellIn() {
        item.sellIn--;
    }

    protected Boolean isExpired() {
        return item.sellIn <= 0;
    }

    protected void increaseQualityBy(int by) {
        int newQuality = item.quality + by;
        item.quality = Math.min(newQuality, 50);
    }

    protected void decreaseQualityBy(int by) {
        int newQuality = item.quality - by;
        item.quality = Math.max(newQuality, 0);
    }
}
