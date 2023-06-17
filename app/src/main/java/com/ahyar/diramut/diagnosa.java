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
            checkg16, checkg17, checkg18, checkg19, checkg20,
            checkg21, checkg22, checkg23, checkg24, checkg25,
            checkg26, checkg27;

    Button btnDiagnosa;
    TextView tvResult, tvsolusi;

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
        checkg20 = view.findViewById(R.id.g20);
        checkg21 = view.findViewById(R.id.g21);
        checkg22 = view.findViewById(R.id.g22);
        checkg23 = view.findViewById(R.id.g23);
        checkg24 = view.findViewById(R.id.g24);
        checkg25 = view.findViewById(R.id.g25);
        checkg26 = view.findViewById(R.id.g26);
        checkg27 = view.findViewById(R.id.g27);

        btnDiagnosa = view.findViewById(R.id.btn_diagnosa);
        tvResult = view.findViewById(R.id.result);
        tvsolusi = view.findViewById(R.id.solusi);

        tvsolusi.setText("");
        tvResult.setText(""); //kosongkan text view
        btnDiagnosa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String NamaPenyakit = "";
                String solusi = "";
                String P1 = "\nSolusi Cacingan, Kalau masih aktif bisa dikasih obat cacing, tetapi apabila lemas dianjurkan dibawa keklinik\n";
                String P2 = "\nSolusi Jamuran, Mandi anti jamur, dan minum obat anti jamur (Dibawah pengawasan dokter)\n";
                String P3 = "\nSolusi Kutuan, Dikasih obat tetes kutu dan  flea control diklinik hewan\n";
                String P4 = "\nSolusi Gangguan Liver, Dianjurkan langsung dibawah ke klinik, untuk pemerikasaan lebih lanjut dan treatmen lebih lanjut\n";
                String P5 = "\nSolusi Virus rhinotracheitis, Apabila Flu dan masih nafsu makan bisa rawat jalan\n";
                String P6 = "\nSolusi Virus calisi, Dianjurkan langsung dibawah ke klinik, untuk pemerikasaan lebih lanjut dan treatmen lebih lanjut\n";
                String P7 = "\nSolusi Virus panleukopenia, Dianjurkan langsung dibawah ke klinik, untuk pemerikasaan lebih lanjut dan treatmen lebih lanjut\n";

                if (checkg02.isChecked()){
                    solusi += "\nUntuk pertolongan pertama apabila tidak nafsu makan harus disuap 2 jam sekali dengan pakan basah\n";
                }

                if (checkg01.isChecked() || checkg02.isChecked() || checkg03.isChecked() || checkg04.isChecked() ||
                        checkg05.isChecked() || checkg06.isChecked() || checkg07.isChecked() || checkg08.isChecked()
                        || checkg09.isChecked()) {
                    NamaPenyakit += " Cacingan.";
                    solusi += P1;
                }
                if (checkg11.isChecked() || checkg12.isChecked()) {
                    NamaPenyakit += " Jamuran.";
                    solusi += P2;
                }
                if (checkg11.isChecked() || checkg13.isChecked() || checkg14.isChecked() || checkg15.isChecked()) {
                    NamaPenyakit += " Kutuan.";
                    solusi += P3;
                }
                if (checkg01.isChecked() || checkg02.isChecked() || checkg05.isChecked()|| checkg11.isChecked()
                        || checkg16.isChecked()|| checkg17.isChecked()|| checkg18.isChecked()|| checkg19.isChecked()) {
                    NamaPenyakit += " Gangguan Liver.";
                    solusi += P4;
                }
                if (checkg02.isChecked() || checkg03.isChecked() || checkg10.isChecked() || checkg19.isChecked()
                        || checkg20.isChecked() || checkg21.isChecked() || checkg22.isChecked() || checkg27.isChecked()) {
                    NamaPenyakit += " Virus rhinotracheitis.";
                    solusi += P5;
                }
                if (checkg02.isChecked() || checkg03.isChecked() || checkg10.isChecked() || checkg21.isChecked()
                        || checkg23.isChecked() || checkg24.isChecked() || checkg25.isChecked() || checkg26.isChecked()
                        || checkg27.isChecked()) {
                    NamaPenyakit += " Virus calisi.";
                    solusi += P6;
                }
                if (checkg01.isChecked() || checkg02.isChecked() || checkg03.isChecked()
                        || checkg19.isChecked()) {
                    NamaPenyakit += " Virus panleukopenia.";
                    solusi += P7;
                }

                // tampilkan penyakit
                tvResult.setText("Suspek dari gejala yang dialami adalah " + NamaPenyakit +"\n");
                tvsolusi.setText("" + solusi);

            }

        });


        return view;
    }



}