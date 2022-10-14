package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class mujeres extends AppCompatActivity {

    TextView txtNombre;
    Button btnsuperacion, btnReflexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mujeres);
        txtNombre = findViewById(R.id.txtNombre);
        btnsuperacion = findViewById(R.id.btnsuperacion);
        btnReflexion = findViewById(R.id.btnReflexion);


        Intent intent=getIntent();
        txtNombre.setText(intent.getStringExtra("Nombre"));

    }

    //Boton de Volver al principio
    public void volverMain(View view) {
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
    }

    public void reflexion(View view) {
        Intent reflexion = new Intent(this, reflexionmujeres.class);
        startActivity(reflexion);
    }

    public void superacion(View view) {
        Intent superacion = new Intent(this, superacionmujeres.class);
        startActivity(superacion);
    }

    public void volver(View view) {
        Intent intent = new Intent(this, vista2.class);
        startActivity(intent);
    }
}