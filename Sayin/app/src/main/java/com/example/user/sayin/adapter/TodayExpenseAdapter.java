package com.example.user.sayin.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.sayin.R;
import com.example.user.sayin.adapter.base.BaseRecyclerAdapter;
import com.example.user.sayin.model.TodayExpense;
import com.example.user.sayin.view.holder.TodayExpenseViewHolder;

/**
 * Created by root on 8/8/17.
 */

public class TodayExpenseAdapter extends BaseRecyclerAdapter<TodayExpenseViewHolder,TodayExpense> {
    public TodayExpenseAdapter(Context context) {
        super(context);
    }

    @Override
    public TodayExpenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = mLayoutInflater.inflate(R.layout.single_view,parent,false);
        return new TodayExpenseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TodayExpenseViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }
}
