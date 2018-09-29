package com.view.ui.auth.register

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.inputmethod.EditorInfo
import com.FRAGMENT_DATA_KEY
import com.view.R
import com.view.ui.auth.AuthActivity
import com.view.ui.auth.register.configurator.RegistrationFragmentAction
import kotlinx.android.synthetic.main.fragment_ragistration.*
import java.util.*
import javax.inject.Inject


class RegistrationFragment : RegistrationFragmentContract.RegistrationFragment() {

    companion object {
        fun createNewInstance(): RegistrationFragment {
            return RegistrationFragment()
        }

        fun addInitialAction(fragment: Fragment, initialAction: RegistrationFragmentAction) {
            val args = Bundle()
            args.putSerializable(FRAGMENT_DATA_KEY, initialAction)
            fragment.arguments = args
        }
    }

    @Inject
    lateinit var mPresenter: RegistrationFragmentPresenter
    private lateinit var datePickerDialog: DatePickerDialog

    override fun inject() {
        daggerController.registrationFragmentSubComponent?.inject(this)
    }

    override fun addCurrentSubComponent() {
        daggerController.addRegistrationFragmentSubComponent()
    }

    override fun removeCurrentSubComponent() {
        daggerController.removeRegistrationFragmentSubComponent()
    }

    override val layoutId: Int
        get() = R.layout.fragment_ragistration

    override fun initView() {
        super.initView()
        initEtBirthday()
        initEtRepeatPassword()
        initRegisterButton()
    }

    override val presenter: RegistrationFragmentPresenter
        get() {
            return mPresenter
        }

    override fun sendAction(action: RegistrationFragmentAction?) {
        mPresenter.consumeAction(action)
    }

    override fun getViewData(): RegistrationFragmentContract.RegistrationFragmentDto {
        return RegistrationFragmentContract.RegistrationFragmentDto(
                RegistrationFragmentContract.RegistrationInfo("", ""), true)
    }

    override fun goToEventsFragment() {
        (activity as AuthActivity).goToMainActivityEventListFragment()
    }

    private fun initEtRepeatPassword() {
        mEtRepeatPassword.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                sendAction(RegistrationFragmentAction.REGISTER)
            }
            false
        }
    }

    private fun initEtBirthday() {
        val calendar = Calendar.getInstance()

        datePickerDialog = DatePickerDialog(context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            mEtBirthday.setText(getString(R.string.view_date_format, dayOfMonth.toString(), (monthOfYear + 1).toString(), year.toString()))
            datePickerDialog.dismiss()
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
        mEtBirthday.setOnClickListener {
            datePickerDialog.show()
        }
    }

    private fun initRegisterButton() {
        mBtnRegister.setOnClickListener {
            sendAction(RegistrationFragmentAction.REGISTER)
        }
    }

}