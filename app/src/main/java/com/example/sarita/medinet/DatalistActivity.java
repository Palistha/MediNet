package com.example.sarita.medinet;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;


public class DatalistActivity extends AppCompatActivity {

    ListView listView,lv;
SQLiteDatabase sqLiteDatabase;
    UserDbHepler userDbHepler;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list_layout);
       // listView = getListView();
        //listView= (ListView)findViewById(R.id.list_view);


        listDataAdapter=new ListDataAdapter((getApplicationContext()),R.layout.row_layout);
//        listView.setListAdapter(listDataAdapter);
       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), AddDoctor.class);
                    startActivity(intent);
                }
            }
        });*/
        userDbHepler=new UserDbHepler(getApplicationContext());
        sqLiteDatabase=userDbHepler.getReadableDatabase();

cursor=userDbHepler.getInfomation(sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            do{
                String username,Email,Password,ConfirmPassword;
                username=cursor.getString(0);
                Email=cursor.getString(1);
                Password=cursor.getString(2);
                ConfirmPassword=cursor.getString(2);
                DataProvider dataProvider=new DataProvider(username,Email,Password,ConfirmPassword);
                listDataAdapter.add(dataProvider);
           }while(cursor.moveToNext());
        }

    }
}
