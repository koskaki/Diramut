package com.ahyar.diramut;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.ahyar.diramut.adapter.Adapter;
import com.ahyar.diramut.helper.Helper;
import com.ahyar.diramut.model.Data;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class penyakit extends Fragment {

    ListView listView;
    AlertDialog.Builder dialog;
    List<Data> lists = new ArrayList<>();
    Adapter adapter;
    Helper dbpenyakit = new Helper(getActivity()); //= new Helper(requireContext());
    FloatingActionButton tambah;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_penyakit, container, false);

        dbpenyakit = new Helper(getActivity().getApplicationContext());
        //dbpenyakit = new Helper(getApplicationContext());
        tambah = rootView.findViewById(R.id.tambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction flpenyakit = getFragmentManager().beginTransaction();
                flpenyakit.replace(R.id.flfragment, new create());
                flpenyakit.commit();
                // public void onClick(View view) {
                //Intent intent = new Intent(penyakit.this, create.class);
                //        startActivity(intent);
            }
        });

        listView = rootView.findViewById(R.id.listview);
        adapter = new Adapter(getActivity(), lists);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener((adapterView, view, i, I) -> {
            final String id = lists.get(i).getId();
            final String nmpenyakit = lists.get(i).getNamapenyakit();
            final String dkpenyakit = lists.get(i).getDeskripsi();
            final String gejala = lists.get(i).getGejala();
            final String solusi = lists.get(i).getSolusi();
            final CharSequence[] dialogItem = {"Edit", "Hapus"};
            dialog = new AlertDialog.Builder(getContext());
            dialog.setItems(dialogItem, (dialog, which) -> {
                switch (i) {
                    case 0:
                        //For FRAGMENT-->getActivity()
                        //For ACTIVITY ---> Activity.this
                        Intent intent = new Intent(getActivity(), create.class);
                        intent.putExtra("id", id);
                        intent.putExtra("penyakit", nmpenyakit);
                        intent.putExtra("deskripsi", dkpenyakit);
                        intent.putExtra("gejala", gejala);
                        intent.putExtra("solusi", solusi);
                        startActivity(intent);
                        break;
                    case 1:
                        dbpenyakit.delete(Integer.parseInt(id));
                        lists.clear();
                        getData();
                        break;
                }
            }).show();
            return false;
        });
        getData();
        return rootView;
    }
    private void getData(){
        ArrayList<HashMap<String, String>> rows = dbpenyakit.getAll();
        for (int i = 0; i<rows.size(); i++){
            String id = rows.get(i).get("id");
            String nmpenyakit = rows.get(i).get("nmpenyakit");
            String dkpenyakit = rows.get(i).get("dkpenyakit");
            String gejala = rows.get(i).get("gejala");
            String solusi = rows.get(i).get("solusi");

            Data data = new Data();
            data.setId(id);
            data.setNamapenyakit(nmpenyakit);
            data.setDeskripsi(dkpenyakit);
            data.setGejala(gejala);
            data.setSolusi(solusi);
            lists.add(data);
        }
        adapter.notifyDataSetChanged();
    }
    @Override
    public void  onResume(){
        super.onResume();
        lists.clear();
        getData();
    }
}