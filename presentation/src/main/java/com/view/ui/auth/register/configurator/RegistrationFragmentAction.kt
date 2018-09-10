package com.view.ui.auth.register.configurator


enum class RegistrationFragmentAction(action: Int, areParamsRequired: Boolean = false) {
    INITIAL_ACTION_DEFAULT(action = 0);

    internal val mAction: Int = action
    internal val mAreParamsRequired = areParamsRequired

    companion object {
        private val map = RegistrationFragmentAction.values()
                .associateBy(RegistrationFragmentAction::mAction)

        fun getAction(command: Int) = map[command]
    }

}