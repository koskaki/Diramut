package com.ahyar.diramut.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ahyar.diramut.R;
import com.ahyar.diramut.model.Data;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> lists;


    public Adapter(Activity activity, List<Data> list){
        this.activity = activity;
        this.lists = list;
    }


    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null && inflater != null){
            view = inflater.inflate(R.layout.list_penyakit, null);
        }
        if (view !=null) {
            TextView penyakit = view.findViewById(R.id.nmpenyakit);
            TextView deskripsi = view.findViewById(R.id.dkpenyakit);
            Data data = lists.get(i);
            penyakit.setText(data.getNamapenyakit());
            deskripsi.setText(data.getDeskripsi());
        }
        return view;
    }
}
