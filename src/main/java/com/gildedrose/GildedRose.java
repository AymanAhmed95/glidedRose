package com.gildedrose;

import com.gildedrose.items.*;


import com.gildedrose.factory.UpdatableItemFactory;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public GildedRose(){

    }
    public void updateQuality() {
        for (Item item : items) {
            UpdatableItem updatableItem = UpdatableItemFactory.getUpdatableItem(item);
            updatableItem.updateQuality();
            updatableItem.updateSellIn();
        }
    }


    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items){
        this.items = items;
    }
}