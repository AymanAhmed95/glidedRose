package com.gildedrose.factory;

import com.gildedrose.Item;
import com.gildedrose.items.*;

public class UpdatableItemFactory {

    public static UpdatableItem getUpdatableItem(Item item) {
        switch (item.name) {
            case "Aged Brie":
                return AgedItem.getInstance(item);
            case "Backstage passes to a TAFKAL80ETC concert":
                return ControlledAgedItem.getInstance(item);
            case "Sulfuras, Hand of Ragnaros":
                return LegendaryItem.getInstance(item);
            case "Conjured":
                return NormalItem.getInstance(item, 2);
            default:
                return NormalItem.getInstance(item, 1);
        }
    }
}
