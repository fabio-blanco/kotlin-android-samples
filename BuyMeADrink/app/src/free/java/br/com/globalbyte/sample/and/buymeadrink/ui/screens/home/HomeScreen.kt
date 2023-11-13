package br.com.globalbyte.sample.and.buymeadrink.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.globalbyte.sample.and.buymeadrink.ui.theme.BuyMeADrinkTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onBuyMeADrinkClick: (String) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        BuyMeADrinkComponent(
            onBuyMeADrinkClick = onBuyMeADrinkClick,
            modifier = Modifier.weight(1f)
        )
        BannerSimulacrum(
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun BannerSimulacrum(
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Card(
            shape = RectangleShape,
            modifier = Modifier.size(width = 320.dp, height =50.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.Red
            )
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Here we have a 320x50 banner!",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
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