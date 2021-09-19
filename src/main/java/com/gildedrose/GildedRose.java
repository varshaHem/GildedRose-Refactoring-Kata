package com.gildedrose;

class GildedRose {
    public static final int FAR_FROM_EXPIRY = 11;
    public static final int CLOSE_TO_EXPIRY = 6;
    public static final int MAX_QUALITY = 50;
    Item[] items;
    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQuality(item);

            updateSellIn(item);

            handleIfExpired(item);
        }
    }

    private void updateQuality(Item item) {

        if (isNeitherAgedBrieNorBackStagePassess(item)) {
            decreaseQualityIfItemHasQuality(item);
        } else {
           increaseQualityIfLessThanMax(item);
        }
    }

    private boolean isNeitherAgedBrieNorBackStagePassess(Item item) {
        return !isAgedBrie(item) && !isBackStagePassess(item);
    }


    private void decreaseQualityIfItemHasQuality(Item item) {
        if (item.quality > 0) {
            decreaseQuality(item);
        }
    }

    private void decreaseQuality(Item item) {
        if (isSulfuras(item)) {
            item.quality = item.quality - 1;
        }
    }



    private void updateQualityOfBackStagePasses(Item item) {
        if (isBackStagePassess(item)) {
            if (item.sellIn < FAR_FROM_EXPIRY) {
                increaseQuality(item);
            }

            if (item.sellIn < CLOSE_TO_EXPIRY) {
                increaseQuality(item);
            }
        }
    }

    private void increaseQualityIfLessThanMax(Item item) {
        if (item.quality < MAX_QUALITY) {
            increaseQuality(item);
            updateQualityOfBackStagePasses(item);
        }
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private void updateSellIn(Item item) {
        if (isSulfuras(item)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void handleIfExpired(Item item) {
        if (item.sellIn < 0) {
            handleExpired(item);
        }
    }

    private void handleExpired(Item item) {
        if (isAgedBrie(item)) {
            increaseQuality(item);
        } else {
            handleExpiredItemNotAgedBrie(item);
        }
    }

    private void handleExpiredItemNotAgedBrie(Item item) {
        if (isBackStagePassess(item)) {
            item.quality = 0;
        } else {
            decreaseQualityIfItemHasQuality(item);
        }
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(ItemName.AGED_BRIE.getItemName());
    }

    private boolean isBackStagePassess(Item item) {
        return item.name.equals(ItemName.BACKSTAGE_PASSES.getItemName());
    }

    private boolean isSulfuras(Item item) {
        return !item.name.equals(ItemName.SULFURAS.getItemName());
    }

}
