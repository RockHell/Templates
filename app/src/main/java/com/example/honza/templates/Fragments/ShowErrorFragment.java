package com.example.honza.templates.Fragments;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.honza.templates.R;

public class ShowErrorFragment extends Fragment {

    public ShowErrorFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_show_error, container, false);

        Button button_toast = (Button)rootView.findViewById(R.id.button_toast);
        button_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast=Toast.makeText(getContext(),"Hello world! I am Toast :)))", Toast.LENGTH_SHORT);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        Button button_snackbar_bottom = (Button)rootView.findViewById(R.id.button_snackbar_bottom);
        button_snackbar_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) rootView.findViewById(R.id.coordinatorLayout);
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Tohle je ukázka SnackBaru.", Snackbar.LENGTH_LONG)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });

                snackbar.setActionTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));

                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                ViewGroup group = (ViewGroup) snackbar.getView();
                group.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
                snackbar.show();
            }
        });


        Button button_snackbar_top = (Button)rootView.findViewById(R.id.button_snackbar_top);
        button_snackbar_top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) rootView.findViewById(R.id.coordinatorLayout);
                Snackbar snackbar = Snackbar
                        .make(coordinatorLayout, "Tohle je ukázka SnackBaru.", Snackbar.LENGTH_LONG)
                        .setAction("OK", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            }
                        });

                snackbar.setActionTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));

                View sbView = snackbar.getView();
                CoordinatorLayout.LayoutParams params =(CoordinatorLayout.LayoutParams)sbView.getLayoutParams();
                params.gravity = Gravity.TOP;
                sbView.setLayoutParams(params);
                TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(ContextCompat.getColor(getContext(), R.color.colorWhite));
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
                ViewGroup group = (ViewGroup) snackbar.getView();
                group.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
                snackbar.show();
            }
        });


        return rootView;
    }



}