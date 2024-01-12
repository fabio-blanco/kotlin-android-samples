package br.com.globalbyte.sample.and.modularizedsample.feature.note

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.globalbyte.sample.and.modularizedsample.core.designsystem.component.MSButton
import br.com.globalbyte.sample.and.modularizedsample.core.designsystem.component.MSDangerButton
import br.com.globalbyte.sample.and.modularizedsample.core.designsystem.theme.ModularizedSampleTheme
import br.com.globalbyte.sample.and.modularizedsample.core.model.Note

@Composable
fun SaveNoteScreen(
    title: String,
    onCloseScreen: () -> Unit,
    modifier: Modifier = Modifier,
    editedNoteId: Long? = 0L,
    viewModel: NoteViewModel = hiltViewModel()
) {
    val editedNote = editedNoteId?.let { viewModel.getNoteById(it) }

    val noteId = editedNote?.id ?: 0L
    val description = editedNote?.description ?: ""
    val isTodo = editedNote?.todo ?: false
    val done = editedNote?.done ?: false

    SaveNoteScreen(
        title = title,
        modifier = modifier,
        onSaveNote = { note ->
            viewModel.saveNote(note)
            onCloseScreen()
        },
        onDeleteNote = { noteId ->
            viewModel.deleteNoteById(noteId)
            onCloseScreen()
        },
        initialNoteId = noteId,
        initialNoteDescription = description,
        initialNoteIsTodo = isTodo,
        initialNoteIsDone = done
    )
}


@Composable
fun SaveNoteScreen(
    title: String,
    onSaveNote: (note: Note) -> Unit,
    onDeleteNote: (noteId: Long) -> Unit,
    initialNoteId: Long,
    initialNoteDescription: String,
    initialNoteIsTodo: Boolean,
    initialNoteIsDone: Boolean,
    modifier: Modifier = Modifier
) {
    var noteDescription by rememberSaveable { mutableStateOf(initialNoteDescription) }
    var todo by rememberSaveable { mutableStateOf(initialNoteIsTodo) }

    Column(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
        )

        val textId = if (initialNoteId > 0) initialNoteId else "-"
        Text(text = "Id: $textId", Modifier.padding(bottom = 8.dp))
        TextField(
            value = noteDescription,
            onValueChange = {noteDescription = it},
            label = {
                Text(text = "Description")
            },
            minLines = 5,
            maxLines = 8,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .toggleable(
                    value = todo,
                    role = Role.Checkbox,
                    onValueChange = { todo = !todo }
                )
                .padding(vertical = 8.dp)
        ) {
            Text(text = "TODO", Modifier.padding(end = 8.dp))
            Checkbox(checked = todo, onCheckedChange = null)
        }

        Row {

            MSButton(onClick = {
                onSaveNote(
                    Note(
                        id = initialNoteId,
                        description = noteDescription,
                        todo = todo,
                        done = initialNoteIsDone
                    )
                )
            }) {
                Text(text = "Save")
            }

            if (initialNoteId > 0) {
                Spacer(modifier = modifier.weight(1f))

                MSDangerButton(
                    onConfirm = { onDeleteNote(initialNoteId) },
                    confirmationDialogText = "The note with id $initialNoteId will be deleted. Should proceed?"
                ) {
                    Text(text = "Delete")
                }
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
fun AddNotesScreenPreview() {
    ModularizedSampleTheme {
        SaveNoteScreen(
            title = "Add New Note",
            onSaveNote = {},
            onDeleteNote = {},
            initialNoteId = 0L,
            initialNoteDescription = "",
            initialNoteIsTodo = false,
            initialNoteIsDone = false
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SaveNotesScreenPreview() {
    ModularizedSampleTheme {
        SaveNoteScreen(
            title = "Update Note",
            onSaveNote = {},
            onDeleteNote = {},
            initialNoteId = 1L,
            initialNoteDescription = "A test note",
            initialNoteIsTodo = false,
            initialNoteIsDone = false
        )
    }
}