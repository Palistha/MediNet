package com.example.sarita.medinet;

/**
 * Created by sarita on 6/23/2016.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlramReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("we are in the receiver","YES!");
        //fetch extra strings from the intent
        String get = intent.getExtras().getString("extra");
        int hour = intent.getExtras().getInt("hour");
        int minute = intent.getExtras().getInt("minute");
        System.out.println("getval: "+get);
       Log.e("Key", get);

        //fetch the extra long from the intent
        //tells app the value picked from spinner

        Long getSong = intent.getExtras().getLong("song_choice");
        Log.e("The whale choice is:", getSong.toString());
        //create an intent to start the service
        Intent service_intent = new Intent(context, RingtonePlaying.class);

        //pass the extra string to ringtone

        service_intent.putExtra("extra",get);
        service_intent.putExtra("hour",hour);
        service_intent.putExtra("minute",minute);

        //pass the extra integer to ringtone
        service_intent.putExtra("song_choice",getSong);
        //start the ringtone service
        context.startService(service_intent);

    }
}
