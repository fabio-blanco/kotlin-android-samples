package br.com.globalbyte.sample.and.buymeadrink.ui.data

import com.squareup.moshi.Json

data class GitHubRepoRepresentation(
    val id: Long,
    val name: String,
    @Json(name = "full_name")
    val fullName: String,
    val private: Boolean,
    @Json(name = "html_url")
    val htmlUrl: String,
    val description: String?,
    val fork: Boolean,
    @Json(name = "url")
    val apiUrl: String,
    @Json(name = "branches_url")
    val branchesUrl: String,
    @Json(name = "tags_url")
    val tagsUrl: String,
    val license: GitHubRepoLicense?
)

data class GitHubRepoLicense(
    val key: String,
    val name: String,
)