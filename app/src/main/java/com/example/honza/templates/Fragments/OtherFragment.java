package com.example.honza.templates.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.honza.templates.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class OtherFragment extends Fragment {

    public OtherFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_other, container, false);

        GraphView graph = (GraphView) rootView.findViewById(R.id.graph);
        graph.setTitleColor(getResources().getColor(R.color.colorPrimary));
        GraphView graph2 = (GraphView) rootView.findViewById(R.id.graph2);
        graph2.setTitleColor(getResources().getColor(R.color.colorPrimary));

        return rootView;
    }



}
