package com.example.honza.templates.Fragments.Tabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.honza.templates.R;

public class Tab3 extends Fragment {

    public Tab3() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_tab3, container, false);

        LinearLayout lll1 = (LinearLayout)rootView.findViewById(R.id.lll1);
        lll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        LinearLayout lll2 = (LinearLayout)rootView.findViewById(R.id.lll2);
        lll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        LinearLayout lll3 = (LinearLayout)rootView.findViewById(R.id.lll3);
        lll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        LinearLayout lll4 = (LinearLayout)rootView.findViewById(R.id.lll4);
        lll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        LinearLayout lll5 = (LinearLayout)rootView.findViewById(R.id.lll5);
        lll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        LinearLayout lll6 = (LinearLayout)rootView.findViewById(R.id.lll6);
        lll6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        LinearLayout lll7 = (LinearLayout)rootView.findViewById(R.id.lll7);
        lll7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        return rootView;
    }



}
