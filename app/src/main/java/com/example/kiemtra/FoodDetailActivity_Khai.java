// FoodDetailActivity_Khai.java
package com.example.kiemtra;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FoodDetailActivity_Khai extends AppCompatActivity {

    ImageView imgFood;
    TextView tvName, tvRestaurant, tvPrice, tvDescription;
    RadioGroup sizeGroup;
    RadioButton sizeS, sizeM, sizeL;

    String foodName, restaurantName, description;
    int imageRes;
    int basePrice = 10000; // Giá cơ bản

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail_khai);

        imgFood = findViewById(R.id.imgFoodDetail_Khai);
        tvName = findViewById(R.id.tvFoodNameDetail_Khai);
        tvRestaurant = findViewById(R.id.tvFoodRestaurantDetail_Khai);
        tvPrice = findViewById(R.id.tvFoodPriceDetail_Khai);
        tvDescription = findViewById(R.id.tvFoodDescription_Khai);
        sizeGroup = findViewById(R.id.radioSizeGroup_Khai);
        sizeS = findViewById(R.id.radioSizeS_Khai);
        sizeM = findViewById(R.id.radioSizeM_Khai);
        sizeL = findViewById(R.id.radioSizeL_Khai);

        // Giả lập dữ liệu nhận từ Intent
        foodName = getIntent().getStringExtra("foodName");
        restaurantName = getIntent().getStringExtra("restaurantName");
        description = getIntent().getStringExtra("description");
        imageRes = getIntent().getIntExtra("imageResId", R.drawable.nha_hangg);
        basePrice = getIntent().getIntExtra("basePrice", 10000);

        tvName.setText(foodName);
        tvRestaurant.setText(restaurantName);
        tvDescription.setText(description);
        imgFood.setImageResource(imageRes);

        updatePrice(basePrice); // hiển thị giá mặc định

        sizeGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioSizeS_Khai) {
                updatePrice(basePrice);
            } else if (checkedId == R.id.radioSizeM_Khai) {
                updatePrice((int)(basePrice * 1.5));
            } else if (checkedId == R.id.radioSizeL_Khai) {
                updatePrice(basePrice * 2);
            }
        });
    }

    private void updatePrice(int price) {
        tvPrice.setText("Giá: " + price + " VNĐ");
    }
}
