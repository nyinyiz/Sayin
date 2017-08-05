package com.example.user.sayin.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 8/5/2017.
 */

public class Sayin_database extends SQLiteOpenHelper {

    public static final String KEY_ID = "ID";
    private static final int DATABASE_VERSION = 1;

    //EXPENSE
    public static final String KEY_EXPENSE_TABLE = "expense",
    KEY_EXPENSE = "expense",
    KEY_AMOUNT = "amount",
    KEY_TODAY = "today";

    //INCOME
    public static final String KEY_INCOM_TABLE = "income",
    KEY_INCOME = "expense";

    //TODAY_EXPENSE
    public static final String KEY_TODAY_EXPENSE = "today_expense",
    KEY_ITEM_NAME = "item_name";


    public Sayin_database(Context context, String DBName) {

        super(context, DBName, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //INCOME_EXPENSE
        String CREATE_TODAY_EXPENSE_TABLE = "CREATE TABLE " + KEY_TODAY_EXPENSE + "("

                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"

                + KEY_ITEM_NAME + " TEXT,"

                + KEY_AMOUNT + " TEXT,"

                + KEY_TODAY + " TEXT)";

        //create_today_expense
        db.execSQL(CREATE_TODAY_EXPENSE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //onupgrade_today_expense
        db.execSQL("DROP TABLE IF EXISTS " + KEY_TODAY_EXPENSE);
        onCreate(db);


    }

    public List<List<String>> get_all_today_expense() {

        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + KEY_TODAY_EXPENSE ;

        List<List<String>> result = new ArrayList<List<String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        while (cursor.moveToNext()) {

            List<String> temp = new ArrayList<String>();

            temp.add(String.valueOf(cursor.getInt(0)));

            temp.add(cursor.getString(1));

            temp.add(cursor.getString(2));

            temp.add(cursor.getString(3));

            Log.d("today_expense", temp.toString());

            result.add(temp);
        }

        return result;
    }
    public long save_today_expense(ContentValues values) {

        SQLiteDatabase db = this.getWritableDatabase();

        long a = db.insert(KEY_TODAY_EXPENSE, null, values);

        return a;

    }
}
