package com.example.project1_it21878;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = DBHelper.getInstance(MainActivity.this);

        findViewById(R.id.subButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = ((EditText)findViewById(R.id.userIdEditText)).getText().toString();
                float longitude = Float.valueOf((((EditText)findViewById(R.id.longEditText)).getText().toString()));
                float latitude = Float.valueOf((((EditText)findViewById(R.id.latEditText)).getText().toString()));
                Record record = new Record(userId,longitude,latitude);
                long id = dbHelper.insertRecord(record);
                Toast.makeText(MainActivity.this, id+"", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                //finish();
            }
        });

    }
}