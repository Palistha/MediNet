package com.example.sarita.medinet;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PatientRegister extends AppCompatActivity {
    EditText ContactUsername,ContactEmail,ContactPassword;

Context context =this;
    UserDbHepler userDbHepler;
    SQLiteDatabase sqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_register);
        ContactUsername = (EditText) findViewById(R.id.editTextUserName);
        ContactEmail = (EditText) findViewById(R.id.editTextEmail);
        ContactPassword = (EditText) findViewById(R.id.editTextPassword);

    }

        public void addContact(View view)
    {
        String Username= ContactUsername.getText().toString();
        String Email= ContactEmail.getText().toString();
        String password= ContactPassword.getText().toString();
        userDbHepler=new UserDbHepler(context);
        sqLiteDatabase=userDbHepler.getWritableDatabase();
        userDbHepler.addinformations(Username,Email,password,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();
        userDbHepler.close();
    }

    public void signin(View view){
        String Username= ContactUsername.getText().toString();
        String Email= ContactEmail.getText().toString();
        String password= ContactPassword.getText().toString();
        userDbHepler=new UserDbHepler(context);
        sqLiteDatabase=userDbHepler.getWritableDatabase();
        userDbHepler.addinformations(Username,Email,password,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();
        userDbHepler.close();
        Intent intent=new Intent(this,patientlogin.class);
        startActivity(intent);
    }

}
