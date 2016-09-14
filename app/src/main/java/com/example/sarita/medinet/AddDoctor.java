package com.example.sarita.medinet;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddDoctor extends AppCompatActivity {

    Doctordbhelper myDb;
    EditText editName, editSpeciality, editEmail, editAddress, editNote, editTextid;
    Button btnAddData;
    Button btnviewAll;
    Button btnviewUpdate;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doctor);


        myDb = new Doctordbhelper(this);

        editName = (EditText) findViewById(R.id.editTextName);
        editSpeciality = (EditText) findViewById(R.id.editTextSpeciality);
        editEmail = (EditText) findViewById(R.id.editTextEmail);
        editAddress = (EditText) findViewById(R.id.editTextAddress);
        editNote = (EditText) findViewById(R.id.editTextNote);
        editTextid = (EditText) findViewById(R.id.editTextId);
        btnAddData = (Button) findViewById(R.id.buttonAdd);
        btnviewAll = (Button) findViewById(R.id.buttonviewAll);
        btnviewUpdate = (Button) findViewById(R.id.buttonUpdate);
        btnDelete = (Button) findViewById(R.id.buttonDelete);

        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {
                       /* boolean isUpdate = myDb.updateData(editTextid.getText().toString(),
                                editName.getText().toString(),
                                editSpeciality.getText().toString(),
                                editEmail.getText().toString(),
                                editAddress.getText().toString(),
                                editNote.getText().toString());

                        if (isUpdate == true)
                            Toast.makeText(AddDoctor.this, "Data Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddDoctor.this, "Data not Updated", Toast.LENGTH_LONG).show();
                            */
                        System.out.println("test");

                    }


                }
        );
        Add();
        viewAll();
        Update();
        Delete();
    }

    public void Delete() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editTextid.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(AddDoctor.this, "Data is deleted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddDoctor.this, "Data not deleted", Toast.LENGTH_LONG).show();
                    }

                }
        );

    }

    public void Update() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextid.getText().toString(),
                                editName.getText().toString(),
                                editSpeciality.getText().toString(),
                                editEmail.getText().toString(),
                                editAddress.getText().toString(),
                                editNote.getText().toString());

                        if (isUpdate == true)
                            Toast.makeText(AddDoctor.this, "Data Updated", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddDoctor.this, "Data not Updated", Toast.LENGTH_LONG).show();
                    }

                }
        );
    }

    public void Add() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),

                                editSpeciality.getText().toString(),
                                editEmail.getText().toString(),
                                editAddress.getText().toString(),
                                editNote.getText().toString());


                        if (isInserted == true)
                            Toast.makeText(AddDoctor.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddDoctor.this, "Data not Inserted", Toast.LENGTH_LONG).show();


                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            //Show Message
                            showMessage("Error", "Nothing found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :" + res.getString(0) + "\n");
                            buffer.append("Name :" + res.getString(1) + "\n");
                            buffer.append("Speciality :" + res.getString(2) + "\n");
                            buffer.append("Email :" + res.getString(3) + "\n\n");
                            buffer.append("Address :" + res.getString(4) + "\n\n");
                            buffer.append("Note :" + res.getString(5) + "\n\n");

                        }
                        showMessage("Data", buffer.toString());

                    }
                }
        );
    }

    public void showMessage(String title, String Message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);

    }


    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_doctor);
//    }
    public void onclick(View v) {
        Intent intent = new Intent(getApplicationContext(), doctord.class);
        startActivity(intent);
    }

}
