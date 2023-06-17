package com.ahyar.diramut;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class dftpenyakit extends AppCompatActivity implements ContactClickListner {

    //ListView listView;
    RecyclerView recyclerView;
    ArrayList<Contact> contacts = new ArrayList<>();
    //ContactAdapter adapter;
    ContactAdapter adapter;
    //ContactClickListner listner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dftpenyakit);
        getSupportActionBar().hide();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.button2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dftpenyakit.this,tambahpenyakit.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        //contacts = getData();
        super.onResume();
        contacts = getData();



        recyclerView = findViewById(R.id.recyclerView);

        adapter = new ContactAdapter(this,contacts,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        adapter.notifyDataSetChanged();

    }


    public ArrayList<Contact> getData(){
        contacts.clear();
        DataHelper helper = new DataHelper(this,DataHelper.DB_NAME,null,DataHelper.DB_VERSION);
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList<Contact> contacts = new ArrayList<>();

        String query = "SELECT * FROM "+DataHelper.TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                Contact contact = new Contact();
                contact.setId( Integer.parseInt(cursor.getString(0)) );
                contact.setNmpenyakit( cursor.getString(1) );
                contact.setDeskripsi( cursor.getString(2) );
                contact.setGejala( cursor.getString(3) );
                contact.setSolusi( cursor.getString(4) );
                contact.setImage( cursor.getString(5) );

                contacts.add(contact);

            }while (cursor.moveToNext());
        }
        return contacts;
    }

    @Override
    public void onContactClick(Contact contact) {
        Intent intent = new Intent(dftpenyakit.this,lihatpenyakit.class);
        intent.putExtra("contact",contact.getId());
        startActivity(intent);
        Toast.makeText(dftpenyakit.this,"item clicked",Toast.LENGTH_SHORT).show();
    }
}
