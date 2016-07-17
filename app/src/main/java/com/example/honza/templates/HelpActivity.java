package com.example.honza.templates;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        if (getSupportActionBar() != null) {
            ActionBar v = getSupportActionBar();
            v.setTitle(R.string.title_help);
            v.setDisplayHomeAsUpEnabled(true);
        }


        final ImageView help_arrow1 = (ImageView)findViewById(R.id.help_arrow1);
        final RelativeLayout help_header1 = (RelativeLayout)findViewById(R.id.help_header1);
        final LinearLayout help_content1 = (LinearLayout)findViewById(R.id.help_content1);

        final ImageView help_arrow2 = (ImageView)findViewById(R.id.help_arrow2);
        final RelativeLayout help_header2 = (RelativeLayout)findViewById(R.id.help_header2);
        final LinearLayout help_content2 = (LinearLayout)findViewById(R.id.help_content2);

        final ImageView help_arrow3 = (ImageView)findViewById(R.id.help_arrow3);
        final RelativeLayout help_header3 = (RelativeLayout)findViewById(R.id.help_header3);
        final LinearLayout help_content3 = (LinearLayout)findViewById(R.id.help_content3);

        final ImageView help_arrow4 = (ImageView)findViewById(R.id.help_arrow4);
        final RelativeLayout help_header4 = (RelativeLayout)findViewById(R.id.help_header4);
        final LinearLayout help_content4 = (LinearLayout)findViewById(R.id.help_content4);

        final ImageView help_arrow5 = (ImageView)findViewById(R.id.help_arrow5);
        final RelativeLayout help_header5 = (RelativeLayout)findViewById(R.id.help_header5);
        final LinearLayout help_content5 = (LinearLayout)findViewById(R.id.help_content5);

        help_header1.setOnClickListener(new showListener(help_content1, help_arrow1));
        help_header2.setOnClickListener(new showListener(help_content2, help_arrow2));
        help_header3.setOnClickListener(new showListener(help_content3, help_arrow3));
        help_header4.setOnClickListener(new showListener(help_content4, help_arrow4));
        help_header5.setOnClickListener(new showListener(help_content5, help_arrow5));


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    class showListener implements View.OnClickListener {

        ImageView imageView = null;
        LinearLayout linearLayout = null;

        showListener(LinearLayout layout, ImageView image)
        {
            imageView = image;
            linearLayout = layout;
        }

        @Override
        public void onClick(View v) {
            if(linearLayout.getVisibility()== View.GONE) {
                linearLayout.setVisibility(View.VISIBLE);
                imageView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_keyboard_arrow_down_grey_48dp_up));

            } else {
                linearLayout.setVisibility(View.GONE);
                imageView.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_keyboard_arrow_down_grey_48dp));

            }
        }
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);

                final LinearLayout help_content1 = (LinearLayout)findViewById(R.id.help_content1);
                final LinearLayout help_content2 = (LinearLayout)findViewById(R.id.help_content2);
                final LinearLayout help_content3 = (LinearLayout)findViewById(R.id.help_content3);
                final LinearLayout help_content4 = (LinearLayout)findViewById(R.id.help_content4);
                final LinearLayout help_content5 = (LinearLayout)findViewById(R.id.help_content5);

                if(help_content1!=null) {
                    if(help_content1.getVisibility()==View.GONE)
                        outState.putInt("Content1", 0);
                    if(help_content1.getVisibility()==View.VISIBLE)
                        outState.putInt("Content1", 1);
                }
                if(help_content2!=null) {
                    if(help_content2.getVisibility()==View.GONE)
                        outState.putInt("Content2", 0);
                    if(help_content2.getVisibility()==View.VISIBLE)
                        outState.putInt("Content2", 1);
                }
                if(help_content3!=null) {
                    if(help_content3.getVisibility()==View.GONE)
                        outState.putInt("Content3", 0);
                    if(help_content3.getVisibility()==View.VISIBLE)
                        outState.putInt("Content3", 1);
                }
                if(help_content4!=null) {
                    if(help_content4.getVisibility()==View.GONE)
                        outState.putInt("Content4", 0);
                    if(help_content4.getVisibility()==View.VISIBLE)
                        outState.putInt("Content4", 1);
                }
                if(help_content5!=null) {
                    if(help_content5.getVisibility()==View.GONE)
                        outState.putInt("Content5", 0);
                    if(help_content5.getVisibility()==View.VISIBLE)
                        outState.putInt("Content5", 1);
                }

    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        final LinearLayout help_content1 = (LinearLayout)findViewById(R.id.help_content1);
        final LinearLayout help_content2 = (LinearLayout)findViewById(R.id.help_content2);
        final LinearLayout help_content3 = (LinearLayout)findViewById(R.id.help_content3);
        final LinearLayout help_content4 = (LinearLayout)findViewById(R.id.help_content4);
        final LinearLayout help_content5 = (LinearLayout)findViewById(R.id.help_content5);

                if(help_content1!=null) {
                    if(savedInstanceState.getInt("Content1")==0)
                        help_content1.setVisibility(View.GONE);
                    if(savedInstanceState.getInt("Content1")==1)
                        help_content1.setVisibility(View.VISIBLE);
                }
                if(help_content2!=null) {
                    if(savedInstanceState.getInt("Content2")==0)
                        help_content2.setVisibility(View.GONE);
                    if(savedInstanceState.getInt("Content2")==1)
                        help_content2.setVisibility(View.VISIBLE);
                }
                if(help_content3!=null) {
                    if(savedInstanceState.getInt("Content3")==0)
                        help_content3.setVisibility(View.GONE);
                    if(savedInstanceState.getInt("Content3")==1)
                        help_content3.setVisibility(View.VISIBLE);
                }
                if(help_content4!=null) {
                    if(savedInstanceState.getInt("Content4")==0)
                        help_content4.setVisibility(View.GONE);
                    if(savedInstanceState.getInt("Content4")==1)
                        help_content4.setVisibility(View.VISIBLE);
                }
                if(help_content5!=null) {
                    if(savedInstanceState.getInt("Content5")==0)
                        help_content5.setVisibility(View.GONE);
                    if(savedInstanceState.getInt("Content5")==1)
                        help_content5.setVisibility(View.VISIBLE);
                }



    }
}
