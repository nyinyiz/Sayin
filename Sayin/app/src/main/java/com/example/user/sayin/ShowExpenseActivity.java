package com.example.user.sayin;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.user.sayin.adapter.RecyclerViewAdapter;
import com.example.user.sayin.database.Sayin_database;

import java.util.List;

public class ShowExpenseActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;

    ContentValues values_expense;
    Sayin_database dataBase;

    List<List<String>> templist;
    List<List<String>> tempincome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_expense);

        dataBase = new Sayin_database(ShowExpenseActivity.this,"sayin");
        //////////////////////////////////////////Recycler
        RecyclerView simpleList = (RecyclerView) findViewById(R.id.recyclerview1);
        RecyclerViewLayoutManager = new LinearLayoutManager(getApplicationContext());
        simpleList.setLayoutManager(RecyclerViewLayoutManager);
        templist = dataBase.get_all_today_expense();
        Log.d("UpDown Size", templist.size() + "");
        final RecyclerViewAdapter alertAdapter = new RecyclerViewAdapter(getApplicationContext(), templist);

        simpleList.setAdapter(alertAdapter);
        ////////////////////////////////////////////
    }
}
