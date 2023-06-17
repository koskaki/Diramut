package com.ahyar.diramut;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "contacts.db";
    public static final String TABLE_NAME = "CONTACTS";
    public static final int DB_VERSION = 3;

    public static final String COLUMN_1 = "ID";
    public static final String COLUMN_2 = "NMPENYAKIT";
    public static final String COLUMN_3 = "DESKRIPSI";
    public static final String COLUMN_4 = "GEJALA";
    public static final String COLUMN_5 = "SOLUSI";
    public static final String COLUMN_6 = "IMAGE";
    public static final String QUERY_CREATE = "CREATE TABLE "+TABLE_NAME+" ("
            +COLUMN_1+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_2+" TEXT, "
            +COLUMN_3+" TEXT, "
            +COLUMN_4+" TEXT, "
            +COLUMN_5+" TEXT, "
            +COLUMN_6+" TEXT)";




    public DataHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUERY_CREATE);
        }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }


    public void insertData(ContentValues values){
        getWritableDatabase().insert(TABLE_NAME, null, values);
    }


}