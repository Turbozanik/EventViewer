package com.view.ui.modules.auth.register

import android.app.DatePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.inputmethod.EditorInfo
import com.FRAGMENT_DATA_KEY
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.view.R
import com.view.ui.godlikeroot.RootGodlikeActivity
import com.view.ui.modules.auth.register.RegistrationFragmentContract.RegistrationFragmentDto
import com.view.ui.modules.auth.register.configurator.RegistrationFragmentAction
import kotlinx.android.synthetic.main.fragment_ragistration.*
import java.util.*


class RegistrationFragment : RegistrationFragmentContract.RegistrationFragment() {

    @InjectPresenter(type = PresenterType.LOCAL)
    lateinit var mPresenter: RegistrationPresenter
    val presenter: RegistrationPresenter get() = mPresenter

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
        initEtBirthday()
        initEtRepeatPassword()
        initRegisterButton()
    }

    override fun sendActionAndData(action: RegistrationFragmentAction?,
                                   data: RegistrationFragmentDto?) {
        presenter.consumeActionAndData(action, data)
    }

    override fun goToEventsFragment() {
        (activity as RootGodlikeActivity).goToAllEventsScreen(null)
    }

    private fun initEtRepeatPassword() {
        mEtRepeatPassword.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                sendActionAndData(
                        RegistrationFragmentAction.REGISTER, RegistrationFragmentDto(
                        RegistrationFragmentContract.RegistrationInfo(mEtName.text.toString(),
                                                                      mEtNickname.text.toString(),
                                                                      mEtEmail.text.toString(),
                                                                      mEtBirthday.text.toString(),
                                                                      mEtPassword.text.toString(),
                                                                      mEtPassword.text.toString()),
                        true))
            }
            false
        }
    }

    private fun initEtBirthday() {
        val calendar = Calendar.getInstance()

        datePickerDialog = DatePickerDialog(context,
                                            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                                                mEtBirthday.setText(
                                                        getString(R.string.view_date_format,
                                                                  dayOfMonth.toString(),
                                                                  (monthOfYear + 1).toString(),
                                                                  year.toString()))
                                                datePickerDialog.dismiss()
                                            }, calendar.get(Calendar.YEAR),
                                            calendar.get(Calendar.MONTH),
                                            calendar.get(Calendar.DAY_OF_MONTH))
        mEtBirthday.setOnClickListener {
            datePickerDialog.show()
        }
    }

    private fun initRegisterButton() {
        mBtnRegister.setOnClickListener {
            sendActionAndData(RegistrationFragmentAction.REGISTER, null)
        }
    }

    override fun updateToolbar() {
        (activity as RootGodlikeActivity).prepareRegistrationFragmentToolbar()
    }

    override fun handleInitialAction() {
        when (initialAction as RegistrationFragmentAction?) {
            RegistrationFragmentAction.INITIAL_ACTION_DEFAULT -> sendActionAndData(
                    RegistrationFragmentAction.INITIAL_ACTION_DEFAULT, null)
            else -> {
            }
        }
    }

}