package com.example.android.sunshine.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;

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
