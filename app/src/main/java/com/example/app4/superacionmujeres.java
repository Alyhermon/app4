package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class superacionmujeres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superacionmujeres);
    }

    public void volver(View view) {
        Intent intent = new Intent(this, mujeres.class);
        startActivity(intent);
    }
}