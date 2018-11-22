package com.view.widgets


import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.TabHost
import android.widget.TabHost.OnTabChangeListener

/**
 * A custom OnTabChangeListener that uses the TabHost its related to to fetch information about the current and previous
 * tabs. It uses this information to perform some custom animations that slide the tabs in and out from left and right.
 *
 * @author Daniel Kvist
 */
class AnimatedTabHostListener
/**
 * Constructor that takes the TabHost as a parameter and sets mPreviousView to the mCurrentView at instantiation
 *
 * @param mTabHost
 */
(private val mTabHost: TabHost) : OnTabChangeListener {
    private var mPreviousView: View? = null
    private var mCurrentView: View? = null
    private var mCurrentTab: Int = 0

    init {
        mPreviousView = mTabHost.currentView
    }

    /**
     * When tabs change we fetch the current view that we are animating to and animate it and the previous view in the
     * appropriate directions.
     */
    override fun onTabChanged(tabId: String) {

        mCurrentView = mTabHost.currentView
        if (mTabHost.currentTab > mCurrentTab) {
            mPreviousView?.animation = outToLeftAnimation()
            mCurrentView?.animation = inFromRightAnimation()
        } else {
            mPreviousView?.animation = outToRightAnimation()
            mCurrentView?.animation = inFromLeftAnimation()
        }
        mPreviousView = mCurrentView
        mCurrentTab = mTabHost.currentTab

    }

    /**
     * Custom animation that animates in from right
     *
     * @return Animation the Animation object
     */
    private fun inFromRightAnimation(): Animation {
        val inFromRight = TranslateAnimation(Animation.RELATIVE_TO_PARENT, 1.0f,
                                             Animation.RELATIVE_TO_PARENT, 0.0f,
                                             Animation.RELATIVE_TO_PARENT, 0.0f,
                                             Animation.RELATIVE_TO_PARENT, 0.0f)
        return setProperties(inFromRight)
    }

    /**
     * Custom animation that animates out to the right
     *
     * @return Animation the Animation object
     */
    private fun outToRightAnimation(): Animation {
        val outToRight = TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f,
                                            Animation.RELATIVE_TO_PARENT, 1.0f,
                                            Animation.RELATIVE_TO_PARENT, 0.0f,
                                            Animation.RELATIVE_TO_PARENT, 0.0f)
        return setProperties(outToRight)
    }

    /**
     * Custom animation that animates in from left
     *
     * @return Animation the Animation object
     */
    private fun inFromLeftAnimation(): Animation {
        val inFromLeft = TranslateAnimation(Animation.RELATIVE_TO_PARENT, -1.0f,
                                            Animation.RELATIVE_TO_PARENT, 0.0f,
                                            Animation.RELATIVE_TO_PARENT, 0.0f,
                                            Animation.RELATIVE_TO_PARENT, 0.0f)
        return setProperties(inFromLeft)
    }

    /**
     * Custom animation that animates out to the left
     *
     * @return Animation the Animation object
     */
    private fun outToLeftAnimation(): Animation {
        val outtoLeft = TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0.0f,
                                           Animation.RELATIVE_TO_PARENT, -1.0f,
                                           Animation.RELATIVE_TO_PARENT, 0.0f,
                                           Animation.RELATIVE_TO_PARENT, 0.0f)
        return setProperties(outtoLeft)
    }

    /**
     * Helper method that sets some common properties
     * @param animation the animation to give common properties
     * @return the animation with common properties
     */
    private fun setProperties(animation: Animation): Animation {
        animation.duration = ANIMATION_TIME
        animation.interpolator = AccelerateInterpolator()
        return animation
    }

    companion object {
        private const val ANIMATION_TIME: Long = 240
    }
}