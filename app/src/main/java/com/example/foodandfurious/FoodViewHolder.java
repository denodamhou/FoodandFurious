package com.example.foodandfurious;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class FoodViewHolder extends RecyclerView.ViewHolder  {

    private TextView txtName;
    private TextView txtPrice;
    private TextView txtInfo;


    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);
    }
    public void bind(Food food){
        txtName.setText(food.getName());
        txtPrice.setText(food.getPrice());
        txtInfo.setText(food.getInfo());

    }
}
