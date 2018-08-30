package com.data.net.sharedprefs

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager


class PrefsDataSource(context: Context) {

    private val prefsDataSource: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

}