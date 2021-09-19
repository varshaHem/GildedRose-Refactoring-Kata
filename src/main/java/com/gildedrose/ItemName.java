package com.gildedrose;

public enum ItemName  {

    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS("Sulfuras, Hand of Ragnaros");

    private final String itemName;

    ItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

}
