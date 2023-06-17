package com.ahyar.diramut;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class bantuan extends Fragment {

    TextView details1, details2, details3, details4, details5, details6, details7, details8;
    LinearLayout layout1, layout2, layout3, layout4, layout5, layout6, layout7, layout8, layout11, layout12;
    CardView card1, card2, card3, card4, card5, card6, card7, card8, card11, card12;
    FloatingActionButton hubungi;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_bantuan, container, false);

        hubungi = rootView.findViewById(R.id.hubungi);

        card1 = rootView.findViewById(R.id.card1);
        card2 = rootView.findViewById(R.id.card2);
        card3 = rootView.findViewById(R.id.card3);
        card4 = rootView.findViewById(R.id.card4);
        card5 = rootView.findViewById(R.id.card5);
        card6 = rootView.findViewById(R.id.card6);
        card7 = rootView.findViewById(R.id.card7);
        card8 = rootView.findViewById(R.id.card8);
        card11 = rootView.findViewById(R.id.card11);
        card12 = rootView.findViewById(R.id.card12);

        details1 = rootView.findViewById(R.id.details1);
        details2 = rootView.findViewById(R.id.details2);
        details3 = rootView.findViewById(R.id.details3);
        details4 = rootView.findViewById(R.id.details4);
        details5 = rootView.findViewById(R.id.details5);
        details6 = rootView.findViewById(R.id.details6);
        details7 = rootView.findViewById(R.id.details7);
        details8 = rootView.findViewById(R.id.details8);

        layout1 = rootView.findViewById(R.id.layout1);
        layout2 = rootView.findViewById(R.id.layout2);
        layout3 = rootView.findViewById(R.id.layout3);
        layout4 = rootView.findViewById(R.id.layout4);
        layout5 = rootView.findViewById(R.id.layout5);
        layout6 = rootView.findViewById(R.id.layout6);
        layout7 = rootView.findViewById(R.id.layout7);
        layout8 = rootView.findViewById(R.id.layout8);
        layout11 = rootView.findViewById(R.id.layout11);
        layout12 = rootView.findViewById(R.id.layout12);

        hubungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://wa.me/6287790077798/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
        }});

        card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://www.google.co.id/maps/search/klinik+hewan/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        card12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://goo.gl/maps/nd6qpijCUj2wP4XD7?coh=178573&entry=tt";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        card1.setOnClickListener(view -> {
            if (details1.getVisibility() == View.VISIBLE){
                TransitionManager.beginDelayedTransition(layout1, new AutoTransition());
                details1.setVisibility(View.GONE);
            } else {
                TransitionManager.beginDelayedTransition(layout1, new AutoTransition());
                details1.setVisibility(View.VISIBLE);
            }
        });

        card2.setOnClickListener(view -> {
            if (details2.getVisibility() == View.VISIBLE){
                TransitionManager.beginDelayedTransition(layout2, new AutoTransition());
                details2.setVisibility(View.GONE);
            } else {
                TransitionManager.beginDelayedTransition(layout2, new AutoTransition());
                details2.setVisibility(View.VISIBLE);
            }
        });

        card3.setOnClickListener(view -> {
            if (details3.getVisibility() == View.VISIBLE){
                TransitionManager.beginDelayedTransition(layout3, new AutoTransition());
                details3.setVisibility(View.GONE);
            } else {
                TransitionManager.beginDelayedTransition(layout3, new AutoTransition());
                details3.setVisibility(View.VISIBLE);
            }
        });

        card4.setOnClickListener(view -> {
            if (details4.getVisibility() == View.VISIBLE){
                TransitionManager.beginDelayedTransition(layout4, new AutoTransition());
                details4.setVisibility(View.GONE);
            } else {
                TransitionManager.beginDelayedTransition(layout4, new AutoTransition());
                details4.setVisibility(View.VISIBLE);
            }
        });

        card5.setOnClickListener(view -> {
            if (details5.getVisibility() == View.VISIBLE){
                TransitionManager.beginDelayedTransition(layout5, new AutoTransition());
                details5.setVisibility(View.GONE);
            } else {
                TransitionManager.beginDelayedTransition(layout5, new AutoTransition());
                details5.setVisibility(View.VISIBLE);
            }
        });

        card6.setOnClickListener(view -> {
            if (details6.getVisibility() == View.VISIBLE){
                TransitionManager.beginDelayedTransition(layout6, new AutoTransition());
                details6.setVisibility(View.GONE);
            } else {
                TransitionManager.beginDelayedTransition(layout6, new AutoTransition());
                details6.setVisibility(View.VISIBLE);
            }
        });

        card7.setOnClickListener(view -> {
            if (details7.getVisibility() == View.VISIBLE){
                TransitionManager.beginDelayedTransition(layout7, new AutoTransition());
                details7.setVisibility(View.GONE);
            } else {
                TransitionManager.beginDelayedTransition(layout7, new AutoTransition());
                details7.setVisibility(View.VISIBLE);
            }
        });

        card8.setOnClickListener(view -> {
            if (details8.getVisibility() == View.VISIBLE){
                TransitionManager.beginDelayedTransition(layout8, new AutoTransition());
                details8.setVisibility(View.GONE);
            } else {
                TransitionManager.beginDelayedTransition(layout8, new AutoTransition());
                details8.setVisibility(View.VISIBLE);
            }
        });

        return rootView;
    }

}