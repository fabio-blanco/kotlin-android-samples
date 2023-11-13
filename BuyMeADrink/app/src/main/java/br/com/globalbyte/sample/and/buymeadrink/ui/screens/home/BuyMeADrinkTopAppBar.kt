package br.com.globalbyte.sample.and.buymeadrink.ui.screens.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.globalbyte.sample.and.buymeadrink.R
import br.com.globalbyte.sample.and.buymeadrink.ui.theme.BuyMeADrinkTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyMeADrinkTopAppBar(
    openDrawer: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.buy_me_a_drink)) },
        navigationIcon = {
            IconButton(onClick = {
                openDrawer()
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(R.string.menu)
                )
            }
        },
        modifier = modifier
    )
}

@Preview
@Composable
private fun BuyMeADrinkTopAppBarPreview() {
    BuyMeADrinkTheme {
        BuyMeADrinkTopAppBar({})
    }
}