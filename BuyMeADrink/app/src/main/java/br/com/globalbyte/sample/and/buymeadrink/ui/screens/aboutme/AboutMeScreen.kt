package br.com.globalbyte.sample.and.buymeadrink.ui.screens.aboutme

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.globalbyte.sample.and.buymeadrink.R
import br.com.globalbyte.sample.and.buymeadrink.ui.Destination
import br.com.globalbyte.sample.and.buymeadrink.ui.theme.BuyMeADrinkTheme

private const val GITHUB_TAG = "github"

@Composable
fun AboutMeScreen(
    modifier: Modifier = Modifier
) {
    val githubProfileUrl = stringResource(R.string.github_profile_url)

    val urlAnnotatedString = buildAnnotatedString {
        append(stringResource(R.string.you_can_take_a_look_at_my))

        pushStringAnnotation(tag = GITHUB_TAG, annotation = githubProfileUrl)
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append(stringResource(R.string.github_profile))
        }
        pop()
    }

    val mContext = LocalContext.current

    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Text(
            text = Destination.ABOUT_ME.label,
            style = MaterialTheme.typography.headlineLarge
        )
        Text(text = stringResource(R.string.about_me_description))
        ClickableText(text = urlAnnotatedString, onClick = { offset ->
            urlAnnotatedString.getStringAnnotations(tag = GITHUB_TAG, start = offset, end = offset)
                .firstOrNull()?.let {
                    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(githubProfileUrl))
                    mContext.startActivity(browserIntent)
                }
        })
    }
}

@Preview
@Composable
private fun AboutMeScreenPreview() {
    BuyMeADrinkTheme {
        Surface {
            AboutMeScreen()
        }
    }
}