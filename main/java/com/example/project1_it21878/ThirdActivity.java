package com.example.project1_it21878;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    //public DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        String cursorData = intent.getStringExtra("cursorData");
        TextView textView = findViewById(R.id.textView);
        textView.setText(cursorData);
    }


}