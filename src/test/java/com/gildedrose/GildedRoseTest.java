package com.gildedrose;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    @DisplayName("Test when sell date has passed")
    public void testWhenSellDatePassed() {
        Item[] items = new Item[] { new Item("bar", 0 , 24) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);
    }

    @Test
    @DisplayName("Test when sell date has not passed")
    public void testWhenSellDateNotPassed() {
        Item[] items = new Item[] { new Item("bar", 2 , 24) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(23, app.items[0].quality);
    }

    @Test
    @DisplayName("Test when item is Sulfuras")
    public void testWhenItemisSulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros",11, 24)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        // Sulfuras never decreases in quality
        assertEquals(24, app.items[0].quality);
        assertEquals(11, app.items[0].sellIn);
    }

    @Test
    @DisplayName("Test when item is Backstage Passess and sellIn Value is less than 5")
    public void testWhenItemisBP() {

        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 2 , 24) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(27, app.items[0].quality);

    }

    @Test
    @DisplayName("Test when item is Backstage Passess and sellIn Value is less than 10")
    public void testWhenItemisBPSellinIs6() {

        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 6 , 24) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(26, app.items[0].quality);

    }

    @Test
    @DisplayName("Test when Item is Aged Brie ")
    public void testWhenItemisAgedBrie(){
        Item[] items = new Item[] { new Item("Aged Brie",11, 24)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(25, app.items[0].quality);

    }

    @Test
    @DisplayName("Test when Item is Aged Brie and sellin value is less than 5 ")
    public void testWhenItemisAgedBrieAndSellInIs4(){
        Item[] items = new Item[] { new Item("Aged Brie",0, 24)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(26, app.items[0].quality);

    }

    @Test
    @DisplayName("Test when Item is Conjured ")
    public void testWhenItemisConjured(){
        Item[] items = new Item[] { new Item("Conjured",0, 24)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22, app.items[0].quality);

    }

    @Test
    @DisplayName("Test when Item is Backstage Passess and Sellin Value is 0")
    public void testWhenItemBPSV0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert",0, 24)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        // Quality drops to 0 after concert
        assertEquals(0, app.items[0].quality);
    }



}
