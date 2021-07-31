package com.example.a43_gridview_ratingbar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends android.app.Fragment {


    GridView gdview;
    int img[]={R.mipmap.dr,R.mipmap.em};
    ArrayList<GetterSetter> al=new ArrayList<>();

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_first, container, false);;

        gdview=v.findViewById(R.id.gridview);

        for (int i=0;i<img.length;i++)
        {
            GetterSetter gs=new GetterSetter(img[i]);
            al.add(gs);
        }

        MyAdapter my=new MyAdapter(getActivity(), al);
        gdview.setAdapter(my);

        return v;
    }

}

class GetterSetter
{
    int image;

    public GetterSetter(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}