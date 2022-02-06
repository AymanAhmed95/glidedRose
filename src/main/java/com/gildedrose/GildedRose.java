package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateNormalItem(item);
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            item.sellIn = item.sellIn - 1;


            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        item.quality = item.quality - item.quality;

                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }


    private void updateNormalItem(Item item) {
        if (item.quality > 0) {
            if (item.sellIn <= 0) {
                item.quality -= 2;
            } else {
                item.quality--;
            }
        }
    }

    private void updateAgedItem(Item item) {
        item.sellIn--;
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void updateAgedItemControlled(Item item) {
        item.sellIn--;
        if (item.sellIn > 0) {
            if (item.quality < 50) {
                item.quality++;
                if (item.sellIn <= 10) {
                    item.quality++;
                    if (item.sellIn <= 5) {
                        item.quality++;
                    }
                }
            }
        } else {
            item.quality = 0;
        }
    }


    private Boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private void increaseQualityBy(Item item, int by) {
        if (item.quality < 50) {
            item.quality += by;
        }
    }
}