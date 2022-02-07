package com.gildedrose.items;

import com.gildedrose.Item;

public class NormalItem extends UpdatableItem {
    int factor = 1;

    public NormalItem(Item item) {
        super(item);
    }

    public NormalItem(Item item, int factor) {
        super(item);
        this.factor = factor;
    }

    @Override
    public void updateQuality() {
        int by;
        if (isExpired()) {
            by = 2;
        } else {
            by = 1;
        }
        if (item.quality > 0) {
            item.quality -= by * factor;
        }
    }
}
