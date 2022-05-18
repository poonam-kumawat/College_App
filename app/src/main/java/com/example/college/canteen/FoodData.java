package com.example.college.canteen;


import android.widget.ScrollView;

public class FoodData {

    private String itemName;

    private String itemPrice;
    private int itemImage;

    public FoodData(String itemName, String itemPrice, int itemImage) {
        this.itemName=itemName;
        this.itemPrice=itemPrice;
        this.itemImage=itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public int getItemImage() {
        return itemImage;
    }
}

