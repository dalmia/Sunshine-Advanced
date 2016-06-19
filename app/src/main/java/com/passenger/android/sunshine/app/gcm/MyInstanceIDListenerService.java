package com.passenger.android.sunshine.app.gcm;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by aman on 11/6/16.
 */
public class MyInstanceIDListenerService extends InstanceIDListenerService {

    private final String TAG = "InstanceIDLS";

    /**
     * Called when Instance ID updated, due to maybe the last
     * one's security being compromised. This call is initiated
     * by InstanceID Provider.
     */
    @Override
    public void onTokenRefresh() {
        // get the updated Instance ID
        Intent intent = new Intent(this, RegistrationIntentService.class);
        startService(intent);
    }
}
