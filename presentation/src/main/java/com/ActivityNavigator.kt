package com

import android.content.Context
import android.content.Intent


class ActivityNavigator(context: Context) {
    private val mContext: Context = context

    fun startActivityWithInitialAction(stringKey: String, activityAction: ActivityAction) {
        startActivity(applyAction(getNewActivityIntent(stringKey), activityAction))
    }

    private fun applyAction(intent: Intent, activityAction: ActivityAction): Intent {
        return intent.putExtra(Constants.ACTIVITY_ACTION_DATA_KEY, activityAction)
    }

    fun startActivity(stringKey: String) {
        startActivity(getNewActivityIntent(stringKey))
    }

    private fun startActivity(intent: Intent) {
        mContext.startActivity(intent)
    }

    private fun getNewActivityIntent(stringKey: String): Intent {
        return when (stringKey) {
            ActivityScreenKey.MAIN_ACTIVITY -> {
                Intent()
                //TODO
            }
            ActivityScreenKey.POS_ACTIVITY -> {
                Intent()
                //TODO
            }
            else -> {
                throw IllegalArgumentException(Throwable("Unknown activity"))
            }
        }
    }
}