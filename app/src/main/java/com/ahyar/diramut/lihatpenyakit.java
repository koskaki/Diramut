package com.ahyar.diramut;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class lihatpenyakit extends AppCompatActivity {
    TextView textv2,textv3,textv4,textv5;
    ImageView imageView;
    Button edit, delete, cancel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihatpenyakit);

        textv2 = findViewById(R.id.textView2);
        textv3 = findViewById(R.id.textView3);
        textv4 = findViewById(R.id.textView4);
        textv5 = findViewById(R.id.textView5);
        imageView = findViewById(R.id.imageView1);
        edit = findViewById(R.id.button1);
        delete = findViewById(R.id.button2);
        cancel = findViewById(R.id.button3);

        Contact contact = getData();
        textv2.setText(contact.getNmpenyakit());
        textv3.setText(contact.getDeskripsi());
        textv4.setText(contact.getGejala());
        textv5.setText(contact.getSolusi());

        if(contact.getImage() == null){
            imageView.setImageResource(R.drawable.vet);
        }
        else {
            byte [] arr = Base64.decode(contact.getImage(),Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(arr,0,arr.length);
            imageView.setImageBitmap(bitmap);
        }



        getSupportActionBar().hide();


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateData();
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteData();
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    public Contact getData() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("contact", 0);
        DataHelper helper = new DataHelper(this, DataHelper.DB_NAME, null, DataHelper.DB_VERSION);
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList<Contact> contacts = new ArrayList<>();

        String query = "SELECT * FROM " + DataHelper.TABLE_NAME + " WHERE ID=" + id;
        Cursor cursor = db.rawQuery(query, null);
        Contact contact = null;
        if (cursor.moveToFirst()) {
            do {
                contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setNmpenyakit(cursor.getString(1));
                contact.setDeskripsi(cursor.getString(2));
                contact.setGejala(cursor.getString(3));
                contact.setSolusi(cursor.getString(4));
                contact.setImage(cursor.getString(5));

                contacts.add(contact);

            } while (cursor.moveToNext());
        }

        return contact;
    }


    public void updateData(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("contact",0);
        Intent intent1 = new Intent(this,editpenyakit.class);
        intent1.putExtra("updateContact",id);
        startActivity(intent1);
    }

    public void deleteData(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("contact",0);
        DataHelper helper = new DataHelper(this,DataHelper.DB_NAME,null,DataHelper.DB_VERSION);
        SQLiteDatabase db = helper.getWritableDatabase();
        int result = db.delete(DataHelper.TABLE_NAME,"ID="+id,null);
        Log.v("TAG","Terhapus "+result+" "+id);
        Toast.makeText(this,"Terhapus "+id,Toast.LENGTH_SHORT).show();
        db.close();
    }
}