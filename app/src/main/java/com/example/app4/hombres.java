package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Random;

public class hombres extends AppCompatActivity {

    //Todo lo relacionado al boton compartir de reflexion
    String StringReflexion ;
    ImageButton btncompartirReflexion;
    TextView reflexion;

    //Todo lo relacionado al boton compartir Imagen
    ImageView imagen;
    ImageButton btncompartirSuperacion;

    //TextView de para el nombre
    TextView txtNombre;

    //Boton de Salir
    ImageButton btnSalir2;

    //Boton de generar Imagen de Superacion y Reflexion
    Button btnsuperacion, btnReflexion;

    //Generador Random
    Random generador = new Random();
    Integer[] imagenesID =
            {R.drawable.sh1, R.drawable.sh2, R.drawable.sh3, R.drawable.sh4, R.drawable.sh5};

    int resources = imagenesID[generador.nextInt(imagenesID.length)];

    //String de Reflexiones
    final String reflexiones[]={
            "El hombre perfecto no es aquel que tiene musculos, ni dinero, ni carro, sino el que hace todo lo posible por Verte sonreir.",
            "Lo unico que es un fin en si mismo es el hombre, nunca puede ser utilizado como medio.",
            "Detras de ese tenebroso y dictador hombre hay un niño que necesita amor y comprension.",
            "Nada dura para siempre, ni el dolor ni la alegria.",
            "Los hombres construyen demasiados muros y no suficiente puentes (Analizalo).",
            "Sigue a tu corazon, el siempre conoce el camino.",
            "Aveces aquello que no podemos entender comienza a cobrar sentido con el paso del tiempo."
    };

    //valores int
    int resources1 = imagenesID[generador.nextInt(imagenesID.length)];
    int resource = generador.nextInt(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hombres);
        //Inicializacion
        reflexion = findViewById(R.id.txtReflexion);
        txtNombre = findViewById(R.id.txtNombre);
        btnsuperacion = findViewById(R.id.btnsuperacion);
        btnReflexion = findViewById(R.id.btnReflexion);
        btncompartirSuperacion = findViewById(R.id.btnCompartirSuperacion);
        btncompartirReflexion = findViewById(R.id.btnCompartirReflexion);
        imagen = findViewById(R.id.image);
        btnSalir2 = findViewById(R.id.btnSalir2);
        //Completed
        Intent intent=getIntent();
        txtNombre.setText(intent.getStringExtra("Nombre1"));

        final ImageView iv = (ImageView) findViewById(R.id.image);

        //Boton Superacion
        View nextButton = findViewById(R.id.btnsuperacion);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resources = imagenesID[generador.nextInt(imagenesID.length)];
                iv.setImageResource(resources);
            }
        });

        //Boton compartir superacion
        btncompartirSuperacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compartirSup();
            }
        });

        //Boton de Reflexion
        btnReflexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resource = generador.nextInt(5);
                StringReflexion = reflexiones[resource];
                reflexion.setText(StringReflexion);
            }
        });


        //Boton de Salir
        btnSalir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(hombres.this);
                builder.setTitle("Salida");
                builder.setMessage("¿Esta seguro de que quiere salir de la Aplicacion?");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        finishAffinity();
                        Toast.makeText(hombres.this, "Saliendo...", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        Toast.makeText(hombres.this, "Cancelando accion", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
    }

    //Boton de Volver al principio
    public void volverMain(View view) {
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
    }

    //Boton de volver la actividad atras
    public void volver(View view) {
        Intent intent = new Intent(this, vista2.class);
        startActivity(intent);
    }

    //Boton de compartir Imagen de Superacion
    public void compartirSup(){
        Intent share = new Intent(Intent.ACTION_SEND);
        Bitmap b = BitmapFactory.decodeResource(getResources(), resources1);
        share.setType("image/jpeg");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(getContentResolver(), b, "Superacion", null);
        Uri imageUri =  Uri.parse(path);
        share.putExtra(Intent.EXTRA_STREAM, imageUri);
        startActivity(Intent.createChooser(share, "Select"));
    }

    // //Boton de compartir Texto de Reflexion
    public void compartirRef(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, StringReflexion);
        intent.setType("text/plain");
        Intent intent2 = Intent.createChooser(intent, "Hola");
        startActivity(intent2);

    }
}