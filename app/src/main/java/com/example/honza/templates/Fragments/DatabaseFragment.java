package com.example.honza.templates.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.honza.templates.Database.Comment;
import com.example.honza.templates.Database.CommentsDataSource;
import com.example.honza.templates.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DatabaseFragment extends Fragment implements View.OnClickListener {

    private CommentsDataSource datasource;
    private ListView listView;
    private List<Map<String, String>> data;
    public DatabaseFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        datasource = new CommentsDataSource(getActivity());
        datasource.open();

        loadData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View rootView = inflater.inflate(R.layout.fragment_database, container, false);


        SimpleAdapter adapter = new SimpleAdapter(getActivity(), data,
                android.R.layout.simple_list_item_2,
                new String[] {"comment", "date" },
                new int[] {android.R.id.text1, android.R.id.text2 });
        listView = (ListView)rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        Button add = (Button)rootView.findViewById(R.id.add);
        Button delete = (Button)rootView.findViewById(R.id.delete);

        add.setOnClickListener(this);
        delete.setOnClickListener(this);
        return rootView;
    }

    private void loadData() {
        data = new ArrayList<Map<String, String>>();

        List<Comment> values = datasource.getAllComments();
        for(int i=0;i<values.size();i++) {
            Map<String, String> map = new HashMap<String, String>(2);
            map.put("comment", values.get(i).getComment());
            map.put("date", values.get(i).getDate());
            data.add(map);
        }
    }

    public void onClick(View view) {

        SimpleAdapter adapter = (SimpleAdapter) listView.getAdapter();
        Comment comment = null;

        switch (view.getId()) {
            case R.id.add:
                String[] comments = new String[] { "Jan", "Petra", "Kamil", "Adéla", "Miroslav", "Jakub", "Jarmila", "Lída", "Erich", "Katka", "Jiřina", "Soňa", "Romana", "Lucie" };
                int nextInt = new Random().nextInt(comments.length);

                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                String date = sdf.format(new Date());

                comment = datasource.createComment(comments[nextInt],date);

                Map<String, String> map = new HashMap<String, String>(2);
                map.put("comment", comments[nextInt]);
                map.put("date", date);
                data.add(map);
                break;

            case R.id.delete:
                if (data.size() > 0) {
                    datasource.deleteComment();
                    data.remove(0);
                }
                break;
        }
        adapter.notifyDataSetChanged();

    }


    @Override
    public void onResume() {
        datasource.open();
        super.onResume();
    }

    @Override
    public void onPause() {
        datasource.close();
        super.onPause();
    }

}
