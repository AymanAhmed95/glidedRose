package com.gildedrose.items;

import com.gildedrose.Item;

public class AgedItem extends UpdatableItem {

    public AgedItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    public static AgedItem getInstance(Item item) {
        return new AgedItem(item);
    }
}
