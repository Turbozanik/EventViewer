package com

import android.content.Context


class ModulesNavigator(context: Context) {
//    private val mContext: Context = context
//
//    fun startActivityWithInitialAction(activityAction: InitialAction) {
//        startActivity(applyAction(getNewActivityIntent(getStringKeyByAction(activityAction)),
//                                  activityAction))
//    }
//
//    private fun applyAction(intent: Intent, activityAction: InitialAction): Intent {
//        intent.putExtra(ACTIVITY_ACTION_DATA_KEY, activityAction)
//        return intent
//    }
//
//    fun startActivity(stringKey: String) {
//        startActivity(getNewActivityIntent(stringKey))
//    }
//
//    private fun startActivity(intent: Intent) {
//        mContext.startActivity(intent)
//    }
//
//    private fun getNewActivityIntent(stringKey: String): Intent {
//        return when (stringKey) {
//            MAIN_ACTIVITY -> {
//                Intent(mContext, RootGodlikeActivity::class.java)
//            }
//            AUTH_ACTIVITY -> {
//                Intent(mContext, AuthActivity::class.java)
//            }
//            else -> {
//                throw IllegalArgumentException(Throwable("Unknown activity"))
//            }
//        }
//    }
//
//    private fun getStringKeyByAction(activityAction: InitialAction): String {
//        return when (activityAction) {
//            InitialAction.OPEN_AUTH -> {
//                AUTH_ACTIVITY
//            }
//            InitialAction.OPEN_MAIN -> {
//                MAIN_ACTIVITY
//            }
//            InitialAction.OPEN_AUTH_WITH_NO_SAVED_CREDENTIALS -> {
//                AUTH_ACTIVITY
//            }
//            InitialAction.DEFAULT -> {
//                AUTH_ACTIVITY
//            }
//            InitialAction.OPEN_MAIN_WITH_EVENT_LIST_FRAGMENT -> {
//                MAIN_ACTIVITY
//            }
//            InitialAction.OPEN_AUTH_WITH_SAVED_CREDENTIALS -> {
//                AUTH_ACTIVITY
//            }
//        }
//    }

}