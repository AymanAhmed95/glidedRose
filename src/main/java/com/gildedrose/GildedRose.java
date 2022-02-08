package com.gildedrose;

import com.gildedrose.items.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import com.gildedrose.factory.UpdatableItemFactory;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            UpdatableItem updatableItem = UpdatableItemFactory.getUpdatableItem(item);
            updatableItem.updateQuality();
            updatableItem.updateSellIn();
        }
    }



}