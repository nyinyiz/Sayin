package com.example.user.sayin.activity;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.sayin.R;
import com.example.user.sayin.SayinApp;
import com.example.user.sayin.activity.base.BaseActivity;
import com.example.user.sayin.adapter.TodayExpenseAdapter;
import com.example.user.sayin.components.rvset.SmartRecyclerView;
import com.example.user.sayin.database.Sayin_database;
import com.example.user.sayin.events.InternalEvent;
import com.example.user.sayin.model.TodayExpense;
import com.example.user.sayin.view.holder.pods.EmptyViewPod;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by YWN on 8/7/17.
 */

public class TodayExpenseActivity extends BaseActivity {

    @BindView(R.id.itemName)
    EditText itemName;
    @BindView(R.id.amount)
    EditText amount;

    @BindView(R.id.recycler)
    SmartRecyclerView rvItem;

    @BindView(R.id.empty)
    EmptyViewPod emptyViewPod;


    @BindView(R.id.save)
    Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today_expense);
       ButterKnife.bind(this,this);


        List<TodayExpense> list = SayinApp.database.getAllDayExpense();
        TodayExpenseAdapter adapter = new TodayExpenseAdapter(this);
        rvItem.setEmptyView(emptyViewPod);
        emptyViewPod.setEmptyLabel("No Expenseed Item");
        rvItem.setAdapter(adapter);

        adapter.setNewData(list);




    }

    @OnClick(R.id.save)
    public void save(View v)
    {

        System.out.print(itemName.getText().toString());
        Date date = new Date();
        ContentValues values = new ContentValues();
        values.put(Sayin_database.KEY_ITEM_NAME,itemName.getText().toString());
        values.put(Sayin_database.KEY_AMOUNT,amount.getText().toString());
        values.put(Sayin_database.KEY_TODAY,date.getDay()+"/"+date.getMonth()+"/"+date.getYear());

         if(SayinApp.database.save_today_expense(values) != 0 ){
             EventBus.getDefault().post(new InternalEvent.TodayExpenseItemUpdate());
         }else{
             Snackbar.make(v,"Don't save ",Snackbar.LENGTH_LONG).show();
         }



    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public void onTodayExpenseUpdate(InternalEvent.TodayExpenseItemUpdate obj) {
        List<TodayExpense> list = SayinApp.database.getAllDayExpense();
        TodayExpenseAdapter adapter = new TodayExpenseAdapter(this);
        rvItem.setAdapter(adapter);
        adapter.setNewData(list);

    }
}
