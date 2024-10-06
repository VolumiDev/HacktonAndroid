package com.volumidev.myapplication;

import android.content.Intent;
import android.os.Bundle;
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

     //ObjectAnimator animator;


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

        //Volver a jugar
        btn_back2=findViewById(R.id.btn_back2);
        btn_back2.setOnClickListener(this);
        intent=new Intent(ResultActivity.this, MainActivity.class);

        //Imagen
        imgResult=findViewById(R.id.imageViewResult);

        //Resultado
        String valorResultado=intent.getStringExtra("final");


        if(valorResultado.contentEquals("ganaste")){
            imgResult.setImageResource(R.drawable.win);
            textViewResult.setText("Llegaste a la luna!!!");
        } else {
            imgResult.setImageResource(R.drawable.lose);
            textViewResult.setText("Perdiste en la " + "fase");
        }

        /**
        //Animación flecha
        do {
            animator = ObjectAnimator.ofFloat(btn_back2, "translationX", 200f);
            animator.setDuration(200);
            animator.start();
        } while (true);
         **/


        //imgResult.setTranslationX(100f);
        //imgResult.setTranslationX(-100f);





    }

    @Override
    public void onClick(View v) {
        startActivity(intent);
    }


}