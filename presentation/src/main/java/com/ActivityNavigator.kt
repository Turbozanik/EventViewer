package com

import android.content.Context
import android.content.Intent


class ActivityNavigator(context: Context) {
	private val mContext: Context = context

	fun startActivityWithInitialAction(activityAction: ActivityAction) {
		startActivity(applyAction(getNewActivityIntent(getStringKeyByAction(activityAction)),
								  activityAction))
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
			MAIN_ACTIVITY -> {
				Intent()
				//TODO
			}
			AUTH_ACTIVITY -> {
				Intent()
				//TODO
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
			ActivityAction.OPEN_AUTH_ACTIVITY_WITH_NO_SAVED_CREDENTIALS -> TODO()
			ActivityAction.DEFAULT -> TODO()
		}
	}

}