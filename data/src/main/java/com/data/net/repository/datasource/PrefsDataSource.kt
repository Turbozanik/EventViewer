package com.data.net.repository.datasource

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager


open class PrefsDataSource(context: Context) {

    private val prefsDataSource: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

}