package br.com.globalbyte.sample.and.buymeadrink.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import br.com.globalbyte.sample.and.buymeadrink.R

enum class Destination(
    val label: String,
    val route: String,
    val iconImage: ImageVector? = null,
    val iconId: Int? = null,
    val divide: Boolean = false,
    val showOnDrawer: Boolean = true,
    val argumentName: String = ""
) {
    HOME(
        label = "Home",
        route = "home",
        iconImage = Icons.Filled.Home
    ),
    MY_WORK(
        label = "My Work",
        route = "my-work",
        iconImage = null,
        iconId = R.drawable.work_svgrepo_com
    ),
    ABOUT_ME(
        label = "About me",
        route = "about-me",
        iconImage = Icons.Filled.Info,
        iconId = null,
        divide = true
    ),
    DONATION_INSTRUCTIONS(
        label = "Donation Instructions",
        route = "donation-instructions",
        iconImage = null,
        iconId = null,
        divide = false,
        showOnDrawer = false,
        argumentName = "drink_value"
    );

    val routeWithArgs = "${route}/{${argumentName}}"
    val arguments = listOf(
        navArgument(argumentName) { type = NavType.StringType }
    )
}