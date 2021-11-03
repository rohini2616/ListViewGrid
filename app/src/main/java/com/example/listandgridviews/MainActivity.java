package com.example.listandgridviews;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
 private Button buttonList;gopg
 private Button buttonGrid;
 private ListView listView;
 private GridView gridView;
 String[] names={"Dhoni","Raina","Rohit","Ashwin","Saāchin"};
 int[] images={R.drawable.dhoni,R.drawable.raina,
         R.drawable.rohit,R.drawable.ashwin,R.drawable.sachin};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonList=findViewById(R.id.btnList);
        buttonGrid=findViewById(R.id.btnGrid);
        listView=findViewById(R.id.lvCollection);
        gridView=findViewById(R.id.gvCollection);


        buttonGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonGrid.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                buttonList.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                PlayersAdapter adapter = new PlayersAdapter(MainActivity.this,names,images,"grid");
                gridView.setAdapter(adapter);
                listView.setVisibility(View.GONE);
                gridView.setVisibility(View.VISIBLE);
            }
        });
        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonList.setBackgroundColor(getResources().getColor(R.color.colorGreen));
                buttonGrid.setBackgroundColor(getResources().getColor(R.color.colorWhite));
                PlayersAdapter adapter = new PlayersAdapter(MainActivity.this,names,images,"list");
                listView.setAdapter(adapter);
                listView.setVisibility(View.VISIBLE);
                gridView.setVisibility(View.GONE);
            }
        });
    }
}