package br.com.globalbyte.sample.and.modularizedsample.core.data.di

import br.com.globalbyte.sample.and.modularizedsample.core.data.repository.HardcodeDataNotesRepository
import br.com.globalbyte.sample.and.modularizedsample.core.data.repository.NotesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsNotesRepository(notesRepository: HardcodeDataNotesRepository): NotesRepository

}