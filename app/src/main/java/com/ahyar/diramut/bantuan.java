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

    TextView details1, details2, details3, details4;
    LinearLayout layout1, layout2, layout3, layout4;
    CardView card1, card2, card3, card4;
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

        details1 = rootView.findViewById(R.id.details1);
        details2 = rootView.findViewById(R.id.details2);
        details3 = rootView.findViewById(R.id.details3);
        details4 = rootView.findViewById(R.id.details4);

        layout1 = rootView.findViewById(R.id.layout1);
        layout2 = rootView.findViewById(R.id.layout2);
        layout3 = rootView.findViewById(R.id.layout3);
        layout4 = rootView.findViewById(R.id.layout4);

        hubungi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://wa.me/628983197209/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
        }});

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

        return rootView;
    }

}