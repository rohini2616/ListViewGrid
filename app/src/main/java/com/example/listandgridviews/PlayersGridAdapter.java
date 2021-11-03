package com.example.listandgridviews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PlayersGridAdapter extends BaseAdapter {

    Context context;
    String[] names;
    int[] images;


    public PlayersGridAdapter(@NonNull Context context, String[] names, int[] images) {
        this.context = context;
        this.names = names;
        this.images = images;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {


        view = LayoutInflater.from(context).inflate(R.layout.row_grid_players,null);

        ImageView imageView = view.findViewById(R.id.ivImages);
        TextView tvName = view.findViewById(R.id.tvNames);
        imageView.setImageResource(images[position]);
        tvName.setText(names[position]);//wait
        return view;
    }
}
