package com.view.ui.modules.auth.register

import com.arellomobile.mvp.InjectViewState
import com.domain.usecase.net.registration.RegisterUserCase
import com.domain.usecase.prefs.user.SaveUserToSharedPrefsUseCase
import com.view.ui.modules.auth.register.configurator.RegistrationFragmentAction
import com.view.ui.modules.auth.register.configurator.RegistrationFragmentConfigurator
import com.view.ui.modules.auth.register.configurator.RegistrationFragmentViewCommand
import com.watchers.keepers.UserKeeper
import io.reactivex.Flowable
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class RegistrationPresenter : RegistrationFragmentContract.RegistrationPresenter() {

    @Inject
    protected lateinit var mRegistrationUserCase: RegisterUserCase
    @Inject
    protected lateinit var mSaveUserToSharedPrefsUseCase: SaveUserToSharedPrefsUseCase
    @Inject
    protected lateinit var mUserKeeper: UserKeeper

    private val mRegistrationFragmentState: RegistrationFragmentState = RegistrationFragmentState()

    override fun intiConfigurator(): RegistrationFragmentConfigurator {
        return RegistrationFragmentConfigurator()
    }

    override fun consumeActionAndData(action: RegistrationFragmentAction?,
                                      data: RegistrationFragmentContract.RegistrationFragmentDto?) {
        if (action != null) {
            when (actionConfigurator.produceViewCommand(mRegistrationFragmentState, action)) {
                RegistrationFragmentViewCommand.DEFAULT -> {
                    Timber.d("default message")
                }
                RegistrationFragmentViewCommand.REGISTER -> {
                    register()
                }
            }
        }
    }

    private fun register() {
        addDisposable(inBackground(Flowable.just("A").map { Thread.sleep(2000) }).subscribe {
            viewState.goToEventsFragment()
        })
//        val credentials = getView()?.getViewData()?.registrationInfo
//        val body: Map<String, String?> = hashMapOf(
//                "email" to credentials?.email,
//                "password" to credentials?.password)
//        addDisposable(
//                inBackground(mRegistrationUserCase.setParams(body).execute())
//                        .doOnNext { userDto: UserDto -> mUserKeeper.user = userDto }
//                        .flatMap { userDto: UserDto ->
//                            mSaveUserToSharedPrefsUseCase.setParams(
//                                    Pair(userDto.mUserName, userDto.mUserSecondName)).execute()
//                        }
//                        .subscribe(
//                                { getView()?.goToEventsFragment() },
//                                { DefaultErrorConsumer() })
//        )
    }

}