package br.com.globalbyte.sample.and.modularizedsample.core.designsystem.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun MSAlertDialog(
    onConfirmation: () -> Unit,
    onDismissRequest: () -> Unit,
    dialogTitle: String = "Warning",
    dialogText: String,
    confirmButtonTitle: String = "Confirm",
    dismissButtonTitle: String = "Dismiss",
    icon: ImageVector = Icons.Default.Warning,
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "[$dialogTitle] dialog Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(confirmButtonTitle)
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text(dismissButtonTitle)
            }
        }
    )
}

