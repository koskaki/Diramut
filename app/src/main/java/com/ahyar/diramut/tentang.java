package com.ahyar.diramut;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class tentang extends Fragment {

    LinearLayout profil1, pro1, profil2, pro2, profil3, pro3, profil4, pro4, profil5, pro5, profil6, pro6, profil8, pro8;
    TextView bio1, bio2, bio4, bio3, bio5, bio6, bio8;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tentang, container, false);

        profil1 = rootView.findViewById(R.id.profil1);
        profil2 = rootView.findViewById(R.id.profil2);
        profil3 = rootView.findViewById(R.id.profil3);
        profil5 = rootView.findViewById(R.id.profil5);
        profil6 = rootView.findViewById(R.id.profil6);
        profil4 = rootView.findViewById(R.id.profil4);
        profil8 = rootView.findViewById(R.id.profil8);

        pro1 = rootView.findViewById(R.id.prof1);
        pro2 = rootView.findViewById(R.id.prof2);
        pro3 = rootView.findViewById(R.id.prof3);
        pro4 = rootView.findViewById(R.id.prof4);
        pro5 = rootView.findViewById(R.id.prof5);
        pro6 = rootView.findViewById(R.id.prof6);
        pro8 = rootView.findViewById(R.id.prof8);

        bio1 = rootView.findViewById(R.id.bio1);
        bio2 = rootView.findViewById(R.id.bio2);
        bio3 = rootView.findViewById(R.id.bio3);
        bio4 = rootView.findViewById(R.id.bio4);
        bio5 = rootView.findViewById(R.id.bio5);
        bio6 = rootView.findViewById(R.id.bio6);
        bio8 = rootView.findViewById(R.id.bio8);

        profil1.setOnClickListener(view -> {
            if (bio1.getVisibility() == View.VISIBLE){
                TransitionManager.beginDelayedTransition(pro1, new AutoTransition());
                bio1.setVisibility(View.GONE);
            } else {
                TransitionManager.beginDelayedTransition(pro1, new AutoTransition());
                bio1.setVisibility(View.VISIBLE);
            }
        });

        profil2.setOnClickListener(view -> {
            if (bio2.getVisibility() == View.VISIBLE){
                TransitionManager.beginDelayedTransition(pro2, new AutoTransition());
                bio2.setVisibility(View.GONE);
            } else {
                TransitionManager.beginDelayedTransition(pro2, new AutoTransition());
                bio2.setVisibility(View.VISIBLE);
            }
        });

        profil3.setOnClickListener(view -> {
            if (bio3.getVisibility() == View.VISIBLE){
                TransitionManager.beginDelayedTransition(pro3, new AutoTransition());
                bio3.setVisibility(View.GONE);
            } else {
                TransitionManager.beginDelayedTransition(pro3, new AutoTransition());
                bio3.setVisibility(View.VISIBLE);
            }
        });

        profil4.setOnClickListener(view -> {
            if (bio4.getVisibility() == View.VISIBLE){
                TransitionManager.beginDelayedTransition(pro4, new AutoTransition());
                bio4.setVisibility(View.GONE);
            } else {
                TransitionManager.beginDelayedTransition(pro4, new AutoTransition());
                bio4.setVisibility(View.VISIBLE);
            }
        });

        profil5.setOnClickListener(view -> {
            if (bio5.getVisibility() == View.VISIBLE){
                TransitionManager.beginDelayedTransition(pro5, new AutoTransition());
                bio5.setVisibility(View.GONE);
            } else {
                TransitionManager.beginDelayedTransition(pro5, new AutoTransition());
                bio5.setVisibility(View.VISIBLE);
            }
        });


        profil6.setOnClickListener(view -> {
            if (bio6.getVisibility() == View.VISIBLE){
                TransitionManager.beginDelayedTransition(pro6, new AutoTransition());
                bio6.setVisibility(View.GONE);
            } else {
                TransitionManager.beginDelayedTransition(pro6, new AutoTransition());
                bio6.setVisibility(View.VISIBLE);
            }
        });

        profil8.setOnClickListener(view -> {
            if (bio8.getVisibility() == View.VISIBLE){
                TransitionManager.beginDelayedTransition(pro8, new AutoTransition());
                bio8.setVisibility(View.GONE);
            } else {
                TransitionManager.beginDelayedTransition(pro8, new AutoTransition());
                bio8.setVisibility(View.VISIBLE);
            }
        });




        return rootView;
    }
}