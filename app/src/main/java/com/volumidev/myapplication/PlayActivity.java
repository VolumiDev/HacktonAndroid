package com.volumidev.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener{
    Button[] btn = new Button[4];
    Button btn_submit;
    TextView tv_question;
    int btnColor = Color.parseColor("#031f70");
    int correctOption = Color.parseColor("#36db23");
    int incorrectOption = Color.parseColor("#ff0000");
    int chooseColor = Color.parseColor("#cc8852");
    int progress, difficulty;
    QuestionDB dataBase;
    Handler handler = new Handler();


    String response, correct_answer;
    Boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_play);
        difficulty = getIntent().getIntExtra("difficulty", 0);


        dataBase = new QuestionDB(difficulty);

        flag = false;

        progress = 0;
        tv_question = findViewById(R.id.tv_question);
        btn[0] = findViewById(R.id.btn_a);
        btn[1] = findViewById(R.id.btn_b);
        btn[2] = findViewById(R.id.btn_c);
        btn[3] = findViewById(R.id.btn_d);
        btn_submit = findViewById(R.id.btn_submit);

        btn[0].setOnClickListener(this);
        btn[1].setOnClickListener(this);
        btn[2].setOnClickListener(this);
        btn[3].setOnClickListener(this);
        btn_submit.setOnClickListener(this);


        submitStarter(this, btn_submit);
        buttonSettings(btn);

        //seteamos  gestionamos la primera vez que preguntamosy almacenamos la respuesta correcta
        correct_answer = resetActivity(btn, dataBase, tv_question, btn[0], btn[1], btn[2], btn[3]);

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
                response = btn[0].getText().toString();
                responseSelector(this, btn, v.getId());
                submitActivate(this, btn_submit);
                break;
            case R.id.btn_b:
                response = btn[1].getText().toString();
                responseSelector(this, btn, v.getId());
                submitActivate(this, btn_submit);
                break;
                case R.id.btn_c:
                response = btn[2].getText().toString();
                responseSelector(this, btn, v.getId());
                submitActivate(this, btn_submit);
                break;
            case R.id.btn_d:
                response = btn[3].getText().toString();
                responseSelector(this, btn, v.getId());
                submitActivate(this, btn_submit);
                break;
            case R.id.btn_submit:

                if (response.equalsIgnoreCase(correct_answer)){
                    progress++;
                    flag = true;
                    responseColor(btn, correct_answer,response, correctOption, incorrectOption, flag);

                    if(progress == 10){
                        Intent intent = new Intent(this, ResultActivity.class);
                        intent.putExtra("progress", progress);
                        startActivity(intent);
                    }else if(progress < 10 && flag == true) {
                        handler.postDelayed(new Runnable(){
                            @Override
                            public void run() {
                                //restore button colors
                                buttonSettings(btn);
                                //answer reset
                                correct_answer = resetActivity(btn, dataBase, tv_question, btn[0], btn[1], btn[2], btn[3]);
                            }
                            },3000);
                    }
                }else{
                    flag = false;
                    Intent intent = new Intent(this, ResultActivity.class);
                    responseColor(btn, correct_answer,response, correctOption, incorrectOption, flag);
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            intent.putExtra("progress", progress);
                            startActivity(intent);
                        }
                    },3000);
                }
        }
    }


    public void buttonSettings(Button[] btns){
        for (int i = 0 ; i < btns.length; i++){
            btns[i].setBackgroundColor(btnColor);
        }
    }

    //seteamos y rellenamos la info de las preguntas
    public static String resetActivity(Button[] btns, QuestionDB dataBase, TextView tv_question, Button btn_a, Button btn_b, Button btn_c, Button btn_d){
        //random questions
        Question question = randomizeQuestions(dataBase);
        //set tv with question
        tv_question.setText(question.getTitle());
        //set buttons with answers
        randomAnswers(btns, question);
        return question.getCorrect_answer();
    }


    public static Question randomizeQuestions(QuestionDB dataBase){
        Random rnd = new Random();
        int index;
        do{
            index= rnd.nextInt(dataBase.getQuestions_table().length);

        }while(dataBase.getQuestions_table()[index].isIs_asked());  //si esta en true se repetira el random

        dataBase.getQuestions_table()[index].setIs_asked(true);
        return dataBase.getQuestions_table()[index];
    }

    public static void randomAnswers(Button[] btns, Question question){
        Random rnd = new Random();
        for (int i = 0 ; i < btns.length; i++){
            int index = rnd.nextInt(question.getPossible_answers().size());
            btns[i].setText(question.getPossible_answers().get(index));
            question.getPossible_answers().remove(index);
        }
    }

    public static void responseColor(Button[] btns, String correct_answer,String response, int correctOption,int incorrectOption, boolean flag){
        if(flag){
            for (int i = 0 ; i < btns.length; i++){
                if (btns[i].getText().toString().equalsIgnoreCase(correct_answer)){
                    btns[i].setBackgroundColor(correctOption);
                }
            }
        }else{
            for (int i = 0 ; i < btns.length; i++){
                if (btns[i].getText().toString().equalsIgnoreCase(correct_answer)){
                    btns[i].setBackgroundColor(correctOption);
                }else if(btns[i].getText().toString().equalsIgnoreCase(response)){
                    btns[i].setBackgroundColor(incorrectOption);
                }
            }
        }
    }

    public static void submitActivate(AppCompatActivity v, Button btn_submit){
        btn_submit.setEnabled(true);
        btn_submit.setTextColor(v.getResources().getColor(R.color.white));
    }

    public static void responseSelector(AppCompatActivity v, Button[] btns, int Id){
        for (int i = 0 ; i < btns.length; i++){
            if(btns[i].getId() == Id){
                btns[i].setBackgroundColor(v.getResources().getColor(R.color.choose));
            }else{
                btns[i].setBackgroundColor(v.getResources().getColor(R.color.navy));
            }
        }
    }

    public static void submitStarter(AppCompatActivity v , Button btn_submit){
        btn_submit.setBackgroundColor(v.getResources().getColor(R.color.navy));
        btn_submit.setEnabled(false);
        btn_submit.setTextColor(v.getResources().getColor(R.color.grey));
    }
}