package com.example.honza.templates.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.honza.templates.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FilesFragment extends Fragment {

    public FilesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_files, container, false);

        // Počáteční čtení
        String result = ReadInternalStorage(getActivity(), "TemplatesJP_file.txt");
        TextView InternalTextView = (TextView)rootView.findViewById(R.id.InternalTextView);
        InternalTextView.setText(result);


        Button buttonWriteInternalStorage = (Button)rootView.findViewById(R.id.buttonWriteInternalStorage);
        buttonWriteInternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText multilineEditText = (EditText)rootView.findViewById(R.id.multilineEditText);
                String result = ReadInternalStorage(getActivity(), "TemplatesJP_file.txt");
                boolean what = WriteInternalStorage(getActivity(), "TemplatesJP_file.txt", result + multilineEditText.getText().toString());
                if(!what)
                {
                    Toast toast=Toast.makeText(getContext(),"Něco se porouchalo", Toast.LENGTH_SHORT);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        Button buttonClearInternalStorage = (Button)rootView.findViewById(R.id.buttonClearInternalStorage);
        buttonClearInternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean what = WriteInternalStorage(getActivity(), "TemplatesJP_file.txt","");
                if(!what)
                {
                    Toast toast=Toast.makeText(getContext(),"Něco se porouchalo", Toast.LENGTH_SHORT);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        Button buttonReadInternalStorage = (Button)rootView.findViewById(R.id.buttonReadInternalStorage);
        buttonReadInternalStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = ReadInternalStorage(getActivity(), "TemplatesJP_file.txt");
                TextView InternalTextView = (TextView)rootView.findViewById(R.id.InternalTextView);
                InternalTextView.setText(result);
            }
        });




        return rootView;
    }

    public boolean WriteInternalStorage (Context context, String filename, String text)
    {
        FileOutputStream outputStream;

        try {
            outputStream = context.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(text.getBytes());
            outputStream.close();

            Toast toast=Toast.makeText(getContext(),"Provedeno...", Toast.LENGTH_SHORT);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.show();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String ReadInternalStorage (Context context, String filename)
    {
        try {
            FileInputStream fis = context.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            return "";
        } catch (UnsupportedEncodingException e) {
            return "";
        } catch (IOException e) {
            return "";
        }
    }


}
