package com.ahyar.diramut;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class penyakit extends Fragment implements ContactClickListner {
    //ListView listView;
    RecyclerView recyclerView;
    ArrayList<Contact> contacts = new ArrayList<>();
    FloatingActionButton fab;
    ContactAdapter adapter;
    //ContactClickListner listner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_penyakit, container, false);
        fab = rootView.findViewById(R.id.button2);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), tambahpenyakit.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        //contacts = getData();
        super.onResume();
        contacts = getData();


        recyclerView = getView().findViewById(R.id.recyclerView);

        adapter = new ContactAdapter(getContext(), contacts, (ContactClickListner) getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        adapter.notifyDataSetChanged();

    }


    public ArrayList<Contact> getData() {
        contacts.clear();
        DataHelper helper = new DataHelper(getActivity(), DataHelper.DB_NAME, null, DataHelper.DB_VERSION);
        SQLiteDatabase db = helper.getReadableDatabase();
        ArrayList<Contact> contacts = new ArrayList<>();

        String query = "SELECT * FROM " + DataHelper.TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setNmpenyakit(cursor.getString(1));
                contact.setDeskripsi(cursor.getString(2));
                contact.setGejala(cursor.getString(3));
                contact.setSolusi(cursor.getString(4));
                contact.setImage(cursor.getString(5));

                contacts.add(contact);

            } while (cursor.moveToNext());
        }
        return contacts;
    }

    @Override
    public void onContactClick(Contact contact) {
        Intent intent = new Intent(getActivity().getApplicationContext(), lihatpenyakit.class);
        intent.putExtra("contact", contact.getId());
        startActivity(intent);
        Toast.makeText(getActivity().getApplicationContext(), "item clicked", Toast.LENGTH_SHORT).show();
    }


}
