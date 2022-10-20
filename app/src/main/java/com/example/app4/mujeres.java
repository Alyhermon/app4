package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

public class mujeres extends AppCompatActivity {

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
    Integer[] imagenesID=
            {R.drawable.sm1, R.drawable.sm2, R.drawable.sm3, R.drawable.sm4, R.drawable.sm5, R.drawable.rm1, R.drawable.rm2, R.drawable.rm3, R.drawable.rm4, R.drawable.rm5};

    //String de Reflexiones
    final String reflexiones[]={
            "El tiempo que se disfruta es el verdadero tiempo vivido.",
            "No jures durante la prosperidad, no tomes decisiones durante el pesar y no contestes durante un enfado.",
            "Es mas sabio asumir lo peor desde el principio y dejar que lo mejor llegue como una sorpresa.",
            "A veces el corazon ve lo que es invisible a los ojos.",
            "La mayor sabiduria que existe es conocerrse a uno mismo.",
            "Cuando te permites lo que mereces, atraes lo que necesitas.",
            "Mujer segura, deja huella por donde camina."
    };

    //valores int
    int resources = imagenesID[generador.nextInt(imagenesID.length)];
    int resource = generador.nextInt(5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mujeres);

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
        Intent intent = getIntent();
        txtNombre.setText(intent.getStringExtra("Nombre"));
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
                AlertDialog.Builder builder = new AlertDialog.Builder(mujeres.this);
                builder.setTitle("Salida");
                builder.setMessage("¿Esta seguro de que quiere salir de la Aplicacion?");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        finishAffinity();
                        Toast.makeText(mujeres.this, "Saliendo...", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {
                        Toast.makeText(mujeres.this, "Cancelando accion", Toast.LENGTH_SHORT).show();
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
        Bitmap b = BitmapFactory.decodeResource(getResources(), resources);
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