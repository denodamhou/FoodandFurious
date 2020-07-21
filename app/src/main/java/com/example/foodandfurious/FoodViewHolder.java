package com.example.foodandfurious;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {



    private TextView txtName;
    private TextView txtPrice;
    private TextView txtInfo;
    private SimpleDraweeView foodProfile;
    FoodAdapter.onFoodListener onFoodListener;
    public FoodViewHolder(@NonNull View itemView, FoodAdapter.onFoodListener onFoodListener) {
        super(itemView);

        txtName = itemView.findViewById(R.id.txt_Name);
        txtPrice = itemView.findViewById(R.id.txt_Price);
        txtInfo = itemView.findViewById(R.id.txt_Info);
        foodProfile = itemView.findViewById(R.id.img_profile);
        this.onFoodListener =onFoodListener;
        itemView.setOnClickListener(this);
    }

    public void bind(Food food){
        txtName.setText(food.getName());
        txtPrice.setText(food.getPrice());
        txtInfo.setText(food.getInfo());
        foodProfile.setImageURI(food.getImg());
//        senderProfile.setImageDrawable(Drawable.createFromPath((message.getSenderProfile())));
//        txtBody.setText(message.getBody());
    }

    @Override
    public void onClick(View v) {
        onFoodListener.onFoodClick(getAdapterPosition());
    }
}
