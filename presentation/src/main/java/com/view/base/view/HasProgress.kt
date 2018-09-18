package com.view.base.view

import android.view.View


interface HasProgress {
	fun showProgress()
	fun hideProgress()
	val progressView: View
}