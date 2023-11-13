package br.com.globalbyte.sample.and.buymeadrink.ui.screens.mywork

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import br.com.globalbyte.sample.and.buymeadrink.BuyMeADrinkApplication
import br.com.globalbyte.sample.and.buymeadrink.ui.data.GitHubRepoRepresentation
import br.com.globalbyte.sample.and.buymeadrink.ui.data.GitHubRepository
import kotlinx.coroutines.launch

class MyWorkViewModel(private val gitHubRepository: GitHubRepository) : ViewModel() {

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repository = (this[APPLICATION_KEY] as BuyMeADrinkApplication).gitHubRepository
                MyWorkViewModel(repository)
            }
        }
    }

    private val _workList = MutableLiveData<List<GitHubRepoRepresentation>>()

    val workList: LiveData<List<GitHubRepoRepresentation>>
        get() = _workList

    fun fetchMyWorkList() {
        if (!_workList.isInitialized) { //fetch only once and maintain cache latter
            viewModelScope.launch {
                val gitHubRepositories = gitHubRepository.getRepositories()
                _workList.value = gitHubRepositories
            }
        }
    }

}