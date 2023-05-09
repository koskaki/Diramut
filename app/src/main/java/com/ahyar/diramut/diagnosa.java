package com.ahyar.diramut;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.fragment.app.Fragment;



public class diagnosa extends Fragment {
    CheckBox checkg01, checkg02, checkg03, checkg04, checkg05,
            checkg06, checkg07, checkg08, checkg09, checkg10,
            checkg11, checkg12, checkg13, checkg14, checkg15,
            checkg16, checkg17, checkg18, checkg19;

    Button btnDiagnosa;
    TextView tvResult;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_diagnosa, container, false);


        checkg01 = view.findViewById(R.id.g01);
        checkg02 = view.findViewById(R.id.g02);
        checkg03 = view.findViewById(R.id.g03);
        checkg04 = view.findViewById(R.id.g04);
        checkg05 = view.findViewById(R.id.g05);
        checkg06 = view.findViewById(R.id.g06);
        checkg07 = view.findViewById(R.id.g07);
        checkg08 = view.findViewById(R.id.g08);
        checkg09 = view.findViewById(R.id.g09);
        checkg10 = view.findViewById(R.id.g10);
        checkg11 = view.findViewById(R.id.g11);
        checkg12 = view.findViewById(R.id.g12);
        checkg13 = view.findViewById(R.id.g13);
        checkg14 = view.findViewById(R.id.g14);
        checkg15 = view.findViewById(R.id.g15);
        checkg16 = view.findViewById(R.id.g16);
        checkg17 = view.findViewById(R.id.g17);
        checkg18 = view.findViewById(R.id.g18);
        checkg19 = view.findViewById(R.id.g19);

        btnDiagnosa = view.findViewById(R.id.btn_diagnosa);
        tvResult = view.findViewById(R.id.result);

        tvResult.setText(""); //kosongkan text view
        btnDiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String NamaPenyakit = "";


                if (checkg01.isChecked() && checkg02.isChecked() && checkg03.isChecked()
                        && checkg04.isChecked()) {
                    NamaPenyakit += "Scabies";
                }
                else if (checkg05.isChecked() && checkg06.isChecked() && checkg07.isChecked()
                        && checkg08.isChecked() && checkg17.isChecked() && checkg19.isChecked()) {
                    NamaPenyakit += "Otitis";
                }
                else if (checkg09.isChecked() && checkg10.isChecked() && checkg11.isChecked()
                        && checkg12.isChecked() && checkg17.isChecked() && checkg19.isChecked()) {
                    NamaPenyakit += "Cacingan";
                }
                else if (checkg01.isChecked() && checkg13.isChecked() && checkg14.isChecked()) {
                    NamaPenyakit += "Ringworm";
                }
                else if (checkg15.isChecked() && checkg16.isChecked() && checkg18.isChecked()
                        && checkg19.isChecked()) {
                    NamaPenyakit += "Rabies";
                }
                else {
                    NamaPenyakit += "Gejala dan penyakit tidak terdaftar\natau anda belum menceklis";
                }


                // tampilkan penyakit
                tvResult.setText("" + NamaPenyakit);

            }

        });


        return view;
    }



}