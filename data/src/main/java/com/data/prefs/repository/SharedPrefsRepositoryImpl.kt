package com.data.prefs.repository

import com.data.prefs.datasource.PrefsDataSource
import com.domain.repository.SharedPrefsRepository

class SharedPrefsRepositoryImpl(prefsDataSource: PrefsDataSource) : SharedPrefsRepository {

    private val mPrefsDataSource = prefsDataSource

    override fun saveUserEmail(email: String?) {
        mPrefsDataSource.saveUserEmail(email)
    }

    override fun saveUserPassword(password: String?) {
        mPrefsDataSource.saveUserPassword(password)
    }

    override fun getUserEmail(): String {
        return mPrefsDataSource.getUserEmail()
    }

    override fun getUserPassword(): String {
        return mPrefsDataSource.getUserPassword()
    }

}