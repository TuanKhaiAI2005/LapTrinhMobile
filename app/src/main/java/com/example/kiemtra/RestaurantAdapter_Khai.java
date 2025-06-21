// RestaurantAdapter_Khai.java
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

public class RestaurantAdapter_Khai extends RecyclerView.Adapter<RestaurantAdapter_Khai.RestaurantViewHolder> {

    private Context context;
    private List<Restaurant_Khai> restaurantList;

    public RestaurantAdapter_Khai(Context context, List<Restaurant_Khai> restaurantList) {
        this.context = context;
        this.restaurantList = restaurantList;
    }

    @NonNull
    @Override
    public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_restaurant_khai, parent, false);
        return new RestaurantViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
        Restaurant_Khai restaurant = restaurantList.get(position);
        holder.tvName.setText(restaurant.getName());
        holder.tvAddress.setText(restaurant.getAddress());
        holder.imgRestaurant.setImageResource(restaurant.getImageResId());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FoodListActivity_Khai.class);
            intent.putExtra("restaurantId", restaurant.getId());
            intent.putExtra("restaurantName", restaurant.getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public static class RestaurantViewHolder extends RecyclerView.ViewHolder {
        ImageView imgRestaurant;
        TextView tvName, tvAddress;

        public RestaurantViewHolder(@NonNull View itemView) {
            super(itemView);
            imgRestaurant = itemView.findViewById(R.id.imgRestaurant_Khai);
            tvName = itemView.findViewById(R.id.tvRestaurantName_Khai);
            tvAddress = itemView.findViewById(R.id.tvRestaurantAddress_Khai);
        }
    }
}
