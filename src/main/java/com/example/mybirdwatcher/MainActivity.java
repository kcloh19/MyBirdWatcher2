package com.example.mybirdwatcher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        button = findViewById(R.id.addbird_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddBird();
            }
        });

        button = findViewById(R.id.mybirds_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyBirds();
            }
        });

        button = findViewById(R.id.watchlist_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWatchList();
            }
        });

    }

    public void openWatchList() {
        Intent intent = new Intent(this, WatchList.class);
        startActivity(intent);
    }

    public void openAddBird() {
        Intent intent = new Intent(this, AddBird.class);
        startActivity(intent);
    }

    public void openMyBirds() {
        Intent intent = new Intent(this, MyBirds.class);
        startActivity(intent);
    }


}