package com.example.sarita.medinet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class patientlogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientlogin);
    }
    public void list(View view){
        Intent intent=new Intent(this,ListView.class);
        startActivity(intent);
    }

    public void viewContact(View view) {
            Intent intent=new Intent(this,DatalistActivity.class);
            startActivity(intent);
    }
    }











