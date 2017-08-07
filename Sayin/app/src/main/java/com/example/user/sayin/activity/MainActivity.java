package com.example.user.sayin.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.sayin.R;
import com.example.user.sayin.activity.base.BaseActivity;
import com.example.user.sayin.database.Sayin_database;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends BaseActivity {

    EditText item_name,amount;
    Button submit,show,overall;

    String Item_name,Amount;

    ContentValues values_expense;
    Sayin_database dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBase = new Sayin_database(MainActivity.this,"sayin");
        item_name = (EditText) findViewById(R.id.item_name);
        amount = (EditText) findViewById(R.id.amount);
        submit = (Button) findViewById(R.id.submit);
        show = (Button) findViewById(R.id.show);
        overall = (Button) findViewById(R.id.overall);

        Item_name = item_name.getText().toString();
        Amount = amount.getText().toString();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert_today_expense();
                Intent intent = new Intent(MainActivity.this,ShowExpenseActivity.class);
                startActivity(intent);
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ShowExpenseActivity.class);
                startActivity(intent);
            }
        });

        overall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,OverallActivity.class);
                startActivity(intent);
            }
        });

    }

    public void insert_today_expense()
    {
        values_expense = new ContentValues();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = dateFormat.format(new Date()); // Find todays date

        Log.d("Amount",item_name.getText().toString());
        Log.d("Item name",amount.getText().toString());
        values_expense.put(dataBase.KEY_AMOUNT, item_name.getText().toString() +"");
        values_expense.put(dataBase.KEY_ITEM_NAME,amount.getText().toString() +"");
        values_expense.put(dataBase.KEY_TODAY, currentDateTime + "");

        long a = dataBase.save_today_expense(values_expense);
        Log.d("Expense table", a + "");
    }
}
