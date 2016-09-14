package com.example.sarita.medinet;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ListView extends Activity {
    ListView listView, lv;
    SQLiteDatabase sqLiteDatabase;
    UserDbHepler userDbHepler;
    Cursor cursor;
    ListDataAdapter listDataAdapter;
    TextView tvDoctorDetail, tvAppointment, tvAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        tvDoctorDetail = (TextView) findViewById(R.id.tvDoctorDetail);
        tvAppointment = (TextView) findViewById(R.id.tvAppointment);
        tvAbout = (TextView) findViewById(R.id.tvAbout);

        tvDoctorDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddDoctor.class);
                startActivity(intent);
            }
        });
        tvAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Appointment.class);
                startActivity(intent);
            }
        });
        tvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AboutMedReminder.class);
                startActivity(intent);
            }
        });
    }
}







//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState) {
//        lv = getListView();
//
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, final View view,
//                                    int position, long id) {
//                //Post p=new Post();
//                final Post p = (Post) parent.getAdapter().getItem(position);
//                final Intent i=new Intent(getActivity(), PostActivity.class);
//
//                i.putExtra("userId",p.getUserId());
//                i.putExtra("postContent",p.getPostContent());
//                i.putExtra("location",p.getLocation());
//                i.putExtra("date_time",p.getDate_time());
//                startActivity(i);
//                Log.v("userId home", String.valueOf(p.getUserId()));
//                //Toast.makeText(getActivity(), p.getPostContent(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//




