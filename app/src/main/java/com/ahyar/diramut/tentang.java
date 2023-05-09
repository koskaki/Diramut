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

    LinearLayout profil1, pro1, profil2, pro2, profil3, pro3, profil4, pro4;
    TextView bio1, bio2, bio3, bio4;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tentang, container, false);

        profil1 = rootView.findViewById(R.id.profil1);
        profil2 = rootView.findViewById(R.id.profil2);
        profil3 = rootView.findViewById(R.id.profil3);
        profil4 = rootView.findViewById(R.id.profil4);

        pro1 = rootView.findViewById(R.id.prof1);
        pro2 = rootView.findViewById(R.id.prof2);
        pro3 = rootView.findViewById(R.id.prof3);
        pro4 = rootView.findViewById(R.id.prof4);

        bio1 = rootView.findViewById(R.id.bio1);
        bio2 = rootView.findViewById(R.id.bio2);
        bio3 = rootView.findViewById(R.id.bio3);
        bio4 = rootView.findViewById(R.id.bio4);

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



        return rootView;
    }
}