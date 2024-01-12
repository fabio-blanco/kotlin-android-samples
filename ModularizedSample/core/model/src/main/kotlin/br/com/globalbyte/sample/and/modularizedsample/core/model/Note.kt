package br.com.globalbyte.sample.and.modularizedsample.core.model

data class Note(
    val id: Long,
    val description: String,
    val done: Boolean = false,
    val todo: Boolean = false,
)
