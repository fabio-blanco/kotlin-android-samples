package br.com.globalbyte.sample.and.composebasicstatecodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.globalbyte.sample.and.composebasicstatecodelab.ui.components.WellnessScreen
import br.com.globalbyte.sample.and.composebasicstatecodelab.ui.theme.ComposeBasicStateCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicStateCodelabTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    WellnessScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WellnessScreenPreview() {
    ComposeBasicStateCodelabTheme {
        WellnessScreen()
    }
}