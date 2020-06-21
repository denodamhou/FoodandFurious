package com.example.foodandfurious;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class FoodActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_food);
        //make a reference to the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        //Create and set layout manager
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Create and set an adapter
        Food[] foods = loadFoods();
        FoodAdabpter adabpter = new FoodAdabpter(foods);
        recyclerView.setAdapter(adabpter);
    }

    private Food[] loadFoods(){

        //temporary data
        Food food1 = new Food();
        food1.setName("Ice Latte");
        food1.setPrice("1.5$");
        food1.setInfo("coffee and milk");

        Food food2 = new Food();
        food2.setName("Americano");
        food2.setPrice("1.8$");
        food2.setInfo("coffee only");

        return new Food[]{food1, food2};


    }
}