package br.com.globalbyte.sample.and.buymeadrink.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.globalbyte.sample.and.buymeadrink.R
import br.com.globalbyte.sample.and.buymeadrink.ui.components.CurrencyTextField
import br.com.globalbyte.sample.and.buymeadrink.ui.components.CurrencyVisualTransformation
import br.com.globalbyte.sample.and.buymeadrink.ui.components.with
import br.com.globalbyte.sample.and.buymeadrink.ui.theme.BuyMeADrinkTheme

@Composable
fun BuyMeADrinkComponent(
    modifier: Modifier = Modifier,
    onBuyMeADrinkClick: (String) -> Unit
) {
    var drinkValue by rememberSaveable {
        mutableStateOf("")
    }

    val currencyVisualTransformation = CurrencyVisualTransformation()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.buy_me_a_drink_explanation),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        CurrencyTextField(
            value = drinkValue,
            label = {
                Text(
                    text = stringResource(R.string.drink_value)
                )
            },
            onValueChange = {
                drinkValue = it
            },
            visualTransformation = currencyVisualTransformation,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {
                    val value = drinkValue.with(currencyVisualTransformation).formatCurrency()
                    onBuyMeADrinkClick(value)
                },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(
                    text = stringResource(R.string.buy_me_a_drink_button_label)
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun BuyMeADrinkComponentPreview() {
    BuyMeADrinkTheme {
        BuyMeADrinkComponent(
            onBuyMeADrinkClick = {}
        )
    }
}