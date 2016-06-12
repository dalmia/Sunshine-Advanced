package com.example.android.sunshine.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlacePicker;

/**
 * Custom EditTextPreference to handle specific attribute changes
 */

public class LocationEditTextPreference extends EditTextPreference {

    // in case no minLength attribute is set in the preference xml file
    static final int DEFAULT_MIN_LENGTH_VALUE = 2;
    // custom attribute - minimum length of the string
    private int mMinLength;


    public LocationEditTextPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.LocationEditTextPreference, 0, 0);
        try {
            mMinLength = array.getInteger(R.styleable.LocationEditTextPreference_minLength, DEFAULT_MIN_LENGTH_VALUE);
        } finally {
            array.recycle();
        }
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(getContext());
        if (resultCode == ConnectionResult.SUCCESS) {
            // Add the get current location widget to our location preference
            setWidgetLayoutResource(R.layout.pref_current_location);
        }
    }

    @Override
    protected View onCreateView(ViewGroup parent) {
        View view = super.onCreateView(parent);
        View currentLocation = view.findViewById(R.id.current_location);
        currentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                Context context = getContext();
                SettingsActivity activity = (SettingsActivity) context;

                try{
                   activity.startActivityForResult(builder.build((Activity) context),
                           SettingsActivity.PLACE_PICKER_REQUEST);

                }catch (GooglePlayServicesRepairableException
                        |GooglePlayServicesNotAvailableException e){

                }
            }
        });
        return view;
    }

    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);

        //get the edit text from the dialog
        EditText mEditText = getEditText();
        //set the editTextListener to detect when the user starts typing
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // We don't need this
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // We don't need this
            }

            @Override
            public void afterTextChanged(Editable s) {
                //get the dialog instance
                Dialog dialog = getDialog();
                //handle possible bugs in any future code changes
                if(dialog instanceof AlertDialog){

                    AlertDialog alertDialog = (AlertDialog) dialog;
                    //get the positive button
                    Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);

                    //check our condition
                    if(s.length()<mMinLength){
                        positiveButton.setEnabled(false);
                    }else{
                        positiveButton.setEnabled(true);
                    }
                }
            }
        });
    }

}
