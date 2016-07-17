package com.example.honza.templates.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.honza.templates.R;
import com.wefika.flowlayout.FlowLayout;

public class LayoutFragment extends Fragment {

    public LayoutFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        if(menu!=null)
        {
            if(menu.findItem(R.id.action_layout)!=null)
                menu.findItem(R.id.action_layout).setVisible(true);
        }

        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_layout, container, false);

        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        int Width = displayMetrics.widthPixels/2;
        int Height = (Width/16)*9;

        FlowLayout ll = (FlowLayout)rootView.findViewById(R.id.layout_root);
        int childcount = ll.getChildCount();
        for (int i=0; i < childcount; i++){
            View view = ll.getChildAt(i);
            view.setLayoutParams(new FlowLayout.LayoutParams(Width, Height));

        }
        return rootView;
    }



}
