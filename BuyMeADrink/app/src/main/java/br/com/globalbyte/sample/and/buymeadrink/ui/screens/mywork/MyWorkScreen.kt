package br.com.globalbyte.sample.and.buymeadrink.ui.screens.mywork

import android.content.Intent
import android.net.Uri
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.globalbyte.sample.and.buymeadrink.R
import br.com.globalbyte.sample.and.buymeadrink.ui.data.GitHubRepoLicense
import br.com.globalbyte.sample.and.buymeadrink.ui.data.GitHubRepoRepresentation
import br.com.globalbyte.sample.and.buymeadrink.ui.theme.BuyMeADrinkTheme

private const val REPO_URL_TAG = "repoUrl"

@Composable
fun MyWorkScreen(
    modifier: Modifier = Modifier,
    myWorkViewModel: MyWorkViewModel = viewModel(factory = MyWorkViewModel.Factory)
) {
    val myWorkList = myWorkViewModel.workList.observeAsState()

    LaunchedEffect(key1 = Unit) {
        myWorkViewModel.fetchMyWorkList()
    }

    MyWorkScreenContent(
        modifier = modifier.padding(16.dp),
        myWorkList = myWorkList.value ?: emptyList()
    )

}

@Composable
private fun MyWorkScreenContent(
    modifier: Modifier = Modifier,
    myWorkList: List<GitHubRepoRepresentation>
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.my_work),
            style = MaterialTheme.typography.titleLarge,

        )
        MyWorkList(myWorkList = myWorkList)
    }
}

@Composable
private fun MyWorkList(
    modifier: Modifier = Modifier,
    myWorkList: List<GitHubRepoRepresentation>,
    listState: LazyListState = rememberLazyListState()
) {
    LazyColumn(
        state = listState,
        modifier = modifier
    ) {
        items(items = myWorkList, key = { item -> item.id }) {workItem ->
            Spacer(modifier = Modifier.padding(8.dp))
            MyWorkItem(
                workRepository = workItem
            )
        }
    }
}

@Composable
private fun MyWorkItem(
    modifier: Modifier = Modifier,
    workRepository: GitHubRepoRepresentation
) {
    val license = workRepository.license

    Card(modifier = modifier) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            ItemProperty(R.string.repo_name, workRepository.name)
            ItemProperty(R.string.repo_description, workRepository?.description ?: "-")
            MyWorkRepoUrlItemProperty(repoUrl = workRepository.htmlUrl)
            if (license != null) {
                ItemProperty(R.string.repo_license, license.key, license.name)
            } else {
                ItemProperty(R.string.repo_license, stringResource(R.string.no_explicit_license))
            }
        }
    }
}

@Composable
private fun ItemProperty(
    @StringRes nameStringId: Int,
    vararg arguments: String,
    modifier: Modifier = Modifier
) {
    val propertyName = stringResource(nameStringId)

    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("$propertyName: ")
        }

        arguments.forEachIndexed { i, argument ->
            if (arguments.size == 2 && i < (arguments.size - 1)) {
                append("$argument - ")
            } else {
                append(argument)
            }
        }
    }

    Text(
        modifier = modifier,
        text = annotatedString
    )

}

@Composable
private fun MyWorkRepoUrlItemProperty(
    modifier: Modifier = Modifier,
    repoUrl: String
) {
    val repoUrlPropertyName = stringResource(id = R.string.repo_url)
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append("$repoUrlPropertyName: ")
        }

        pushStringAnnotation(tag = REPO_URL_TAG, annotation = repoUrl)
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append(repoUrl)
        }
        pop()
    }

    val mContext = LocalContext.current

    ClickableText(
        modifier = modifier,
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(tag = REPO_URL_TAG, start = offset, end = offset)
                .firstOrNull()?.let {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(repoUrl))
                    mContext.startActivity(browserIntent)
                }
        }
    )
}


@Preview
@Composable
private fun MyWorkScreenContentPreview() {
    val myWorkList = listOf(
        GitHubRepoRepresentation(
            id = 1,
            name = "great-repository",
            fullName = "fabio-blanco/great-repository",
            private = false,
            htmlUrl = "https://github.com/fabio-blanco/great-repository",
            description = "A great repository that is jut a... test",
            fork = false,
            apiUrl = "https://api.github.com/repos/fabio-blanco/great-repository",
            branchesUrl = "https://api.github.com/repos/fabio-blanco/great-repository/branches{/branch}",
            tagsUrl = "https://api.github.com/repos/fabio-blanco/great-repository/tags",
            license = GitHubRepoLicense(
                key = "mit",
                name = "MIT License"
            )
        ),
        GitHubRepoRepresentation(
            id = 2,
            name = "another-repository",
            fullName = "fabio-blanco/another-repository",
            private = false,
            htmlUrl = "https://github.com/fabio-blanco/another-repository",
            description = null,
            fork = false,
            apiUrl = "https://api.github.com/repos/fabio-blanco/another-repository",
            branchesUrl = "https://api.github.com/repos/fabio-blanco/another-repository/branches{/branch}",
            tagsUrl = "https://api.github.com/repos/fabio-blanco/another-repository/tags",
            license = null
        )
    )

    BuyMeADrinkTheme {
        Surface {
            MyWorkScreenContent(
                modifier = Modifier.padding(16.dp),
                myWorkList = myWorkList
            )
        }
    }
}