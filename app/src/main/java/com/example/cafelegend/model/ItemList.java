package com.example.cafelegend.model;

public class ItemList {
    private String itemName, itemDesc;
    private int itemPrice;

    public ItemList(String itemName, String itemDesc, int itemPrice) {
        this.itemDesc = itemDesc;
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

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }
}
