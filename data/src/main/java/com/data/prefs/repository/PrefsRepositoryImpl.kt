package com.data.prefs.repository

import com.data.prefs.datasource.PrefsDataSource
import com.domain.repository.PrefsRepository

class PrefsRepositoryImpl(prefsDataSource: PrefsDataSource) : PrefsRepository {

    private val mPrefsDataSource = prefsDataSource

    override fun saveUserEmail(email: String) {
        mPrefsDataSource.saveUserEmail(email)
    }

    override fun saveUserPassword(password: String) {
        mPrefsDataSource.saveUserPassword(password)
    }

    override fun getUserEmail(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserPassword(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}