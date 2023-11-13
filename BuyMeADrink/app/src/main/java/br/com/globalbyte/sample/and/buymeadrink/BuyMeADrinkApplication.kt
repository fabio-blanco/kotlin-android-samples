package br.com.globalbyte.sample.and.buymeadrink

import android.app.Application
import br.com.globalbyte.sample.and.buymeadrink.ui.data.GitHubRepository
import br.com.globalbyte.sample.and.buymeadrink.ui.data.GitHubRepositoryImpl

class BuyMeADrinkApplication: Application() {

    val gitHubRepository: GitHubRepository = GitHubRepositoryImpl()

}