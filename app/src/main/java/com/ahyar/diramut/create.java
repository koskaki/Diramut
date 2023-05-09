package com.ahyar.diramut;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.ahyar.diramut.helper.Helper;

public class create extends Fragment {

    private EditText editpenyakit, editdeskripsi, editgejala, editsolusi;
    private Button btnsimpan;
    private  Helper dbpenyakit = new Helper(getActivity());  //= new Helper(requireContext());
    private String id, penyakit, deskripsi, gejala, solusi;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_create, container, false);

        editpenyakit = rootView.findViewById(R.id.namapenyakit);
        editdeskripsi = rootView.findViewById(R.id.deskripsi);
        editgejala = rootView.findViewById(R.id.gejala);
        editsolusi = rootView.findViewById(R.id.solusi);
        btnsimpan = rootView.findViewById(R.id.btnsimpan);

        id = getActivity().getIntent().getStringExtra("id");
        penyakit = getActivity().getIntent().getStringExtra("penyakit");
        deskripsi = getActivity().getIntent().getStringExtra("deskripsi");
        gejala = getActivity().getIntent().getStringExtra("gejala");
        solusi = getActivity().getIntent().getStringExtra("solusi");

        if (id == null || id.equals("")){
        }else {
            editpenyakit.setText(penyakit);
            editdeskripsi.setText(deskripsi);
            editgejala.setText(gejala);
            editsolusi.setText(gejala);
        }
         btnsimpan.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 try {
                     if (id == null || id.equals("")){
                        save();
                     } else {
                        edit();
                     }
                 } catch (Exception e){
                     Log.e("Saving", e.getMessage());
                 }
             }
         });

        return rootView;
    }
    private  void save(){
        if (String.valueOf(editpenyakit.getText()).equals("") || String.valueOf(editdeskripsi.getText()).equals("") || String.valueOf(editgejala.getText()).equals("")|| String.valueOf(editsolusi.getText()).equals("")){
            Toast.makeText(getContext().getApplicationContext(), "Silakan isi semua data", Toast.LENGTH_SHORT).show();
        }else {
            dbpenyakit.insert(editpenyakit.getText().toString(), editdeskripsi.getText().toString(), editgejala.getText().toString(),editsolusi.getText().toString());
            getActivity().finish();
        }
    }
    private  void edit(){
        if (String.valueOf(editpenyakit.getText()).equals("") || String.valueOf(editdeskripsi.getText()).equals("") || String.valueOf(editgejala.getText()).equals("")|| String.valueOf(editsolusi.getText()).equals("")){
            Toast.makeText(getContext().getApplicationContext(), "Silakan isi semua data", Toast.LENGTH_SHORT).show();
        }else {
            dbpenyakit.update(Integer.parseInt(id), editpenyakit.getText().toString(), editdeskripsi.getText().toString(), editgejala.getText().toString(),editsolusi.getText().toString());
            getActivity().finish();
        }
    }
}