package com.example.project1_it21878;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public DBHelper dbHelper;
    private String userId;
    private float longitude;
    private float latitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = DBHelper.getInstance(MainActivity.this);

        findViewById(R.id.subButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userId = ((EditText)findViewById(R.id.userIdEditText)).getText().toString();
                longitude = Float.valueOf((((EditText)findViewById(R.id.longEditText)).getText().toString()));
                latitude = Float.valueOf((((EditText)findViewById(R.id.latEditText)).getText().toString()));
                if(userId == null || Float.valueOf(longitude) == null || Float.valueOf(latitude) ==  null){
                    Toast.makeText(MainActivity.this, "Missing something", Toast.LENGTH_SHORT).show();
                }else {
                    Record record = new Record(userId,longitude,latitude);
                    long id = dbHelper.insertRecord(record);
                    Toast.makeText(MainActivity.this, id+"", Toast.LENGTH_SHORT).show();
                    if(id == -1){
                        Toast.makeText(MainActivity.this, "Username taken", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        findViewById(R.id.nextButton1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userId == null || Float.valueOf(longitude) == null || Float.valueOf(latitude) ==  null){
                    Toast.makeText(MainActivity.this, "Missing something", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}