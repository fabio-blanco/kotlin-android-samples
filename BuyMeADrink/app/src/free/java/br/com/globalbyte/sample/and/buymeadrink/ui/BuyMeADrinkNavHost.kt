package br.com.globalbyte.sample.and.buymeadrink.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.com.globalbyte.sample.and.buymeadrink.ui.screens.aboutme.AboutMeScreen
import br.com.globalbyte.sample.and.buymeadrink.ui.screens.donation.DonationInstructionsScreen
import br.com.globalbyte.sample.and.buymeadrink.ui.screens.home.HomeScreen
import br.com.globalbyte.sample.and.buymeadrink.ui.screens.mywork.MyWorkScreen

@Composable
fun BuyMeADrinkNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destination.HOME.route,
        modifier = modifier
    ) {
        composable(route = Destination.HOME.route) {
            HomeScreen(
                onBuyMeADrinkClick = { drinkValue ->
                    navController.navigateToDonationInstructions(drinkValue)
                }
            )
        }
        composable(route = Destination.MY_WORK.route) {
            MyWorkScreen()
        }
        composable(route = Destination.ABOUT_ME.route) {
            AboutMeScreen()
        }
        composable(
            route = Destination.DONATION_INSTRUCTIONS.routeWithArgs,
            arguments = Destination.DONATION_INSTRUCTIONS.arguments
        ) { navBackStackEntry ->
            val drinkValue = navBackStackEntry.arguments?.getString(Destination.DONATION_INSTRUCTIONS.argumentName)

            DonationInstructionsScreen(
                drinkValue = drinkValue
            )
        }
    }
}

private fun NavHostController.navigateToDonationInstructions(drinkValue: String) =
    this.navigate("${Destination.DONATION_INSTRUCTIONS.route}/$drinkValue")