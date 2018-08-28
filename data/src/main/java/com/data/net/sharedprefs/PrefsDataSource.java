package com.data.net.sharedprefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PrefsDataSource {

    private static SharedPreferences prefs;

    public PrefsDataSource(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

}
