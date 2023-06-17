package com.ahyar.diramut;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class beranda extends Fragment {
   CardView Daftarbtn, Diagnosabtn, Bantuanbtn, Tentangbtn;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_beranda, container, false);
        Bantuanbtn = rootView.findViewById(R.id.bantuanbtn);
        Diagnosabtn = rootView.findViewById(R.id.diagnosabtn);
        Daftarbtn = rootView.findViewById(R.id.daftarbtn);
        Tentangbtn = rootView.findViewById(R.id.tentangbtn);


        Bantuanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction flberanda = getFragmentManager().beginTransaction();
                flberanda.replace(R.id.flfragment, new bantuan());
                flberanda.commit();
            }
        });

        Diagnosabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction flberanda = getFragmentManager().beginTransaction();
                flberanda.replace(R.id.flfragment, new diagnosa());
                flberanda.commit();
            }
        });

        Daftarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), dftpenyakit.class);
                startActivity(intent);
            }
        });

        Tentangbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction flberanda = getFragmentManager().beginTransaction();
                flberanda.replace(R.id.flfragment, new tentang());
                flberanda.commit();
            }
        });


        return rootView;

    }

}