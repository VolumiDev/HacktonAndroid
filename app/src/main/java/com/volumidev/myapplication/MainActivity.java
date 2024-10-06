package com.volumidev.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_newGame, btn_exit;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_newGame=findViewById(R.id.btn_newGame);
        btn_newGame.setOnClickListener(this);
        btn_exit=findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(this);

        intent=new Intent(MainActivity.this, WelcomeActivity.class);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_exit:
                ////prueba para las preguntas
                Intent i = new Intent(this, PlayActivity.class);
                startActivity(i);
              //  finishAffinity();  // Esto cerrará todas las actividades
              //  System.exit(0);    // Esto finaliza la aplicación
                break;

            case R.id.btn_newGame:
                startActivity(intent);
                break;
        }
    }


}