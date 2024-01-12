package br.com.globalbyte.sample.and.modularizedsample.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.globalbyte.sample.and.modularizedsample.feature.check.CheckScreen
import br.com.globalbyte.sample.and.modularizedsample.feature.home.HomeScreen
import br.com.globalbyte.sample.and.modularizedsample.feature.note.NoteScreen
import br.com.globalbyte.sample.and.modularizedsample.feature.note.SaveNoteScreen

sealed class Destination(
    val title: String,
    val route: String,
    val icon: ImageVector
) {
    object home: Destination("Home", "home", Icons.Filled.Home)
    object note: Destination("Note", "note", Icons.Filled.Create)
    object check: Destination("Check Note", "check", Icons.Filled.CheckCircle)

    object createNote: Destination("Create Note", "create-note", Icons.Filled.Create)
    //object updateNote: Destination("Update Note", "update-note", Icons.Filled.Create)
    object updateNote: Destination("Update Note", "update-note", Icons.Filled.Create) {
        const val noteIdArg = "note_id"
        val routeWithArgs = "${route}/{${noteIdArg}}"
        val arguments = listOf(
            navArgument(noteIdArg) { type = NavType.LongType }
        )
    }
}

@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Destination.home.route,
        modifier = modifier
    ) {
        composable(Destination.home.route) {
            HomeScreen(title = Destination.home.title)
        }
        composable(Destination.note.route) {
            NoteScreen(
                title = Destination.note.title,
                onNoteClick = { noteId ->
                    navController.navigateToUpdateNoteScreen(noteId)
                }
            )
        }
        composable(Destination.check.route) {
            CheckScreen(title = Destination.check.title)
        }
        composable(Destination.createNote.route) {
            SaveNoteScreen(
                title = Destination.createNote.title,
                onCloseScreen = {
                    navController.navigate(Destination.note.route)
                }
            )
        }
        composable(
            route = Destination.updateNote.routeWithArgs,
            arguments = Destination.updateNote.arguments
        ) { navBackStackEntry ->
            val noteId = navBackStackEntry.arguments?.getLong(Destination.updateNote.noteIdArg)

            SaveNoteScreen(
                title = Destination.updateNote.title,
                onCloseScreen = {
                    navController.navigate(Destination.note.route)
                },
                editedNoteId = noteId
            )
        }
    }
}

private fun NavHostController.navigateToUpdateNoteScreen(noteId: Long) =
    this.navigate("${Destination.updateNote.route}/$noteId")