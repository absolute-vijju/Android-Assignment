package com.example.a35datapassingusingfragment;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends android.app.Fragment {

    Button btn;
    EditText email,passwd;
    LinearLayout ll;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_first, container, false);
        btn=v.findViewById(R.id.login);
        email=v.findViewById(R.id.email);
        passwd=v.findViewById(R.id.passwd);
        ll=v.findViewById(R.id.ll);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment s=new SecondFragment();
                FragmentTransaction ft= getFragmentManager().beginTransaction();
                ft.replace(R.id.ll,s);
                ft.commit();
            }
        });

        return v;
    }

}
