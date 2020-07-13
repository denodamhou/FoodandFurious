package com.example.foodandfurious;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class FoodActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

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
        loadFoods();



    }

    private void loadFoods(){

        String url = "https://my.api.mockaroo.com/users.json?key=05cf9190";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Food[] foods = gson.fromJson(response,Food[].class);
                System.out.println(foods);
                FoodAdabpter adapter = new FoodAdabpter(foods);
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
}