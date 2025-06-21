// FoodListActivity_Khai.java
package com.example.kiemtra;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FoodListActivity_Khai extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Food_Khai> foodList;
    FoodAdapter_Khai adapter;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list_khai);

        recyclerView = findViewById(R.id.recyclerViewFoodList_Khai);
        tvTitle = findViewById(R.id.tvFoodListTitle_Khai);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Nhận dữ liệu từ Intent
        int restaurantId = getIntent().getIntExtra("restaurantId", -1);
        String restaurantName = getIntent().getStringExtra("restaurantName");

        // Đặt tiêu đề
        tvTitle.setText("Món ăn tại " + restaurantName);

        // Tạm thời dùng dữ liệu mẫu (sau sẽ load từ SQLite theo restaurantId)
        foodList = new ArrayList<>();

        if (restaurantId == 1) {
            foodList.add(new Food_Khai("Bánh mì bò kho", "Size S", "10000 VNĐ", restaurantName, R.drawable.banh_mi));
            foodList.add(new Food_Khai("Bánh mì chả", "Size S", "12000 VNĐ", restaurantName, R.drawable.banh_mi));
        } else if (restaurantId == 2) {
            foodList.add(new Food_Khai("Phở bò đặc biệt", "Size M", "35000 VNĐ", restaurantName, R.drawable.pho_bo));
        } else if (restaurantId == 3) {
            foodList.add(new Food_Khai("Bún đậu thập cẩm", "Size S", "28000 VNĐ", restaurantName, R.drawable.bun_dau));
        } else {
            foodList.add(new Food_Khai("Vịt quay", "Size S", "10000 VNĐ", restaurantName, R.drawable.vit_quay));
        }

        adapter = new FoodAdapter_Khai(this, foodList);
        recyclerView.setAdapter(adapter);
    }
}