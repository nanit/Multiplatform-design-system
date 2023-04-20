package login.viewModel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.random.Random

class LoginStore() {

    val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    val state: StateFlow<LoginState> = flow {
        while (true) {
            emit(
                LoginState(
                    number = Random.nextInt(
                        0,
                        100
                    )
                )
            ) // Emits the result of the request to the flow
            delay(2000L) // Suspends the coroutine for some time
        }
    }.stateIn(scope, WhileSubscribed(), LoginState(0))

    fun login() = scope.launch {
//        repository.login("evgeni.roitburg+1@nanit", "n9582862").fold(
//            onSuccess = {
//                Napier.e("success")
//            }, onFailure = {
//                Napier.e("fail ${it.message}")
//            })
    }
}