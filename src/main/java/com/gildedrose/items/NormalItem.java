package com.gildedrose.items;

import com.gildedrose.Item;

public class NormalItem extends UpdatableItem {

    private int factor = 1;

    public NormalItem(Item item) {
        super(item);
    }

    public NormalItem(Item item, Integer factor) {
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
        decreaseQualityBy(by * factor);
    }


    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public static NormalItem getInstance(Item item, int factor) {
        return new NormalItem(item, factor);
    }
}
