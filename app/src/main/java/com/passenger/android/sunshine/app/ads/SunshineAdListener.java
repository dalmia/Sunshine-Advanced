package com.passenger.android.sunshine.app.ads;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

/**
 * Created by aman on 21/6/16.
 */
public class SunshineAdListener extends AdListener{
    private Context mContext;
    private String errorReason;
    public SunshineAdListener(Context context){
        mContext = context;
    }

    @Override
    public void onAdClosed() {
        super.onAdClosed();
    }

    @Override
    public void onAdFailedToLoad(int errorCode) {
        super.onAdFailedToLoad(errorCode);
        errorReason = "";
        switch(errorCode) {
            case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                errorReason = "Internal Error";
                break;
            case AdRequest.ERROR_CODE_INVALID_REQUEST:
                errorReason = "Invalid Request";
                break;
            case AdRequest.ERROR_CODE_NETWORK_ERROR:
                errorReason = "Network Error";
                break;

            default:
                errorReason = "Unknown Error";
        }
        Toast.makeText(mContext, errorReason, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdLeftApplication() {
        super.onAdLeftApplication();
    }

    @Override
    public void onAdLoaded() {
        super.onAdLoaded();
    }

    @Override
    public void onAdOpened() {
        super.onAdOpened();
    }
}
