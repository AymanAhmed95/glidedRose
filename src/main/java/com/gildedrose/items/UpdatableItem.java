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

}
