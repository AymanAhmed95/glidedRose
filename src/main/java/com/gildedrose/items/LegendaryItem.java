package com.gildedrose.items;

import com.gildedrose.Item;

public class LegendaryItem extends UpdatableItem {
    public LegendaryItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
    }

    @Override
    public void updateSellIn() {
    }

    public static LegendaryItem getInstance(Item item) {
        return new LegendaryItem(item);
    }
}
