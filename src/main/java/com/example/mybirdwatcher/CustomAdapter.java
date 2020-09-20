package com.example.mybirdwatcher;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList bird_id, bird_name, bird_location, bird_date;
    private byte [] bird_image;

    CustomAdapter(Activity activity, Context context, ArrayList bird_id, ArrayList bird_name, ArrayList bird_location,
                  ArrayList bird_date) {
        this.activity = activity;
        this.context = context;
        this.bird_id = bird_id;
        this.bird_name = bird_name;
        this.bird_location = bird_location;
        this.bird_date = bird_date;
        this.bird_image = bird_image;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.bird_id_txt.setText(String.valueOf(bird_id.get(position)));
        holder.bird_name_txt.setText(String.valueOf(bird_name.get(position)));
        holder.bird_location_txt.setText(String.valueOf(bird_location.get(position)));
        holder.bird_date_txt.setText(String.valueOf(bird_date.get(position)));
        //holder.mybird_image.setImageBitmap(Bitmap.createBitmap((Bitmap) bird_image.get(position)));


        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(bird_id.get(position)));
                intent.putExtra("name", String.valueOf(bird_name.get(position)));
                intent.putExtra("location", String.valueOf(bird_location.get(position)));
                intent.putExtra("date", String.valueOf(bird_date.get(position)));
                //intent.putExtra("image", Bitmap.createBitmap((Bitmap) bird_image.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return bird_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView bird_id_txt, bird_name_txt, bird_location_txt, bird_date_txt;
        ImageView mybird_image;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bird_id_txt = itemView.findViewById(R.id.bird_id_txt);
            bird_name_txt = itemView.findViewById(R.id.bird_name_txt);
            bird_location_txt = itemView.findViewById(R.id.bird_location_txt);
            bird_date_txt = itemView.findViewById(R.id.bird_date_txt);
            //mybird_image = itemView.findViewById(R.id.mybird_imageView);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}