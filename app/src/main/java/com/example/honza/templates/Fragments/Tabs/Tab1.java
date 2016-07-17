package com.example.honza.templates.Fragments.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.honza.templates.R;

public class Tab1 extends Fragment {

    public Tab1() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_tab1, container, false);


        LinearLayout llp1 = (LinearLayout)rootView.findViewById(R.id.llp1);
        llp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        LinearLayout llp2 = (LinearLayout)rootView.findViewById(R.id.llp2);
        llp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        LinearLayout llp3 = (LinearLayout)rootView.findViewById(R.id.llp3);
        llp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        LinearLayout llp4 = (LinearLayout)rootView.findViewById(R.id.llp4);
        llp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        LinearLayout llp5 = (LinearLayout)rootView.findViewById(R.id.llp5);
        llp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        LinearLayout llp6 = (LinearLayout)rootView.findViewById(R.id.llp6);
        llp6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });


        return rootView;
    }



}
