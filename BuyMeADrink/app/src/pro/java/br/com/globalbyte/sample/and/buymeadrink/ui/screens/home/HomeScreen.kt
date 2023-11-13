package br.com.globalbyte.sample.and.buymeadrink.ui.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.globalbyte.sample.and.buymeadrink.ui.theme.BuyMeADrinkTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onBuyMeADrinkClick: (String) -> Unit
) {
    BuyMeADrinkComponent(
        onBuyMeADrinkClick = onBuyMeADrinkClick,
        modifier = modifier.fillMaxSize()
    )
}

@Preview
@Composable
private fun HomeScreenPreview() {
    BuyMeADrinkTheme {
        Surface {
            HomeScreen(onBuyMeADrinkClick = {})
        }
    }
}