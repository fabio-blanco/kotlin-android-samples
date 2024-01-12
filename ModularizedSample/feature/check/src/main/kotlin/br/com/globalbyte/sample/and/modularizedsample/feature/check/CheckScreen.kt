package br.com.globalbyte.sample.and.modularizedsample.feature.check

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.globalbyte.sample.and.modularizedsample.core.designsystem.theme.ModularizedSampleTheme
import br.com.globalbyte.sample.and.modularizedsample.core.model.Note
import br.com.globalbyte.sample.and.modularizedsample.core.ui.TodoListing

@Composable
fun CheckScreen(
    title: String,
    modifier: Modifier = Modifier,
    viewModel: CheckViewModel = hiltViewModel()
) {

    val todoNotes = viewModel.todoNotes.collectAsState(initial = emptyList())

    CheckScreen(
        title = title,
        todoNotes = todoNotes.value,
        onTodoChange = { changedTodoNote ->
            viewModel.saveTodoNote(changedTodoNote)
        },
        modifier = modifier
    )
}

@Composable
fun CheckScreen(
    title: String,
    todoNotes: List<Note>,
    onTodoChange: (Note) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            modifier = modifier
        )

        TodoListing(todoNotes, onTodoChange)
    }
}

@Preview(showBackground = true)
@Composable
private fun CheckScreenPreview() {

    val todoNotes = listOf(
        Note(1, "note 1", todo = true),
        Note(2, "note 2", todo = true, done = true),
        Note(3, "note 3", todo = true),
    )

    ModularizedSampleTheme {
        CheckScreen(
            title = "Check Note",
            todoNotes = todoNotes,
            onTodoChange = {}
        )
    }
}