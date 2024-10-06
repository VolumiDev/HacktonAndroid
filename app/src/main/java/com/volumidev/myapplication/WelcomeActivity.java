package com.volumidev.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener{
    Spinner difficulties;
    Button btn_start;
    ImageButton btn_back;
    int selectedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);


        difficulties = findViewById(R.id.spin_difficulty);
        btn_start = findViewById(R.id.btn_start);
        btn_back = findViewById(R.id.btn_back);

        btn_start.setOnClickListener(this);
        btn_back.setOnClickListener(this);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.difficulty, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficulties.setAdapter(adapter);

        difficulties.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedIndex = difficulties.getSelectedItemPosition();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_start:
                Log.i("Volumi", "Entramos en boton");
                QuestionDB quest_db = new QuestionDB(selectedIndex);
                Intent intent = new Intent(this, PlayActivity.class);
                intent.putExtra("difficulty", selectedIndex);
                startActivity(intent);
                break;
            case R.id.btn_back:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                break;
        }

    }
}