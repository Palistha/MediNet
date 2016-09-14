package com.example.sarita.medinet;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

/**
 * Created by sarita on 6/26/2016.
 */
public class RingtonePlaying extends Service {

    MediaPlayer media_song;
    boolean isRunning;
    int start_id;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i("LocalService", "Received start id" + startId + ":" + intent);
        //fetch the extra string values
        String state = intent.getExtras().getString("extra");
        System.out.println("stateval"+state);
        //fetch the extra integer values
        int song = intent.getExtras().getInt("song_choice");
        Log.e("Ringtone state", state);


        if(state.equals("on")){
            int hour = intent.getExtras().getInt("hour");
            int minute = intent.getExtras().getInt("minute");
            intent.getExtras().getString("minute");
            System.out.println("Ringtone");
            NotificationManager notify_manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            // set up an intent that goes to the Main Activity
            Intent intent_main_activity = new Intent(this.getApplicationContext(), ScheduleDate.class);
            //set up a pending intent
            PendingIntent pending_intent_main_activity = PendingIntent.getActivity(this, 0, intent_main_activity, 0);

            //make the notification parameters
            Notification notification_popup = new Notification.Builder(this)
                    .setContentTitle("You have appointment at"+Integer.toString(hour)+" : "+Integer.toString(minute))
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentText("Click me!")
                    .setContentIntent(pending_intent_main_activity)
                    .setAutoCancel(true)
                    .build();

            //set up the notification call command
            notify_manager.notify(0, notification_popup);
        }


            //create an instance of the media player



        return START_NOT_STICKY;

    }
}
