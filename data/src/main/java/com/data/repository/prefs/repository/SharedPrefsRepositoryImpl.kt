package com.data.repository.prefs.repository

import com.data.repository.prefs.datasource.PrefsDataSource
import com.domain.repository.SharedPrefsRepository
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable

class SharedPrefsRepositoryImpl(prefsDataSource: PrefsDataSource) : SharedPrefsRepository {

    private val mPrefsDataSource = prefsDataSource

    override fun saveUserEmail(email: String?): Flowable<Any> {
        return Flowable.create({ mPrefsDataSource.saveUserEmail(email) },
                               BackpressureStrategy.DROP)
    }

    override fun saveUserPassword(password: String?): Flowable<Any> {
        return Flowable.create({ mPrefsDataSource.saveUserPassword(password) },
                               BackpressureStrategy.DROP)
    }

    override fun getUserEmail(): Flowable<String> {
        return Flowable.just(mPrefsDataSource.getUserEmail())
    }

    override fun getUserPassword(): Flowable<String> {
        return Flowable.just(mPrefsDataSource.getUserPassword())
    }

}