package com.example.sarita.medinet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        Intent intent = new Intent(this, patientlogin.class);
        startActivity(intent);
    }

    public void register(View view) {
        Intent intent = new Intent(this, PatientRegister.class);
        startActivity(intent);
    }
}

