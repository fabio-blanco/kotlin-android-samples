package br.com.globalbyte.sample.and.modularizedsample.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.globalbyte.sample.and.modularizedsample.core.designsystem.component.AddFabButton
import br.com.globalbyte.sample.and.modularizedsample.core.designsystem.component.MSNavigationBar
import br.com.globalbyte.sample.and.modularizedsample.core.designsystem.component.MsNavigationBarItem
import br.com.globalbyte.sample.and.modularizedsample.core.designsystem.theme.ModularizedSampleTheme
import br.com.globalbyte.sample.and.modularizedsample.navigation.Destination
import br.com.globalbyte.sample.and.modularizedsample.navigation.NavigationGraph

@Composable
fun MSApp() {
    val navController = rememberNavController()
    
    Scaffold(
        bottomBar = {
            MsBottomNavigationBar(
                navController = navController,
                destinations = listOf(
                    Destination.home,
                    Destination.note,
                    Destination.check
                )
            )
        },
        floatingActionButton = {
            if (navController.isCurrentDestination(destination = Destination.note)) {
                AddFabButton(onClick = { navController.navigate(Destination.createNote.route) })
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavigationGraph(navController = navController)
        }
    }
    
}

@Composable
fun MsBottomNavigationBar(
    navController: NavController,
    destinations: List<Destination>,
    modifier: Modifier = Modifier
) {

    MSNavigationBar(
        modifier = modifier
    ) {

        destinations.forEach { destination ->
            MsNavigationBarItem(
                selected = navController.isCurrentDestination(destination),
                onClick = {
                    navController.navigate(destination.route)
                },
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = null
                    )
                },
                label = { Text(destination.title) }
            )
        }

    }
}

@Composable
fun NavController.isCurrentDestination(destination: Destination) = currentBackStackEntryAsState().value?.destination
    ?.hierarchy?.any {
        it.route?.contains(destination.route) ?: false
    } ?: false

@Composable
fun getCurrentDestination(navController: NavController) = navController.currentBackStackEntryAsState().value?.destination

@Preview(showBackground = true)
@Composable
fun MsBottomNavigationBarPreview() {
    val navController = rememberNavController()

    ModularizedSampleTheme {
        MsBottomNavigationBar(
            navController = navController,
            destinations = listOf(
                Destination.home,
                Destination.note,
                Destination.check
            )
        )
    }
}