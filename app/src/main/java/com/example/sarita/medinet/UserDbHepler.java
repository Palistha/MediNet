package com.example.sarita.medinet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by sarita on 6/19/2016.
 */
public class UserDbHepler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="USERIFO.DB";
    private static final int DATABASE_VERSION=1;
    private static final String CREATE_QUERY=
            "CREATE TABLE "+ UserContract.NewUserInfo.TABLE_NAME+"("+UserContract.NewUserInfo.USER_NAME+" TEXT," +
                     UserContract.NewUserInfo.USER_EMAIL+" TEXT,"+ UserContract.NewUserInfo.USER_PASSWORD+"TEXT"+
                    UserContract.NewUserInfo.USER_CONFIRMPASSWORD+" TEXT);";

        public UserDbHepler(Context context)
        {

            super(context,DATABASE_NAME,null,DATABASE_VERSION);
            Log.e("DATABASE OPERATIONS","Database created/opened...");
        }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.e("DATABASE OPERATIONS","Table created...");

    }

    public void addinformations(String username,String email,String password,SQLiteDatabase db)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(UserContract.NewUserInfo.USER_NAME,username);
        contentValues.put(UserContract.NewUserInfo.USER_EMAIL,email);
        contentValues.put(UserContract.NewUserInfo.USER_PASSWORD,password);
        db.insert(UserContract.NewUserInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATIONS","One row insert...");
    }
    public Cursor getInfomation(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projections={UserContract.NewUserInfo.USER_NAME,UserContract.NewUserInfo.USER_EMAIL,UserContract.NewUserInfo.USER_PASSWORD,UserContract.NewUserInfo.USER_CONFIRMPASSWORD};

       cursor= db.query(UserContract.NewUserInfo.TABLE_NAME,projections,null,null,null,null,null);
        return cursor;
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
