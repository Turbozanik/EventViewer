package com.data.repository.prefs.datasource

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.data.repository.prefs.USER_EMAIL
import com.data.repository.prefs.USER_PASSWORD


open class PrefsDataSource(context: Context) {

    private val mPrefsDataSource: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(
            context)

    fun saveUserEmail(email: String?) {
        mPrefsDataSource.edit().putString(USER_EMAIL, email).apply()
    }

    fun saveUserPassword(password: String?) {
        mPrefsDataSource.edit().putString(USER_PASSWORD, password).apply()
    }

    fun getUserEmail(): String {
        return mPrefsDataSource.getString(USER_EMAIL, "")
    }

    fun getUserPassword(): String {
        return mPrefsDataSource.getString(USER_PASSWORD, "")
    }

}