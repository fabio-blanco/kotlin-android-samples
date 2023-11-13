package br.com.globalbyte.sample.and.buymeadrink.ui.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Path

//TODO: To implement a repository that calls GET https://api.github.com/users/fabio-blanco/repos
// place the repo data in a Room cache
private const val BASE_URL = "https://api.github.com/"

private const val GITHUB_USER = "fabio-blanco"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

private interface GitHubApiService {

    @GET("users/{user}/repos")
    suspend fun getRepositories(@Path("user") user: String): List<GitHubRepoRepresentation>
}

interface GitHubRepository {
    suspend fun getRepositories(): List<GitHubRepoRepresentation>
}

class GitHubRepositoryImpl: GitHubRepository {

    private object GitHubApi {
        val gitHubService: GitHubApiService by lazy {
            retrofit.create(GitHubApiService::class.java)
        }
    }

    override suspend fun getRepositories(): List<GitHubRepoRepresentation> = GitHubApi.gitHubService.getRepositories(GITHUB_USER)

}