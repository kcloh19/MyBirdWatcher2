package com.example.mybirdwatcher;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class WatchList extends AppCompatActivity {

    ArrayList dataModels;
    ListView listView;
    private WatchListAdapter adapter;
    CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watch_list);


        listView = (ListView) findViewById(R.id.listview2);


        dataModels = new ArrayList();

        dataModels.add(new WatchListClass(R.drawable.kookaburra, "Kookaburra", "Albury", false));
        dataModels.add(new WatchListClass(R.drawable.cockatoo, "Cockatoo", "Bathurst", true));
        dataModels.add(new WatchListClass(R.drawable.emu, "Emu", "Echuca", true));
        dataModels.add(new WatchListClass(R.drawable.magpie, "Magpie", "Sydney", true));

        adapter = new WatchListAdapter(dataModels, getApplicationContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                WatchListClass dataModel = (WatchListClass) dataModels.get(position);
                dataModel.checked = !dataModel.checked;
                adapter.notifyDataSetChanged();



            }
        });
    }


    }

