package com.example.honza.templates;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class AboutAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);

        if (getSupportActionBar() != null) {
            ActionBar v = getSupportActionBar();
            v.setTitle(R.string.title_about_app);
            v.setDisplayHomeAsUpEnabled(true);
        }


        Button buttonGooglePlay = (Button)findViewById(R.id.google_play_button);
        if (buttonGooglePlay != null) {
            buttonGooglePlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=cz.vsb.tuo.vsbtelefonniseznam"));
                    startActivity(intent);
                }
            });
        }

        LinearLayout ChangelogClickable = (LinearLayout)findViewById(R.id.ChangelogClickable);
        ChangelogClickable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangelogDialog dialog = ChangelogDialog.newInstance();
                dialog.show(getSupportFragmentManager(), "fragmentDialog");
            }
        });
    }


    public static class ChangelogDialog extends DialogFragment {
        Context mContext;

        public ChangelogDialog() {
            mContext = getActivity();
        }

        public static ChangelogDialog newInstance() {
            ChangelogDialog f = new ChangelogDialog();
            return f;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            ContextThemeWrapper ctw = new ContextThemeWrapper( getActivity(), R.style.Theme_AlertDialog);
            AlertDialog.Builder builder = new AlertDialog.Builder(ctw);
            LayoutInflater inflater = getActivity().getLayoutInflater();
            builder.setTitle(R.string.aboutapp_changelog)
                    .setView(inflater.inflate(R.layout.dialog_about_app, null))
                    .setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // prázdný pro zavření dialogu
                        }
                    });
            return builder.create();
        }

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
}
