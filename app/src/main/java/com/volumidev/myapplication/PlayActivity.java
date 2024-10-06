package com.volumidev.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;



import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlayActivity extends AppCompatActivity {
    Intent intent;
    CountDownTimer temporizador;

    int aciertosPregunta=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_play);




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Para pasar a la siguiente actividad
        intent=new Intent(PlayActivity.this,ResultActivity.class);

        boolean finalJuego = false;
        if(finalJuego){
                temporizador=new CountDownTimer(3000,1000) {
                     @Override
                    public void onTick(long millisUntilFinished) {
                    //Se ejecuta cada 1000 milisegundos, no hay nada q ejecutar
                    }

                    @Override
                    public void onFinish() {
                        if(aciertosPregunta==10){
                            intent.putExtra("final", "ganaste");
                        }else{
                            intent.putExtra("final", "perdiste");
                        }

                    }
                };
            }














    }


}




