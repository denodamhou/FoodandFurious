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

        txtName = itemView.findViewById(R.id.txt_Name);
        txtPrice = itemView.findViewById(R.id.txt_Price);
        txtInfo = itemView.findViewById(R.id.txt_Info);

    }

    public void bind(Food food){
        txtName.setText(food.getName());
        txtPrice.setText(food.getPrice());
        txtInfo.setText(food.getInfo());
//        senderProfile.setImageDrawable(Drawable.createFromPath((message.getSenderProfile())));
//        txtBody.setText(message.getBody());
    }
}
