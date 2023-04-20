package login.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import getPlatformName
import io.github.aakira.napier.Napier
import kotlinx.coroutines.launch
import login.viewModel.LoginStore
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {

    val store: LoginStore = LoginStore()
    val state = store.state.collectAsState()

    Napier.e("state ${state.value.number}")

    MaterialTheme {
        var greetingText by remember { mutableStateOf("Hello, World!") }
        var showImage by remember { mutableStateOf(false) }
        var text by remember { mutableStateOf(TextFieldValue("")) }

        val scaffoldState = rememberScaffoldState()
        val coroutineScope = rememberCoroutineScope()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState,
            topBar = {
                Button(onClick = {
                    greetingText = "open drawer, ${getPlatformName()}"
                    coroutineScope.launch {
                        scaffoldState.drawerState.open()
                    }
                }) {
                    Text(greetingText)
                }
            },
            drawerContent = {
                Box(modifier = Modifier.background(color = Color.Red).fillMaxSize())
//                DrawerContent { itemLabel ->
//                    Toast
//                        .makeText(contextForToast, itemLabel, Toast.LENGTH_SHORT)
//                        .show()
//                    coroutineScope.launch {
//                        // delay for the ripple effect
//                        delay(timeMillis = 250)
//                        scaffoldState.drawerState.close()
//                    }
//                }
            }
        ) {
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

                TextField(
                    value = text,
                    onValueChange = { newText ->
                        text = newText
                    }
                )
                AnimatedVisibility(showImage) {
                    Image(
                        painterResource("compose-multiplatform.xml"),
                        null
                    )
                }
            }
        }
    }
}