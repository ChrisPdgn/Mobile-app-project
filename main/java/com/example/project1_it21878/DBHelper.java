package com.example.project1_it21878;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static DBHelper dbInstance = null;

    public static String DB_NAME = "users";
    public static String TABLE_NAME = "Users";
    public static String FIELD_1 = "_id";
    public static String FIELD_2 = "userid";
    public static String FIELD_3 = "longitude";
    public static String FIELD_4 = "latitude";
    public static String FIELD_5 = "dt";
    private String SQL_QUERY = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ( "+FIELD_1+" INTEGER PRIMARY KEY AUTOINCREMENT, "+FIELD_2+" TEXT, "+FIELD_3+" REAL, "+FIELD_4+" REAL, "+FIELD_5+" TEXT)";

    public static DBHelper getInstance(Context context) {
        if (dbInstance == null) {
            dbInstance = new DBHelper(context.getApplicationContext());
        }
        return dbInstance;
    }

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
        long id = this.getWritableDatabase().insert(TABLE_NAME, null,values);
        return id;
    }

    public Cursor selectRecordByUserId(String id){
        return this.getReadableDatabase().query(TABLE_NAME,null,FIELD_2+"=?",new String[]{id},null,null,null);
    }

    public Cursor selectRecordByIdAndDt(String id, String dt){
        return this.getReadableDatabase().query(TABLE_NAME,null,FIELD_2+"=? AND "+FIELD_5+"=?",new String[]{id,dt},null,null,null);
    }
}
