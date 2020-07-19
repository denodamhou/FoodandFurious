package com.example.foodandfurious;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FoodAdapter extends RecyclerView.Adapter<FoodViewHolder> {

    private Food[] foods;

    public FoodAdapter(Food[] foods) {
        this.foods = foods;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.view_holder_food, parent, false);

       return new FoodViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foods[position];
        holder.bind(food);
    }

    @Override
    public int getItemCount() {
        return foods.length;
    }
}
