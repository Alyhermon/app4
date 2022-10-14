package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSalir = findViewById(R.id.btnsalir);


        //Alerta de Boton para salir de la Aplicacion

        btnSalir.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Salida");
            builder.setMessage("¿Esta seguro de que quiere salir de la Aplicacion?");
            builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog,int which) {
                    finishAffinity();
                    Toast.makeText(MainActivity.this, "Saliendo...", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog,int which) {
                    Toast.makeText(MainActivity.this, "Cancelando accion", Toast.LENGTH_SHORT).show();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();

        }
    });

    }


    //Boton para pasar a la siguiente pagina
    public void siguiente(View view) {
        Intent i = new Intent(this, vista2.class);
        startActivity(i);
    }
}
