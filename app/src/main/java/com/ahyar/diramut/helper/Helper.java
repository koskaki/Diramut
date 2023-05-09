package com.ahyar.diramut.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class Helper extends SQLiteOpenHelper {

    private  static final int DATABASE_VERSION = 1;
    static final  String DATABASE_NAME = "dbpenyakit";

    public Helper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TABLE = "CREATE TABLE dftarpenyakit (id INTEGER PRIMARY KEY autoincrement, namapenyakit TEXT NOT NULL, deskripsi TEXT NOT NULL, gejala TEXT NOT NULL, solusi TEXT NOT NULL)";
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS dftarpenyakit");
        onCreate(sqLiteDatabase);

    }

    public ArrayList<HashMap<String, String>> getAll(){
        ArrayList<HashMap<String, String >> list = new ArrayList<>();
        String QUERY = "SELECT * FROM dftarpenyakit";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(QUERY, null);
        if (cursor.moveToFirst()){
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("id", cursor.getString(0));
                map.put("namapenyakit", cursor.getString(1));
                map.put("deskripsi", cursor.getString(2));
                map.put("gejala", cursor.getString(3));
                map.put("solusi", cursor.getString(4));
                list.add(map);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }
    public void insert(String namapenyakit,String deskripsi, String gejala, String solusi ){
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "INSERT INTO dftarpenyakit (namapenyakit,deskripsi,gejala,solusi) VALUES ('"+namapenyakit+"','"+deskripsi+"','"+gejala+"','"+solusi+"')";
        database.execSQL(QUERY);
    }
    public void update(int id,String namapenyakit,String deskripsi, String gejala, String solusi ) {
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "UPDATE dftarpenyakit SET namapenyakit = '"+namapenyakit+"', deskripsi = '"+deskripsi+"', gejala = '"+gejala+"', solusi = '"+solusi+"' WHERE id = '"+id;
        database.execSQL(QUERY);
    }
    public void delete(int id ) {
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "DELETE FROM dftarpenyakit WHERE id = '"+id;
        database.execSQL(QUERY);
    }
}
