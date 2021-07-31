package com.example.a43_gridview_ratingbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<GetterSetter> al;

    public MyAdapter(Context context, ArrayList<GetterSetter> al) {
        this.context = context;
        this.al = al;
    }

    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public Object getItem(int position) {
        return al.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater li= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=li.inflate(R.layout.rowlayout,null,false);

        ImageView im;

        im=v.findViewById(R.id.imview);

        GetterSetter gs=al.get(position);
        im.setImageResource(gs.getImage());

        return v;
    }
}
