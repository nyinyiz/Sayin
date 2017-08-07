package com.example.user.sayin.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.sayin.R;
import com.example.user.sayin.database.Sayin_database;

import java.util.List;

/**
 * Created by User on 8/5/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Sayin_database dataBase;

    Context context;TextView image;

    TextView item_name,amount;

    int position;

    View view1;

    private List<List<String>> allIncome_expense;

    AlertDialog.Builder alertDialog;

    public RecyclerViewAdapter(Context applicationContext, List<List<String>> allIncome) {

        this.context=applicationContext;

        this.allIncome_expense=allIncome;



    }



    @Override

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        view1  = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_view, viewGroup, false);

        return new ViewHolder(view1);

    }





    @Override

    public void onBindViewHolder(final ViewHolder holder, final int position) {

        this.position=position;

        item_name.setText(allIncome_expense.get(position).get(1));
        amount.setText(allIncome_expense.get(position).get(2));

        Log.d("position 0 ID",allIncome_expense.get(0).get(0));
//        Log.d("position 1 ID",allIncome_expense.get(1).get(0));

        Log.d("Income",allIncome_expense.get(position).get(2));
    }



    @Override

    public int getItemCount() {

        return allIncome_expense.size();

    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View view) {
            super(view);
            item_name = (TextView) view.findViewById(R.id.item_name);
            amount = (TextView) view.findViewById(R.id.amount);

            dataBase = new Sayin_database(context,"sayin");
        }

    }

}


