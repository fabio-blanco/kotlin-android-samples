package br.com.globalbyte.sample.and.modularizedsample.core.data.repository

import br.com.globalbyte.sample.and.modularizedsample.core.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class HardcodeDataNotesRepository @Inject constructor() : NotesRepository {

    internal companion object {
        private var lastId = 0L
        val HARDCODE_NOTES = mutableListOf(
            Note(
                ++lastId,
                "kotlin, ksp and androidxComposeCompiler versions must be sinchronized because they're intimatelly related",
            ),
            Note(
                ++lastId,
                "Plain JVM Modules contain code that doesn't depend on the Android environment",
            ),
            Note(
                ++lastId,
                "Create de main project",
                todo = true,
                done = true
            ),
            Note(
                ++lastId,
                "Create the build-logic inner project",
                todo = true,
                done = false
            ),
            Note(
                ++lastId,
                "Implement the configuration plugins",
                todo = true,
                done = false
            ),
            Note(
                ++lastId,
                "Create the desired modules",
                todo = true,
                done = false
            )
        )
    }

    private val _hardcodeNotesMutableFlow = MutableStateFlow(HARDCODE_NOTES)
    private val hardcodeNotesFlow = _hardcodeNotesMutableFlow.asStateFlow()

    override fun listNotes(): Flow<List<Note>> = hardcodeNotesFlow


    private val _hardcodeTodoMutableFlow = MutableStateFlow(HARDCODE_NOTES.filter { note -> note.todo })

    override fun listTodoNotes(): Flow<List<Note>> = _hardcodeTodoMutableFlow.asStateFlow()

    private val _hardcodeNotesOnlyMutableFlow = MutableStateFlow(HARDCODE_NOTES.filter { note -> !note.todo })

    override fun listNotesOnly(): Flow<List<Note>> = _hardcodeNotesOnlyMutableFlow.asStateFlow()

        override suspend fun createNote(note: Note): Note {
        val newNote = note.copy(id = ++lastId)
        HARDCODE_NOTES.add(newNote)

        updateFlows()
        
        return newNote
    }

    override suspend fun updateNote(note: Note) {
        val foundNote = HARDCODE_NOTES.firstOrNull { it.id == note.id }
        foundNote?.let {
            val index = HARDCODE_NOTES.indexOf(it)
            HARDCODE_NOTES[index] = note
            updateFlows()
        }
    }

    override fun getNoteById(noteId: Long): Note? = HARDCODE_NOTES.firstOrNull() { note -> note.id == noteId }

    override fun deleteNoteById(noteId: Long) {
        val foundNote = HARDCODE_NOTES.firstOrNull { it.id == noteId }
        foundNote?.let {
            val index = HARDCODE_NOTES.indexOf(it)
            HARDCODE_NOTES.removeAt(index)
            updateFlows()
        }
    }

    private fun updateFlows() {
        _hardcodeNotesMutableFlow.value = HARDCODE_NOTES
        _hardcodeTodoMutableFlow.value = HARDCODE_NOTES.filter { note -> note.todo }
        _hardcodeNotesOnlyMutableFlow.value = HARDCODE_NOTES.filter { note -> !note.todo }
    }
}