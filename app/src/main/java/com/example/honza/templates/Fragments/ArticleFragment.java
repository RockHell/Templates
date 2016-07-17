package com.example.honza.templates.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.honza.templates.ArticleDetailActivity;
import com.example.honza.templates.R;

public class ArticleFragment extends Fragment {

    public ArticleFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_article, container, false);

        ImageView imageView1 = (ImageView)rootView.findViewById(R.id.mImageView);
        ImageView imageView2 = (ImageView)rootView.findViewById(R.id.mImageView2);
        ImageView imageView3 = (ImageView)rootView.findViewById(R.id.mImageView3);
        ImageView imageView4 = (ImageView)rootView.findViewById(R.id.mImageView4);
        ImageView imageView5 = (ImageView)rootView.findViewById(R.id.mImageView5);



        imageView1.setOnClickListener(new OpenListener(R.drawable.classic_picture_one));
        imageView2.setOnClickListener(new OpenListener(R.drawable.classic_picture_two));
        imageView3.setOnClickListener(new OpenListener(R.drawable.classic_picture_three));
        imageView4.setOnClickListener(new OpenListener(R.drawable.classic_picture_four));
        imageView5.setOnClickListener(new OpenListener(R.drawable.classic_picture_five));



        return rootView;
    }

    class OpenListener implements View.OnClickListener {

        private int id;
        OpenListener (int i)
        {
            id = i;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), ArticleDetailActivity.class);
            intent.putExtra("id_image", id);
            startActivity(intent);
        }
    }

}
