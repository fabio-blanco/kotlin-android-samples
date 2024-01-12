package br.com.globalbyte.sample.and.modularizedsample.feature.home

import androidx.lifecycle.ViewModel
import br.com.globalbyte.sample.and.modularizedsample.core.data.repository.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: NotesRepository
) : ViewModel() {

    val notes = repository.listNotesOnly()

    val todos = repository.listTodoNotes()

}