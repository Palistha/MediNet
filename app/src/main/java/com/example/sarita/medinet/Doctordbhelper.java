package com.example.sarita.medinet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sarita on 6/24/2016.
 */
public class Doctordbhelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    private static final String DATABSE_NAME = "Student.db";

    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";

    public static final String COL_3 = "Speciality";
    public static final String COL_4 = "Email";
    public static final String COL_5 = "Address";
    public static final String COL_6 = "Note";

    public Doctordbhelper(Context context) {

        super(context, DATABSE_NAME, null, DATABASE_VERSION);

    }

    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT, SPECIALITY TEXT,EMAIL TEXT,ADDRESS TEXT,NOTE TEXT)");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);

        onCreate(db);

    }
    public boolean insertData(String name, String speciality, String email, String address, String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, name);

        contentValues.put(COL_3, speciality);
        contentValues.put(COL_4, email);
        contentValues.put(COL_5, address);
        contentValues.put(COL_6, note);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String id, String name, String speciality, String email, String address, String note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);

        contentValues.put(COL_3, speciality);

        contentValues.put(COL_4, email);
        contentValues.put(COL_5, address);
        contentValues.put(COL_6, note);


        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }

    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID=?", new String[]{id});


    }
}
