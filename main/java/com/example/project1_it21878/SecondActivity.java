package com.example.project1_it21878;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

    public DBHelper dbHelper;
    private UsersCursorAdapter cursorAdapter;
    private String userId;
    private String selectedDt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        dbHelper = DBHelper.getInstance(SecondActivity.this);
        ListView lvItems = (ListView) findViewById(R.id.listView);

        findViewById(R.id.searchUserId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userId = ((EditText) findViewById(R.id.userIdEditText2)).getText().toString();
                Cursor cursor = dbHelper.selectRecordByUserId(userId);
                cursorAdapter = new UsersCursorAdapter(SecondActivity.this, cursor);
                lvItems.setAdapter(cursorAdapter);
            }
        });

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedDt = ((TextView) view.findViewById(R.id.timestampTV)).getText().toString();
                //Toast.makeText(SecondActivity.this, selectedDt, Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.nextButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userId == null) {
                    Toast.makeText(SecondActivity.this, "Insert at least a user id to continue", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                    Cursor cursor;
                    if (selectedDt == null){
                        cursor = dbHelper.selectRecordByUserId(userId);
                    }else {
                        cursor = dbHelper.selectRecordByIdAndDt(userId, selectedDt);
                    }

                    String cursorData = "";
                    if (cursor.moveToFirst()) {
                        do {
                            cursorData = cursorData + cursor.getString(0) + " " +
                                    cursor.getString(1) + " " +
                                    cursor.getString(2) + " " +
                                    cursor.getString(3) + " " +
                                    cursor.getString(4);
                        } while (cursor.moveToNext());
                    }
                    intent.putExtra("cursorData", cursorData);
                    startActivity(intent);
                }
            }
        });

    }

}