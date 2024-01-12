package br.com.globalbyte.sample.and.modularizedsample.core.designsystem.component

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import br.com.globalbyte.sample.and.modularizedsample.core.designsystem.theme.ModularizedSampleTheme

@Composable
fun AddFabButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    iconContentDescription: String? = "Add Note"
) {
    AddFabButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(Icons.Default.Add, contentDescription = iconContentDescription)
    }
}

@Composable
fun AddFabButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    shape: Shape = CircleShape,
    content: @Composable () -> Unit
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        shape = shape,
        content = content
    )
}

@Preview(showBackground = true)
@Composable
fun AddFabButtonPreview() {
    ModularizedSampleTheme {
        AddFabButton(onClick = { })
    }
}