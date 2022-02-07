package com.gildedrose.items;

import com.gildedrose.Item;

import  com.gildedrose.Utils;


public class ControlledAgedItem extends UpdatableItem {

    public ControlledAgedItem(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        if (isExpired()) {
            item.quality = 0;
        }else {

            int by = 1;
            if (Utils.inRangeInclusive(item.sellIn, 1, 5)) {
                by = 3;
            } else if (Utils.inRangeInclusive(item.sellIn, 6, 10)) {
                by = 2;
            }
            if (item.quality < 50) {
                item.quality += by;
            }
        }
    }

}
