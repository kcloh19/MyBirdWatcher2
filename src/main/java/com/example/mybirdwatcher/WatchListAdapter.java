package com.example.mybirdwatcher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;


public class WatchListAdapter extends ArrayAdapter  {

    private ArrayList dataSet;
    Context mContext;
    CheckBox checkBox;



    private static class ViewHolder {
        TextView birdWatchName, birdWatchLocation;
        ImageView birdWatchImage;
        CheckBox checkBox;
    }

    public WatchListAdapter(ArrayList data, Context context) {
        super(context, R.layout.watch_list, data);
        this.dataSet = data;
        this.mContext = context;

    }
    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public WatchListClass getItem(int position) {
        return (WatchListClass) dataSet.get(position);
    }


    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.watch_list, parent, false);
            viewHolder.birdWatchImage = (ImageView) convertView.findViewById(R.id.birdWatchImage);
            viewHolder.birdWatchName = (TextView) convertView.findViewById(R.id.birdWatchName);
            viewHolder.birdWatchLocation = (TextView) convertView.findViewById(R.id.birdWatchLocation);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.checkbox);


            result = convertView;
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        WatchListClass item = getItem(position);

        viewHolder.birdWatchImage.setImageResource(item.birdWatchImage);
        viewHolder.birdWatchName.setText(item.birdWatchName);
        viewHolder.birdWatchLocation.setText(item.birdWatchLocation);
        viewHolder.checkBox.setChecked(item.checked);


        return result;


    }

}