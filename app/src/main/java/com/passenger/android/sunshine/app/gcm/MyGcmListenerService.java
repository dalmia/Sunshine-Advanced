package com.passenger.android.sunshine.app.gcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.passenger.android.sunshine.app.MainActivity;
import com.passenger.android.sunshine.app.R;
import com.google.android.gms.gcm.GcmListenerService;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by aman on 11/6/16.
 */
public class MyGcmListenerService extends GcmListenerService {

    private final String TAG = MyGcmListenerService.class.getSimpleName();

    private static final String EXTRA_DATA = "data";
    private static final String EXTRA_WEATHER = "weather";
    private static final String EXTRA_LOCATION = "location";

    public static final int NOTIFICATION_ID = 1;
    /**
     * Called when a message is received
     * @param from  the senderID of the sender
     * @param data  bundle containing the message
     */
    @Override
    public void onMessageReceived(String from, Bundle data) {
        super.onMessageReceived(from, data);
        if (!data.isEmpty()) {
            // TODO: gcm_default sender ID comes from the API console
            String senderId = getString(R.string.gcm_defaultSenderId);
            if (senderId.length() == 0) {
                Toast.makeText(this, "SenderID string needs to be set", Toast.LENGTH_LONG).show();
            }
            // Not a bad idea to check that the message is coming from your server.
            if ((senderId).equals(from)) {
                // Process message and then post a notification of the received message.
                try {
                    JSONObject jsonObject = new JSONObject(data.getString(EXTRA_DATA));
                    String weather = jsonObject.getString(EXTRA_WEATHER);
                    String location = jsonObject.getString(EXTRA_LOCATION);
                    String alert =
                            String.format(getString(R.string.gcm_weather_alert), weather, location);
                    sendNotification(alert);
                } catch (JSONException e) {
                    // JSON parsing failed, so we just let this message go, since GCM is not one
                    // of our critical features.
                }
            }
            Log.i(TAG, "Received: " + data.toString());
        }
    }


    /**
     * Shows a notification to the user on receiving weather
     * updates from the server.
     *
     * @param message The alert message received from the server
     */
        private void sendNotification(String message){
            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            PendingIntent contentIntent =
                    PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
            Bitmap largeIcon = BitmapFactory.decodeResource(this.getResources(), R.drawable.art_storm);
            NotificationCompat.Builder builder =
                    new NotificationCompat.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.art_clear)
                    .setContentTitle("Weather Alert")
                    .setContentText(message)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setContentIntent(contentIntent);
            notificationManager.notify(NOTIFICATION_ID, builder.build());
        }
}
