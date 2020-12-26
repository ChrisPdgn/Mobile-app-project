package com.example.project1_it21878;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class SecondActivity extends AppCompatActivity {

    public DBHelper dbHelper;
    private UsersCursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        dbHelper = DBHelper.getInstance(SecondActivity.this);

        findViewById(R.id.searchUserId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView lvItems = (ListView)findViewById(R.id.listView);
                String userid = ((EditText)findViewById(R.id.userIdEditText2)).getText().toString();
                //Toast.makeText(SecondActivity.this, cursor.getString(2), Toast.LENGTH_SHORT).show();
                Cursor cursor = dbHelper.selectRecordByUserId(userid);
                cursorAdapter = new UsersCursorAdapter(SecondActivity.this, cursor);
                lvItems.setAdapter(cursorAdapter);
            }
        });


    }
    
}