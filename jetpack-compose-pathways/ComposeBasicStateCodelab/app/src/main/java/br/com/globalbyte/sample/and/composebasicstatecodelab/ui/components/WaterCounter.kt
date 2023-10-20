package br.com.globalbyte.sample.and.composebasicstatecodelab.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.globalbyte.sample.and.composebasicstatecodelab.ui.theme.ComposeBasicStateCodelabTheme

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }

    StatelessCounter(count, { count++ },modifier)
}

@Composable
private fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.padding(16.dp)) {
        if (count > 0) {
            Text(text = "You've had $count glasses.")
        }
        Button(
            onClick = onIncrement,
            modifier = Modifier.padding(top = 8.dp),
            enabled = count < 10
        ) {
            Text(text = "Add one")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WaterCounterPreview() {
    ComposeBasicStateCodelabTheme {
        WaterCounter()
    }
}

@Preview(showBackground = true)
@Composable
private fun StatelessCounterPreview() {
    ComposeBasicStateCodelabTheme {
        StatelessCounter(1, {})
    }
}