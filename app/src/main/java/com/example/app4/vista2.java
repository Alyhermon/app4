package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class vista2 extends AppCompatActivity {

    RadioButton F, M;
    EditText edtNombre;
    Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista2);
        btnAceptar = findViewById(R.id.btnaceptar);
        edtNombre = findViewById(R.id.edtnombre);

        //RADIOS BUTTON
        F = findViewById(R.id.rbfemen);
        M = findViewById(R.id.rbmasc);

        //BUTTON DE ACEPTAR
        btnAceptar.setOnClickListener(new View.OnClickListener() {

            String cad = "Campo Vacio o genero no seleccionado \n";
            @Override
            public void onClick(View view) {

                if ((validar() == true && F.isChecked() == true)){
                    cad="Bienvenidos a la seccion de Mujeres \n";
                    Intent intent = new Intent(getApplicationContext(), mujeres.class);

                    intent.putExtra("Nombre", edtNombre.getText().toString());
                    startActivity(intent);

                }

                if (validar() == true && M.isChecked() == true){
                    cad="Bienvenidos a la seccion de Hombres";
                    Intent intent = new Intent(getApplicationContext(), hombres.class);

                    intent.putExtra("Nombre1", edtNombre.getText().toString());
                    startActivity(intent);

                }
                Toast.makeText(getApplicationContext(), cad, Toast.LENGTH_LONG).show();

            }
        });
    }

    public void volverMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public boolean validar(){

        boolean retorno = true;

        String c1 = edtNombre.getText().toString();
        if (c1.isEmpty()){
            edtNombre.setError("Debe de ingresar su Nombre");
            retorno= false;
        }
        return retorno;
    }
}