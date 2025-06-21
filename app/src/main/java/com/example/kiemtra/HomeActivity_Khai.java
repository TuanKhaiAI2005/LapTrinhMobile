// HomeActivity_Khai.java
package com.example.kiemtra;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity_Khai extends AppCompatActivity {

    RecyclerView recyclerViewRestaurant_Khai;
    List<Restaurant_Khai> restaurantList_Khai;
    RestaurantAdapter_Khai adapter_Khai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_khai);

        recyclerViewRestaurant_Khai = findViewById(R.id.recyclerViewRestaurant_Khai);
        recyclerViewRestaurant_Khai.setLayoutManager(new LinearLayoutManager(this));

        restaurantList_Khai = new ArrayList<>();
        restaurantList_Khai.add(new Restaurant_Khai(1, "Quán bánh mì cô Ba", "Hẻm 68 Bùi Thị Xuân, Tân Bình", R.drawable.nha_hang));
        restaurantList_Khai.add(new Restaurant_Khai(2, "Phở Dũng", "123 Lê Văn Sỹ, Quận 3", R.drawable.pho_bo));
        restaurantList_Khai.add(new Restaurant_Khai(3, "Bún đậu Nhi", "56 Nguyễn Thái Học, Q1", R.drawable.bun_dau));
        restaurantList_Khai.add(new Restaurant_Khai(4, "Hủ tiếu Mỹ Tho", "99 Trần Hưng Đạo, Q5", R.drawable.hu_tieu));
        restaurantList_Khai.add(new Restaurant_Khai(5, "Cơm tấm Minh", "12 Võ Văn Tần, Q10", R.drawable.com_tam));

        adapter_Khai = new RestaurantAdapter_Khai(this, restaurantList_Khai);
        recyclerViewRestaurant_Khai.setAdapter(adapter_Khai);
    }
}
