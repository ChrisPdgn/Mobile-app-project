package com.example.project1_it21878;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static String DB_NAME = "UsersDB";
    public static String TABLE_NAME = "Users";
    public static String FIELD_1 = "id";
    public static String FIELD_2 = "userid";
    public static String FIELD_3 = "longitude";
    public static String FIELD_4 = "latitude";
    public static String FIELD_5 = "dt";
    private String SQL_QUERY = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+FIELD_1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+FIELD_2+" TEXT, "+FIELD_3+" REAL, "+FIELD_4+" REAL, "+FIELD_5+" TEXT)";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertRecord(Record record){
        ContentValues values = new ContentValues();
        values.put(FIELD_2,record.getUserId());
        values.put(FIELD_3,record.getLongitude());
        values.put(FIELD_4, record.getLatitude());
        values.put(FIELD_5, record.getDt());
        long id = this.getWritableDatabase().insert(TABLE_NAME, "id",values);
        return id;
    }
}
