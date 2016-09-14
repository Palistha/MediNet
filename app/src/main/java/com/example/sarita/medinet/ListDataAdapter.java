package com.example.sarita.medinet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarita on 6/20/2016.
 */

public class ListDataAdapter extends ArrayAdapter {
    List list= new ArrayList();

    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }
    static class layoutHandler {
       TextView Username,Email,Password,ConfirmPassword;

    }
    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        layoutHandler layoutHandler;
        if(row==null);
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);
            layoutHandler = new layoutHandler();
            layoutHandler.Username = (TextView) row.findViewById(R.id.text_user_name);
            layoutHandler.Email = (TextView) row.findViewById(R.id.text_email);
            layoutHandler.Password = (TextView) row.findViewById(R.id.text_Password);
            row.setTag(layoutHandler);
        }

        {
            layoutHandler = (layoutHandler) row.getTag();

        }
                DataProvider dataProvider =(DataProvider)this.getItem(position);
        layoutHandler.Username.setText(dataProvider.getUsername());
        layoutHandler.Email.setText(dataProvider.getEmail());
        layoutHandler.Password.setText(dataProvider.getPassword());

        return row;
    }
}







