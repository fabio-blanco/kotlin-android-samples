package br.com.globalbyte.sample.and.buymeadrink.ui.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.globalbyte.sample.and.buymeadrink.R
import br.com.globalbyte.sample.and.buymeadrink.ui.Destination
import br.com.globalbyte.sample.and.buymeadrink.ui.theme.BuyMeADrinkTheme


@Composable
fun BuyMeADrinkDrawer(
    drawerState: DrawerState,
    navigateTo: (Destination) -> Unit,
    closeDrawer: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    ModalNavigationDrawer(
        drawerContent = {
            DrawerContent(navigateTo, closeDrawer)
        },
        drawerState = drawerState,
        modifier = modifier
    ) {
        content()
    }
}

@Composable
fun DrawerContent(
    navigateTo: (Destination) -> Unit,
    closeDrawer: () -> Unit,
) {
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    ModalDrawerSheet {
        Spacer(Modifier.height(16.dp))
        BuyMeADrinKLogo(Modifier.padding(16.dp))
        Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = .2f))
        Spacer(Modifier.height(8.dp))

        enumValues<Destination>().forEachIndexed { index, destination ->

            if (destination.showOnDrawer) {

                if (destination.divide) {
                    Spacer(Modifier.height(8.dp))
                    Divider(color = MaterialTheme.colorScheme.onSurface.copy(alpha = .2f))
                    Spacer(Modifier.height(8.dp))
                }
                NavigationDrawerItem(
                    label = { Text(text = destination.label) },
                    selected = index == selectedItemIndex,
                    onClick = {
                        selectedItemIndex = index
                        navigateTo(destination)
                        closeDrawer()
                    },
                    icon = {
                        if (destination.iconImage != null) {
                            Icon(
                                imageVector = destination.iconImage,
                                contentDescription = null
                            )
                        } else {
                            Icon(
                                painter = painterResource(id = destination.iconId!!),
                                contentDescription = null
                            )
                        }
                    },
                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                )
            }

        }
    }
}

@Composable
private fun BuyMeADrinKLogo(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.mug_and_coins_icon),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.buy_me_a_drink),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview
@Preview("Dark Mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun BuyMeADrinkDrawerPreview() {
    BuyMeADrinkTheme {
        Surface {
            //BuyMeADrinkDrawer("home", {}, {})
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Open)
            BuyMeADrinkDrawer(
                drawerState = drawerState,
                navigateTo = {},
                closeDrawer = {}) {

            }
        }
    }
}