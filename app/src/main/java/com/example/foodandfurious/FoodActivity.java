package com.example.foodandfurious;


import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.google.gson.Gson;


public class FoodActivity extends AppCompatActivity implements FoodAdapter.onFoodListener{
    RecyclerView recyclerView;
    Food[] foods;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);

        setContentView(R.layout.activity_food);
        //make a reference to the RecyclerView
        recyclerView = findViewById(R.id.recycler_view);

        //Create and set layout manager
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Create and set an adapter
//        Food[] foods = loadFoods();
//        FoodAdabpter adabpter = new FoodAdabpter(foods);
//        recyclerView.setAdapter(adabpter);
        loadFoods(this);

    }

    private void loadFoods(final FoodAdapter.onFoodListener onFoodListener){

        String url = "https://my.api.mockaroo.com/foods.json?key=05cf9190";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                foods = gson.fromJson(response,Food[].class);

                FoodAdapter adapter = new FoodAdapter(foods,onFoodListener);
//                System.out.println(adapter);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(FoodActivity.this, "Something error", Toast.LENGTH_SHORT).show();
                Log.d("data","Load error : " + error.getMessage());
            }
        });

        Volley.newRequestQueue(this).add(request);
    }

    @Override
    public void onFoodClick(int position) {
        Log.d("click","position: "+position);
        Intent intent = new Intent(this,FoodDetailActivity.class);
        intent.putExtra("name",foods[position].getName());
        intent.putExtra("price",foods[position].getPrice());
        intent.putExtra("info",foods[position].getInfo());
        intent.putExtra("img",foods[position].getImg());
        startActivity(intent);
    }
}