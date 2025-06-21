// Food_Khai.java
package com.example.kiemtra;

public class Food_Khai {
    private String name;
    private String size;
    private String price;
    private String restaurantName;
    private int imageResId;

    public Food_Khai(String name, String size, String price, String restaurantName, int imageResId) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.restaurantName = restaurantName;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public String getPrice() {
        return price;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public int getImageResId() {
        return imageResId;
    }
}
