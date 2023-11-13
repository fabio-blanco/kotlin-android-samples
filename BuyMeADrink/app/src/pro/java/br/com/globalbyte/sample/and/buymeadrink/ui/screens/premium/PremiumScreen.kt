package br.com.globalbyte.sample.and.buymeadrink.ui.screens.premium

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.globalbyte.sample.and.buymeadrink.R
import br.com.globalbyte.sample.and.buymeadrink.ui.theme.BuyMeADrinkTheme

@Composable
fun PremiumScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier.padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.premium_feature),
            style = MaterialTheme.typography.headlineLarge
        )
        Text(text = stringResource(R.string.premium_feature_description))
    }
}

@Preview
@Composable
private fun PremiumScreenPreview() {
    BuyMeADrinkTheme {
        Surface {
            PremiumScreen()
        }
    }
}