package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class hombres extends AppCompatActivity {

    TextView txtNombre;
    Button btnMujer, btnHombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hombres);
        txtNombre = findViewById(R.id.txtNombre);
        btnMujer = findViewById(R.id.btnFemenino);
        btnHombre = findViewById(R.id.btnMasculino);


        Intent intent=getIntent();
        txtNombre.setText(intent.getStringExtra("Nombre1"));

    }

    //Boton de Volver al principio
    public void volver(View view) {
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
    }

    public void Mascu(View view) {
        Intent mascu = new Intent(this, hombres.class);
        startActivity(mascu);
    }

    public void volverMain(View view) {
        Intent intent = new Intent(this, vista2.class);
        startActivity(intent);
    }

}