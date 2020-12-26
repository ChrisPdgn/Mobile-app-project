package com.example.project1_it21878;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class UsersCursorAdapter extends CursorAdapter {

    public UsersCursorAdapter(Context context, Cursor c) {
        super(context, c);
    }

    //methodos gia na kanoume inflate ena kainourgio view (na to fortwsoume sti mnimi kai na to xrisimopoihsei to activity)
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.textview_users, parent, false);
    }

    //methodos gia na sundesoume ta dedomena sto view
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView td = (TextView)view.findViewById(R.id.timestampTV);
        String timestamp = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.FIELD_5));
        td.setText(timestamp);
    }
}
