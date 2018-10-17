package com

import android.content.Context
import android.content.Intent
import com.view.ui.auth.AuthActivity
import com.view.ui.main.EventListActivity


class ActivityNavigator(context: Context) {
    private val mContext: Context = context

    fun startActivityWithInitialAction(activityAction: ActivityAction) {
        startActivity(applyAction(getNewActivityIntent(getStringKeyByAction(activityAction)),
                                  activityAction))
    }

    private fun applyAction(intent: Intent, activityAction: ActivityAction): Intent {
        intent.putExtra(ACTIVITY_ACTION_DATA_KEY, activityAction)
        return intent
    }

    fun startActivity(stringKey: String) {
        startActivity(getNewActivityIntent(stringKey))
    }

    private fun startActivity(intent: Intent) {
        mContext.startActivity(intent)
    }

    private fun getNewActivityIntent(stringKey: String): Intent {
        return when (stringKey) {
            MAIN_ACTIVITY -> {
                Intent(mContext, EventListActivity::class.java)
            }
            AUTH_ACTIVITY -> {
                Intent(mContext, AuthActivity::class.java)
            }
            else -> {
                throw IllegalArgumentException(Throwable("Unknown activity"))
            }
        }
    }

    private fun getStringKeyByAction(activityAction: ActivityAction): String {
        return when (activityAction) {
            ActivityAction.OPEN_AUTH_ACTIVITY -> {
                AUTH_ACTIVITY
            }
            ActivityAction.OPEN_MAIN_ACTIVITY -> {
                MAIN_ACTIVITY
            }
            ActivityAction.OPEN_AUTH_ACTIVITY_WITH_NO_SAVED_CREDENTIALS -> {
                AUTH_ACTIVITY
            }
            ActivityAction.DEFAULT -> {
                AUTH_ACTIVITY
            }
            ActivityAction.OPEN_MAIN_ACTIVITY_WITH_EVENT_LIST_FRAGMENT -> {
                MAIN_ACTIVITY
            }
            ActivityAction.OPEN_AUTH_ACTIVITY_WITH_SAVED_CREDENTIALS -> {
                AUTH_ACTIVITY
            }
        }
    }

}