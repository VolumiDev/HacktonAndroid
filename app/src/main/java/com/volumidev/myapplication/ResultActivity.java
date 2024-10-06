package com.volumidev.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{
     ImageButton btn_back2;
     Intent intent;
     TextView textViewResult;
     ImageView imgResult;
     MediaPlayer mediaPlayer;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewResult=findViewById(R.id.textViewResult);
        //Volver a jugar
        btn_back2=findViewById(R.id.btn_back2);
        btn_back2.setOnClickListener(this);
        intent=new Intent(ResultActivity.this, MainActivity.class);


        //Imagen
        imgResult=findViewById(R.id.imageViewResult);

        //Resultado
        int progress=intent.getIntExtra("progress", 0);

        if(progress==10){
            sonidoVictoria();
            imgResult.setImageResource(R.drawable.win);
            textViewResult.setText("YOU REACHED TO THE MOON");
        } else {
            sonidoDerrota();
            imgResult.setImageResource(R.drawable.lose);
            textViewResult.setText("Sorry, you lose in the " + progress + "º trial");
        }


    }

    @Override
    public void onClick(View v) {
        startActivity(intent);
    }

    public void sonidoDerrota(){
        mediaPlayer=MediaPlayer.create(this,R.raw.derrota);
        mediaPlayer.start();
        //Libera recursos cuando se ejecuta el audio
        mediaPlayer.setOnCompletionListener(mp -> mediaPlayer.release());
    }

    public void sonidoVictoria(){
        mediaPlayer=MediaPlayer.create(this,R.raw.victoria);
        mediaPlayer.start();
        //Libera recursos cuando se ejecuta el audio
        mediaPlayer.setOnCompletionListener(mp -> mediaPlayer.release());
    }
}