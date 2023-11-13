package br.com.globalbyte.sample.and.buymeadrink.ui.screens.donation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
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
import br.com.globalbyte.sample.and.buymeadrink.ui.theme.BuyMeADrinkTheme
import java.text.DecimalFormat
import java.util.Currency
import java.util.Locale

private const val URL_TAG = "url"

@Composable
fun DonationInstructionsScreen(
    modifier: Modifier = Modifier,
    drinkValue: String?
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val currency = Currency.getInstance(Locale.getDefault())
        val formattedValue = "${drinkValue ?: "0,00"} ${currency.currencyCode}"

        Text(text = stringResource(R.string.thank_you_you_have_chosen_to_donate, formattedValue))
        Text(text = stringResource(R.string.please_access_one_of_the_links_bellow_to_buy_me_a_drink))
        BuyMeADrinkLink(
            title = stringResource(R.string.buy_me_a_coffee),
            url = stringResource(R.string.buy_me_a_coffee_link)
        )
        BuyMeADrinkLink(
            title = stringResource(R.string.mercado_pago),
            url = stringResource(R.string.mercado_pago_link)
        )
        BuyMeADrinkLink(
            title = stringResource(R.string.pay_pal_donation),
            url = stringResource(R.string.pay_pal_donation_link)
        )

    }
}

@Composable
private fun BuyMeADrinkLink(
    modifier: Modifier = Modifier,
    title: String,
    url: String
) {
    val urlAnnotatedString = buildAnnotatedString {
        pushStringAnnotation(tag = URL_TAG, annotation = url)
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.primary)) {
            append(url)
        }
        pop()
    }

    Card(
        modifier = modifier.padding(top = 8.dp, bottom = 8.dp)
    ) {

        val mContext = LocalContext.current

        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            ClickableText(text = urlAnnotatedString, onClick = { offset ->
                urlAnnotatedString.getStringAnnotations(tag = URL_TAG, start = offset, end = offset)
                    .firstOrNull()?.let {
                        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        mContext.startActivity(browserIntent)
                    }
            })
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DonationInstructionsScreenPreview() {
    val symbols = DecimalFormat().decimalFormatSymbols
    val decimalSeparator = symbols.decimalSeparator

    BuyMeADrinkTheme {
        DonationInstructionsScreen(
            drinkValue = "10${decimalSeparator}00"
        )
    }
}