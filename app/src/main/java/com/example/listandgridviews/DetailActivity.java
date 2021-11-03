package com.example.listandgridviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    String names;
    int image;
    TextView tvPlayerName;
    ImageView ivPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        names = getIntent().getStringExtra("Name");
        image = getIntent().getIntExtra("Image",0);

        tvPlayerName = findViewById(R.id.tvPlayerName);
        ivPlayer = findViewById(R.id.ivPlayer);

        tvPlayerName.setText(names);
        ivPlayer.setImageResource(image);

    }
}