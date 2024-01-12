package br.com.globalbyte.sample.and.modularizedsample.feature.note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.globalbyte.sample.and.modularizedsample.core.data.repository.NotesRepository
import br.com.globalbyte.sample.and.modularizedsample.core.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NotesRepository
) : ViewModel() {

    val notes = repository.listNotes()

    fun saveNote(note: Note) {
        viewModelScope.launch {
            if (note.id > 0) {
                repository.updateNote(note)
            } else {
                repository.createNote(note)
            }
        }
    }

    fun getNoteById(noteId: Long): Note? = repository.getNoteById(noteId)

    fun deleteNoteById(noteId: Long) = repository.deleteNoteById(noteId)

}