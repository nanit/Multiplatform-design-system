import androidx.compose.ui.window.ComposeUIViewController
import login.view.App

actual fun getPlatformName(): String = "iOS"

fun MainViewController() = ComposeUIViewController { App() }