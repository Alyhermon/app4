package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

public class mujeres extends AppCompatActivity {

    Random generador = new Random();
    Integer[] imagenesID=
            {R.drawable.sm1, R.drawable.sm2, R.drawable.sm3, R.drawable.sm4, R.drawable.sm5};
    Integer[] imagenesID2=
            {R.drawable.rm1, R.drawable.rm2, R.drawable.rm3, R.drawable.rm4, R.drawable.rm5};

    TextView txtNombre;
    ImageView imagen;
    Button btnsuperacion, btnReflexion, btncompartir;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mujeres);
        txtNombre = findViewById(R.id.txtNombre);
        btnsuperacion = findViewById(R.id.btnsuperacion);
        btnReflexion = findViewById(R.id.btnReflexion);
        btncompartir = findViewById(R.id.btnCompartir);
        imagen = findViewById(R.id.image);
        //Completed
        Intent intent=getIntent();
        txtNombre.setText(intent.getStringExtra("Nombre"));
        ///////////////////////////////////////////////////////////////////
        Integer q = imagenesID[generador.nextInt(imagenesID.length)];

        final ImageView iv = (ImageView) findViewById(R.id.image);

        View nextButton = findViewById(R.id.btnsuperacion);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int resources =
                        imagenesID[generador.nextInt(imagenesID.length)];
                iv.setImageResource(resources);
            }
        });

        View nextButton2 = findViewById(R.id.btnReflexion);
        nextButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int resources2 =
                        imagenesID2[generador.nextInt(imagenesID2.length)];
                iv.setImageResource(resources2);
            }
        });

        btncompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               share();
            }
        });

        //Boton para compartir las imagenes

    }

    //Boton de Volver al principio
    public void volverMain(View view) {
        Intent volver = new Intent(this, MainActivity.class);
        startActivity(volver);
    }

    public void volver(View view) {
        Intent intent = new Intent(this, vista2.class);
        startActivity(intent);
    }
    public void share(){
        Intent share = new Intent(Intent.ACTION_SEND);
        Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.rm2);
        share.setType("image/jpeg");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(getContentResolver(), b, "Superacion", null);
        Uri imageUri =  Uri.parse(path);
        share.putExtra(Intent.EXTRA_STREAM, imageUri);
        startActivity(Intent.createChooser(share, "Select"));
    }

}