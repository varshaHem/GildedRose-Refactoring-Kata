package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            updateQuality(item);

            updateSellIn(item);

            handleIfExpired(item);
        }
    }

    private void updateQuality(Item item) {

        if (!item.name.equals("Aged Brie")
                && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            decreaseQualityIfItemHasQuality(item);
        } else {
            if (item.quality < 50) {
                increaseQuality(item);
                updateQualityOfBackStagePasses(item);
            }
        }
    }



    private void decreaseQualityIfItemHasQuality(Item item) {
        if (item.quality > 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = item.quality - 1;
        }
    }

    private void updateQualityOfBackStagePasses(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }
    }

    private void increaseQualityIfLessThanMax(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private void updateSellIn(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void handleIfExpired(Item item) {
        if (item.sellIn < 0) {
            handleExpired(item);
        }
    }

    private void handleExpired(Item item) {
        if (!item.name.equals("Aged Brie")) {
            handleExpiredItemNotAgedBrie(item);
        } else {
            increaseQuality(item);
        }
    }

    private void handleExpiredItemNotAgedBrie(Item item) {
        if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            decreaseQualityIfItemHasQuality(item);
        } else {
            item.quality = item.quality - item.quality;
        }
    }


}
