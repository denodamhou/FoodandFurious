package com.example.foodandfurious;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        name = findViewById(R.id.f_name);
        String I_name = getIntent().getStringExtra("name");
        name.setText(I_name);
    }
}