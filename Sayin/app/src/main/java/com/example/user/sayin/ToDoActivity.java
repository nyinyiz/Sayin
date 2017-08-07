package com.example.user.sayin;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ToDoActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    public static int image[] = {R.drawable.expense_money};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        ContentAdapter adapter = new ContentAdapter(ToDoActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        // Set padding for Tiles
//        int tilePadding = getResources().getDimensionPixelSize(R.dimen.tile_padding);
//        recyclerView.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //Do some stuff
            recyclerView.setLayoutManager(new GridLayoutManager(ToDoActivity.this, 3));
        }
        else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            //Do some stuff
            recyclerView.setLayoutManager(new GridLayoutManager(ToDoActivity.this, 2));
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView name;
        public CardView card_view;
        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.todo_single, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.tile_picture);
            name = (TextView) itemView.findViewById(R.id.tile_title);
            card_view= (CardView) itemView.findViewById(R.id.card_view);


        }
    }

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder>
    {
        Context context;
        public TextView name;

        public ContentAdapter(Context context) {
            this.context= context;

        }


        @Override
        public ToDoActivity.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
        }

        @Override
        public void onBindViewHolder(ToDoActivity.ViewHolder holder, final int position) {
            holder.name.setText("Your expnese money");
            Picasso.with(context)
                    .load(R.drawable.expense_money)
                    .into(holder.picture);

            holder.card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    
                }
            });
        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }
}
