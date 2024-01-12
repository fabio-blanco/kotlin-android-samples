package br.com.globalbyte.sample.and.modularizedsample.core.designsystem.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import br.com.globalbyte.sample.and.modularizedsample.core.designsystem.theme.ModularizedSampleTheme

@Composable
fun MSButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        content = content
    )
}

@Composable
fun MSDangerButton(
    onConfirm: () -> Unit,
    confirmationDialogText: String,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = {},
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    openAlertDialogState: MutableState<Boolean> = remember { mutableStateOf(false) },
    content: @Composable RowScope.() -> Unit,
) {

    Button(
        onClick = { openAlertDialogState.value = true },
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red
        ),
        contentPadding = contentPadding,
        content = content
    )

    when {
        openAlertDialogState.value -> {
            MSAlertDialog(
                onConfirmation = {
                    openAlertDialogState.value = false
                    onConfirm()
                },
                onDismissRequest = {
                    onDismiss()
                    openAlertDialogState.value = false
                },
                dialogText = confirmationDialogText
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MSButtonPreview() {
    ModularizedSampleTheme {
        MSButton(
            onClick = {}
        ) {
            Text(text = "Do something")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MSDangerButtonPreview() {
    ModularizedSampleTheme {
        MSDangerButton(
            onConfirm = {},
            onDismiss = {},
            confirmationDialogText = ""
        ) {
            Text(text = "Do something dangerous")
        }
    }
}