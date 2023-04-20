package login.viewModel

import nanit.mobile.core_arch.redux.ActionKt

sealed class LoginAction : ActionKt {
    class Login(val name: String, password: String): LoginAction()
}
