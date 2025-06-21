// FoodAdapter_Khai.java
package com.example.kiemtra;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter_Khai extends RecyclerView.Adapter<FoodAdapter_Khai.FoodViewHolder> {

    private Context context;
    private List<Food_Khai> foodList;

    public FoodAdapter_Khai(Context context, List<Food_Khai> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food_khai, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food_Khai food = foodList.get(position);
        holder.tvName.setText(food.getName());
        holder.tvSize.setText(food.getSize());
        holder.tvPrice.setText(food.getPrice());
        holder.tvRestaurant.setText(food.getRestaurantName());
        holder.imgFood.setImageResource(food.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FoodDetailActivity_Khai.class);
            intent.putExtra("foodName", food.getName());
            intent.putExtra("restaurantName", food.getRestaurantName());
            intent.putExtra("description", "Đây là mô tả mẫu của món " + food.getName());
            intent.putExtra("imageResId", food.getImageResId());
            intent.putExtra("basePrice", parsePrice(food.getPrice()));
            context.startActivity(intent);
        });
    }

    private int parsePrice(String priceText) {
        try {
            return Integer.parseInt(priceText.replace(" VNĐ", "").replace(".", ""));
        } catch (Exception e) {
            return 10000;
        }
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFood;
        TextView tvName, tvSize, tvPrice, tvRestaurant;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.imgFood_Khai);
            tvName = itemView.findViewById(R.id.tvFoodName_Khai);
            tvSize = itemView.findViewById(R.id.tvFoodSize_Khai);
            tvPrice = itemView.findViewById(R.id.tvFoodPrice_Khai);
            tvRestaurant = itemView.findViewById(R.id.tvFoodRestaurant_Khai);
        }
    }
}
