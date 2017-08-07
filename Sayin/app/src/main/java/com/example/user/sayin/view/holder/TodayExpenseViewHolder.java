package com.example.user.sayin.view.holder;

import android.view.View;
import android.widget.TextView;

import com.example.user.sayin.R;
import com.example.user.sayin.model.TodayExpense;
import com.example.user.sayin.view.holder.base.BaseViewHolder;

import org.w3c.dom.Text;

import butterknife.BindView;

/**
 * Created by root on 8/8/17.
 */

public class TodayExpenseViewHolder extends BaseViewHolder<TodayExpense> {


    @BindView(R.id.item_name)
    TextView itemName;

    @BindView(R.id.amount)
    TextView amount;

    public TodayExpenseViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind(TodayExpense data) {
        itemName.setText(data.item_name);
        amount.setText(data.amount);
    }

    @Override
    public void onClick(View view) {

    }
}
