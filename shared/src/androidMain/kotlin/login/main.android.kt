import androidx.compose.runtime.Composable
import login.view.App
import login.viewModel.LoginStore

actual fun getPlatformName(): String = "Android"


@Composable
fun MainView() = App()
