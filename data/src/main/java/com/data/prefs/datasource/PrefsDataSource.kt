package com.data.prefs.datasource

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.data.prefs.USER_EMAIL
import com.data.prefs.USER_PASSWORD


open class PrefsDataSource(context: Context) {

	private val mPrefsDataSource: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(
			context)

	fun saveUserEmail(email: String) {
		mPrefsDataSource.edit().putString(USER_EMAIL, email).apply()
	}

	fun saveUserPassword(password: String) {
		mPrefsDataSource.edit().putString(USER_PASSWORD, password).apply()
	}

}