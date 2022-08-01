package com.example.cafelegend.model;

public class ItemList {
    private String itemName;
    private int itemPrice;

    public ItemList(String itemName, int itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setFoodPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }


}
