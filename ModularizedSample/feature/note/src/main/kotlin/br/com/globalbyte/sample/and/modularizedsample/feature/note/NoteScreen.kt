package br.com.globalbyte.sample.and.modularizedsample.feature.note

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.globalbyte.sample.and.modularizedsample.core.designsystem.theme.ModularizedSampleTheme
import br.com.globalbyte.sample.and.modularizedsample.core.model.Note

@Composable
fun NoteScreen(
    title: String,
    onNoteClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: NoteViewModel = hiltViewModel()
) {
    val notes = viewModel.notes.collectAsState(initial = emptyList())

    NoteScreen(
        title = title,
        notes = notes.value,
        onNoteClick = onNoteClick,
        modifier = modifier
    )
}

@Composable
private fun NoteScreen(
    title: String,
    notes: List<Note>,
    onNoteClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
        )
        NotesListing(
            notes = notes,
            onNoteClick = onNoteClick
        )
    }

}

@Composable
private fun NotesListing(
    notes: List<Note>,
    modifier: Modifier = Modifier,
    onNoteClick: (Long) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(notes) { note ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable(
                        enabled = true,
                        onClick = {
                            onNoteClick(note.id)
                        }
                    )
            ) {
                Column {
                    Text(
                        text = note.description,
                        modifier = Modifier.padding(8.dp)
                    )
                    if (note.todo) {
                        TodoMarker()
                    }
                }
            }
        }
    }
}

@Composable
private fun TodoMarker(
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = "TODO",
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray.copy(alpha = 0.4f)
        )

        Icon(
            Icons.Filled.CheckCircle,
            contentDescription = null,
            tint = Color.Gray.copy(alpha = 0.4f),
            modifier = Modifier.size(12.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {

    val notes = listOf(
        Note(1, "note 1"),
        Note(2, "note 2", todo = true),
        Note(3, "note 3"),
    )

    ModularizedSampleTheme {
        NoteScreen(
            title = "Notes",
            notes = notes,
            onNoteClick = {}
        )
    }
}