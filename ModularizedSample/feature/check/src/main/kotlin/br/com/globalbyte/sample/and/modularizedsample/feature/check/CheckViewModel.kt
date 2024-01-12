package br.com.globalbyte.sample.and.modularizedsample.feature.check

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.globalbyte.sample.and.modularizedsample.core.data.repository.NotesRepository
import br.com.globalbyte.sample.and.modularizedsample.core.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckViewModel @Inject constructor(
    private val repository: NotesRepository
) : ViewModel() {

    val todoNotes = repository.listTodoNotes()

    fun saveTodoNote(note: Note) {
        viewModelScope.launch {
            if (note.id > 0) {
                repository.updateNote(note)
            } else {
                repository.createNote(note)
            }
        }
    }

}