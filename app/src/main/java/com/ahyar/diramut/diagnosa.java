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
            checkg26, checkg27, checkg28, checkg29, checkg30,
            checkg31, checkg32, checkg33, checkg34, checkg35,
            checkg36, checkg37, checkg38, checkg39, checkg40,
            checkg41, checkg42, checkg43, checkg44, checkg45,
            checkg46, checkg47, checkg48;

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
        checkg28 = view.findViewById(R.id.g28);
        checkg29 = view.findViewById(R.id.g29);
        checkg30 = view.findViewById(R.id.g30);
        checkg31 = view.findViewById(R.id.g31);
        checkg32 = view.findViewById(R.id.g32);
        checkg33 = view.findViewById(R.id.g33);
        checkg34 = view.findViewById(R.id.g34);
        checkg35 = view.findViewById(R.id.g35);
        checkg36 = view.findViewById(R.id.g36);
        checkg37 = view.findViewById(R.id.g37);
        checkg38 = view.findViewById(R.id.g38);
        checkg39 = view.findViewById(R.id.g39);
        checkg40 = view.findViewById(R.id.g40);
        checkg41 = view.findViewById(R.id.g41);
        checkg42 = view.findViewById(R.id.g42);
        checkg43 = view.findViewById(R.id.g43);
        checkg44 = view.findViewById(R.id.g44);
        checkg45 = view.findViewById(R.id.g45);
        checkg46 = view.findViewById(R.id.g46);
        checkg47 = view.findViewById(R.id.g47);
        checkg48 = view.findViewById(R.id.g48);

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
                String P8 = "\nSolusi Chlamydia, Dianjurkan langsung dibawah ke klinik, untuk pemerikasaan lebih lanjut dan treatmen lebih lanjut\n";
                String P9 = "\nSolusi Infeksi bakteri pernafasan, Dianjurkan langsung dibawah ke klinik, untuk pemerikasaan lebih lanjut dan treatmen lebih lanjut\n";
                String P10 = "\nSolusi FIP, Dianjurkan langsung dibawah ke klinik, untuk pemerikasaan lebih lanjut dan treatmen lebih lanjut\n";
                String P11 = "\nSolusi Protozoa pencernaan, Dianjurkan langsung dibawah ke klinik, untuk pemerikasaan lebih lanjut dan treatmen lebih lanjut\n";
                String P12 = "\nSolusi FLUTD, Dianjurkan langsung dibawah ke klinik, untuk pemerikasaan lebih lanjut dan treatmen lebih lanjut\n";
                String P13 = "\nSolusi Keracunan, Dianjurkan langsung dibawah ke klinik, untuk pemerikasaan lebih lanjut dan treatmen lebih lanjut\n";


                if (checkg01.isChecked()){
                    solusi += "\nUntuk pertolongan pertama apabila tidak nafsu makan harus disuap 2 jam sekali dengan pakan basah\n";
                }

                if (checkg01.isChecked() || checkg02.isChecked() || checkg12.isChecked() || checkg18.isChecked()
                        || checkg23.isChecked() || checkg39.isChecked() || checkg42.isChecked() || checkg46.isChecked()
                        || checkg47.isChecked()) {
                    NamaPenyakit += " Cacingan.";
                    solusi += P1;
                }

                if (checkg14.isChecked() || checkg16.isChecked() || checkg19.isChecked()) {
                    NamaPenyakit += " Jamuran.";
                    solusi += P2;
                }

                if (checkg12.isChecked() || checkg13.isChecked() || checkg15.isChecked() || checkg17.isChecked()) {
                    NamaPenyakit += " Kutuan.";
                    solusi += P3;
                }

                if (checkg01.isChecked() || checkg02.isChecked() || checkg23.isChecked()|| checkg40.isChecked()
                        || checkg41.isChecked()|| checkg43.isChecked()) {
                    NamaPenyakit += " Gangguan Liver.";
                    solusi += P4;
                }

                if (checkg01.isChecked() || checkg04.isChecked() || checkg21.isChecked() || checkg23.isChecked()
                        || checkg31.isChecked() || checkg33.isChecked()) {
                    NamaPenyakit += " Virus rhinotracheitis.";
                    solusi += P5;
                }

                if (checkg01.isChecked() || checkg04.isChecked() || checkg07.isChecked() || checkg08.isChecked()
                        || checkg09.isChecked() || checkg23.isChecked() || checkg25.isChecked() || checkg33.isChecked()) {
                    NamaPenyakit += " Virus calisi.";
                    solusi += P6;
                }

                if (checkg01.isChecked() || checkg03.isChecked() || checkg11.isChecked() || checkg23.isChecked()
                        || checkg39.isChecked() || checkg48.isChecked()) {
                    NamaPenyakit += " Virus panleukopenia.";
                    solusi += P7;
                }

                if (checkg01.isChecked() || checkg04.isChecked() || checkg06.isChecked() || checkg23.isChecked()
                        || checkg33.isChecked()) {
                    NamaPenyakit += " Chlamydia.";
                    solusi += P8;
                }

                if (checkg01.isChecked() || checkg04.isChecked() || checkg32.isChecked() || checkg31.isChecked()
                        || checkg34.isChecked()) {
                    NamaPenyakit += " Infeksi bakteri pernafasan.";
                    solusi += P9;
                }

                if (checkg01.isChecked() || checkg24.isChecked() || checkg25.isChecked() || checkg26.isChecked()
                        || checkg32.isChecked() || checkg34.isChecked() || checkg44.isChecked()) {
                    NamaPenyakit += " FIP.";
                    solusi += P10;
                }

                if (checkg05.isChecked() || checkg20.isChecked() || checkg22.isChecked() || checkg39.isChecked()
                        || checkg44.isChecked() || checkg45.isChecked()) {
                    NamaPenyakit += " Protozoa pencernaan.";
                    solusi += P11;
                }

                if (checkg01.isChecked() || checkg24.isChecked() || checkg27.isChecked() || checkg34.isChecked()
                        || checkg35.isChecked() || checkg36.isChecked() || checkg37.isChecked() || checkg43.isChecked()) {
                    NamaPenyakit += " FLUTD.";
                    solusi += P12;
                }

                if (checkg10.isChecked() || checkg28.isChecked() || checkg29.isChecked() || checkg30.isChecked()
                        || checkg34.isChecked() || checkg37.isChecked() || checkg38.isChecked()) {
                    NamaPenyakit += " Keracunan.";
                    solusi += P13;
                }

                // tampilkan penyakit
                tvResult.setText("Suspek dari gejala yang dialami adalah " + NamaPenyakit +"\n");
                tvsolusi.setText("" + solusi);

            }

        });


        return view;
    }



}