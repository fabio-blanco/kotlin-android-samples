package br.com.globalbyte.sample.and.buymeadrink.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import br.com.globalbyte.sample.and.buymeadrink.ui.screens.home.BuyMeADrinkDrawer
import br.com.globalbyte.sample.and.buymeadrink.ui.screens.home.BuyMeADrinkTopAppBar
import br.com.globalbyte.sample.and.buymeadrink.ui.theme.BuyMeADrinkTheme
import kotlinx.coroutines.launch

@Composable
fun BuyMeADrinkApp() {
    BuyMeADrinkTheme {
        val coroutineScope = rememberCoroutineScope()
        val navController = rememberNavController()

        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

        BuyMeADrinkDrawer(
            drawerState = drawerState,
            navigateTo = { destination -> navController.navigate(destination.route) },
            closeDrawer = {
                coroutineScope.launch {
                    drawerState.close()
                }
            }
        ) {
            Scaffold(
                topBar = {
                    BuyMeADrinkTopAppBar(
                        openDrawer = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }
                    )
                }
            ) { innerPadding ->
                BuyMeADrinkNavHost(
                    navController = navController,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Preview
@Preview(name = "Dark Mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun BuyMeADrinkAppPreview() {
    BuyMeADrinkApp()
}