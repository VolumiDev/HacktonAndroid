package com.volumidev.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_a, btn_b, btn_c, btn_d, btn_submit;
    TextView tv_question;
    int btnColor = Color.parseColor("#031f70");
    int chooseColor = Color.parseColor("#cc8852");
    int progress;
    QuestionDB dataBase;


    String response;
    Boolean flag;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_play);
        dataBase = (QuestionDB) getIntent().getSerializableExtra("dataBase");

        flag = false;

        progress = 0;
        tv_question = findViewById(R.id.tv_question);
        btn_a = findViewById(R.id.btn_a);
        btn_b = findViewById(R.id.btn_b);
        btn_c = findViewById(R.id.btn_d);
        btn_d = findViewById(R.id.btn_c);
        btn_submit = findViewById(R.id.btn_submit);

        btn_a.setOnClickListener(this);
        btn_b.setOnClickListener(this);
        btn_c.setOnClickListener(this);
        btn_d.setOnClickListener(this);
        btn_submit.setOnClickListener(this);

        btn_submit.setBackgroundColor(btnColor);
        buttonSettings(btn_a, btn_b, btn_c, btn_d, btnColor);

        //seteamos  gestionamos la primera vez que preguntamos
        resetActivity(dataBase, tv_question);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_a:
                response = btn_a.getText().toString();
                btn_a.setBackgroundColor(chooseColor);
                break;
            case R.id.btn_b:
                response = btn_b.getText().toString();
                btn_a.setBackgroundColor(chooseColor);
                break;
            case R.id.btn_c:
                response = btn_c.getText().toString();
                btn_a.setBackgroundColor(chooseColor);
                break;
            case R.id.btn_d:
                response = btn_d.getText().toString();
                btn_a.setBackgroundColor(chooseColor);
                break;
            case R.id.btn_submit:
                //aqui es donde validamos si la respuesta que nos ha dado es ccorrecta o no
                //actualizamos el progreso y actualizamos el flag


                if(progress == 10){
                    Intent intent = new Intent(this, ResultActivity.class);
                    intent.putExtra("progress", progress);
                    startActivity(intent);
                }else if(progress < 10 && flag == true){
                    //restore button colors
                    buttonSettings(btn_a, btn_b, btn_c, btn_d, btnColor);

                }

                //{
                //    Intent intent = new Intent(this, ResultActivity.class);
                //    intent.putExtra("progress", progress);
                //    startActivity(intent);
                //}
        }
    }


    public static void buttonSettings(Button btn_a, Button btn_b, Button btn_c, Button btn_d, int btnColor){
        btn_a.setBackgroundColor(btnColor);
        btn_b.setBackgroundColor(btnColor);
        btn_c.setBackgroundColor(btnColor);
        btn_d.setBackgroundColor(btnColor);
    }

    //seteamos y rellenamos la info de las preguntas
    public static void resetActivity(QuestionDB dataBase, TextView tv_question){
        Question question = randomizeQuestions(dataBase);
        tv_question.setText(question.getTitle());
    }


    public static Question randomizeQuestions(QuestionDB dataBase){
        Random rnd = new Random();
        int index = rnd.nextInt(dataBase.getQuestions_table().length);
        return dataBase.getQuestions_table()[index];
    }

    public static void randomAnswers(Button btn_a, Button btn_b, Button btn_c, Button btn_d, Question question){

    }


}