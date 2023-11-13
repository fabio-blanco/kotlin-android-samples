package br.com.globalbyte.sample.and.buymeadrink.ui.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun CurrencyTextField(
    value: String,
    label: @Composable (() -> Unit)?,
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation = CurrencyVisualTransformation(),
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        label = label,
        onValueChange = onValueChange,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        modifier = modifier
    )
}