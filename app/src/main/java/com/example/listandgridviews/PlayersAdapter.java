package com.example.listandgridviews;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PlayersAdapter extends ArrayAdapter<String> {

//wait

    Context context;
    String[] names;
    int[] images;
    String listOrGrid;


    public PlayersAdapter(@NonNull Context context, String[] names, int[] images,String listOrGrid) {
        super(context,R.layout.row_players,R.id.tvNames,names);
        this.context = context;
        this.names = names;
        this.images = images;
        this.listOrGrid = listOrGrid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {

        if (listOrGrid.equals("list")){
            view = LayoutInflater.from(context).inflate(R.layout.row_players,null);
        }else {
            view = LayoutInflater.from(context).inflate(R.layout.row_grid_players,null);
        }
        ImageView imageView = view.findViewById(R.id.ivImages);
        TextView tvName = view.findViewById(R.id.tvNames);
        imageView.setImageResource(images[position]);
        tvName.setText(names[position]);//wait
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setTitle("Info!");
                builder.setMessage(names[position]);

                builder.setPositiveButton("Get Info", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent=new Intent(context,DetailActivity.class);
                        intent.putExtra("Name",names[position]);
                        intent.putExtra("Image",images[position]);
                        context.startActivity(intent);
                    }
                });
                builder.show();
            }
        });
        return view;
    }
}
