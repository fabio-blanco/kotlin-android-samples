package br.com.globalbyte.sample.and.multiplefab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.globalbyte.sample.and.multiplefab.ui.components.InnerFab
import br.com.globalbyte.sample.and.multiplefab.ui.components.ModalFabBackground
import br.com.globalbyte.sample.and.multiplefab.ui.components.MultiFloatingActionButton
import br.com.globalbyte.sample.and.multiplefab.ui.components.listOfInnerFab
import br.com.globalbyte.sample.and.multiplefab.ui.components.rememberMFabState
import br.com.globalbyte.sample.and.multiplefab.ui.theme.MultipleFabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultipleFabTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MultipleFabApp()
                }
            }
        }
    }
}

@Composable
fun MultipleFabApp(modifier: Modifier = Modifier) {
    var mFabStateChanges by remember { mutableIntStateOf(0) }
    var homePresses by remember { mutableIntStateOf(0) }
    var infoPresses by remember { mutableIntStateOf(0) }
    var buttonPress by remember { mutableIntStateOf(0) }

    val mFabState = rememberMFabState()

    Scaffold(
        floatingActionButton = {
            MultiFloatingActionButton(
                onStateChanged = { mFabStateChanges++ },
                items = listOfInnerFab(
                    InnerFab({ Icon(Icons.Default.Home, contentDescription = "Home") }, { homePresses++ }),
                    InnerFab({ Icon(Icons.Default.Info, contentDescription = "Info") }, { infoPresses++ }),
                ),
                mFabState = mFabState
            )
        }
    ) { innerPadding ->

        Column(
            modifier = modifier.padding(innerPadding)
        ) {
            Text(
                text = "Multiple Floating Action Button:",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(text = "MFab state changed $mFabStateChanges times")
            Text(text = "Home inner Fab pressed $homePresses times")
            Text(text = "Info inner Fab pressed $infoPresses times")
            Button(onClick = { buttonPress++ }) {
                Text(text = "Clicked $buttonPress times")
            }
        }

        ModalFabBackground(mFabState = mFabState)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MultipleFabTheme {
        MultipleFabApp()
    }
}