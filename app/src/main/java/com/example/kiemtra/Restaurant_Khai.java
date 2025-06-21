// Restaurant_Khai.java
package com.example.kiemtra;

public class Restaurant_Khai {
    private int id;
    private String name;
    private String address;
    private int imageResId;

    public Restaurant_Khai(int id, String name, String address, int imageResId) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.imageResId = imageResId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getImageResId() {
        return imageResId;
    }
}
