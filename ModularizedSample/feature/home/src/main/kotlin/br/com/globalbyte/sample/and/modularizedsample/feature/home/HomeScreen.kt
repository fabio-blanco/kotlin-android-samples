package br.com.globalbyte.sample.and.modularizedsample.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.globalbyte.sample.and.modularizedsample.core.designsystem.theme.ModularizedSampleTheme
import br.com.globalbyte.sample.and.modularizedsample.core.model.Note
import br.com.globalbyte.sample.and.modularizedsample.core.ui.TodoListing

@Composable
fun HomeScreen(
    title: String,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val notes = viewModel.notes.collectAsState(initial = emptyList())
    val todos = viewModel.todos.collectAsState(initial = emptyList())

    HomeScreen(
        title = title,
        notes = notes.value,
        todos = todos.value,
        modifier = modifier
    )
}

@Composable
fun HomeScreen(
    title: String,
    notes: List<Note>,
    todos: List<Note>,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        NotesSession(notes)

        TodosSession(todos, Modifier.padding(top = 4.dp))

    }

}

@Composable
fun NotesSession(
    notes: List<Note>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "> Notes",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        NotesListing(notes)
    }
}

@Composable
fun TodosSession(
    todos: List<Note>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "> TODOs",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        TodoListing(
            todoNotes = todos,
            enableToggleable = false
        )
    }
}

@Composable
fun NotesListing(
    notes: List<Note>,
    modifier: Modifier = Modifier
) {

    LazyColumn(modifier = modifier) {
        itemsIndexed(
            items = notes,
            key = { _, item -> item.id }
        ) { index, note ->

            Column {
                Text(note.description)

                if (index < notes.lastIndex)
                    Divider(modifier = Modifier.padding(vertical = 4.dp))
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {

    val notes = listOf(
        Note(1, "note 1"),
        Note(2, "note 2"),
        Note(3, "note 3"),
    )

    val todos = listOf(
        Note(3, "item 1", todo = true),
        Note(4, "item 2", todo = true, done = true),
        Note(5, "item 3", todo = true),
    )

    ModularizedSampleTheme {
        HomeScreen(
            title = "Home",
            notes = notes,
            todos = todos
        )
    }
}