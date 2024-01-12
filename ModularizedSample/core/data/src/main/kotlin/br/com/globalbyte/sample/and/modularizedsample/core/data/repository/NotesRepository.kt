package br.com.globalbyte.sample.and.modularizedsample.core.data.repository

import br.com.globalbyte.sample.and.modularizedsample.core.model.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {

    fun listNotes(): Flow<List<Note>>

    fun listTodoNotes(): Flow<List<Note>>

    fun listNotesOnly(): Flow<List<Note>>

    suspend fun createNote(note: Note): Note

    suspend fun updateNote(note: Note)

    fun getNoteById(noteId: Long): Note?
    fun deleteNoteById(noteId: Long)
}