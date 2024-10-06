package com.volumidev.myapplication;

import android.os.Bundle;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlayActivity extends AppCompatActivity {

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

        /**
        //TIMER
        //import android.os.CountDownTimer;
        TextView cuentaAtras;
        cuentaAtras=findViewById();
        boolean iniciarTimer=false;
        CountDownTimer temporizador;
        if(iniciarTimer=true){               //Contara hacia atras 3000 milisegundos= 3 seg
                                            //Con intercalo de 1000 milisegundos= 1 seg
            temporizador= new CountDownTimer(3000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    //Se ejecuta cada 1000 milisegundos

                    if(millisUntilFinished=3000){
                        cuentaAtras.setText("3");
                    }
                    if(millisUntilFinished=2000){
                        cuentaAtras.setText("2");
                    }
                    if(millisUntilFinished=1000){
                        cuentaAtras.setText("1");
                    }
                }

                @Override
                public void onFinish() {
                    //Cuando llegue a cero se ejecuta
                }
            };

        }
         **/
    }


}




