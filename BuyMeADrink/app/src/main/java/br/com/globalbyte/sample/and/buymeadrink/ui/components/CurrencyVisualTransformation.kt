package br.com.globalbyte.sample.and.buymeadrink.ui.components

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import java.text.DecimalFormat

class CurrencyVisualTransformation(
    private val numberOfDecimals: Int = 2,
    private val fixedCursorAtTheEnd: Boolean = true
) : VisualTransformation {

    private val symbols = DecimalFormat().decimalFormatSymbols

    override fun filter(text: AnnotatedString): TransformedText {

        val inputText = text.text

        val formattedDecimal = formatCurrency(inputText)

        val newText = AnnotatedString(
            text = formattedDecimal,
            spanStyles = text.spanStyles,
            paragraphStyles = text.paragraphStyles
        )

        val offsetMapping = if (fixedCursorAtTheEnd) {
            FixedCursorOffsetMapping(
                contentLength = inputText.length,
                formattedContentLength = formattedDecimal.length
            )
        } else {
            MovableCursorOffsetMapping(
                originalText = text.toString(),
                newFormatText = newText.toString(),
                numDecimalDigits = numberOfDecimals
            )
        }

        return TransformedText(newText, offsetMapping)
    }

    fun formatCurrency(inputText: String): String {

        val decimalSeparator = symbols.decimalSeparator

        val (intPart, fractionPart) = breakParts(inputText)

        return intPart + decimalSeparator + fractionPart

    }

    private fun breakParts(inputText: String): Pair<String, String> {
        val thousandsSeparator = symbols.groupingSeparator
        val zero = symbols.zeroDigit
        val minDigits = (numberOfDecimals + 1)

        val inputNumbers = inputText.filter { it.isDigit() }.let {
            if (it.length < minDigits) {
                List(minDigits - it.length) {
                    zero
                }.joinToString("") + it
            } else {
                it
            }
        }

        val intPart = inputNumbers
            .dropLast(numberOfDecimals)
            .reversed()
            .chunked(3)
            .joinToString(thousandsSeparator.toString())
            .reversed()
            .ifEmpty {
                zero.toString()
            }

        val fractionPart = inputNumbers.takeLast(numberOfDecimals)

        return Pair(intPart, fractionPart)
    }

    private class FixedCursorOffsetMapping(
        private val contentLength: Int,
        private val formattedContentLength: Int,
    ) : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int = formattedContentLength
        override fun transformedToOriginal(offset: Int): Int = contentLength
    }

    private class MovableCursorOffsetMapping(
        private val originalText: String,
        private val newFormatText: String,
        private val numDecimalDigits: Int
    ) : OffsetMapping {

        override fun originalToTransformed(offset: Int): Int =
            if (originalText.length <= numDecimalDigits) {
                newFormatText.length - (originalText.length - offset)
            }else {
                offset + nonDigitCount(offset, newFormatText)
            }

        override fun transformedToOriginal(offset: Int): Int =
            if (originalText.length <= numDecimalDigits) {
                Integer.max(originalText.length - (newFormatText.length - offset), 0)
            } else {
                offset - newFormatText.take(offset).count { !it.isDigit() }
            }

        private fun nonDigitCount(offset: Int, newFormatText: String): Int {
            var nonDigitCount = 0
            var digitCount = 0
            for (newFormatChar in newFormatText) {
                if (!newFormatChar.isDigit()) {
                    nonDigitCount++
                } else if (++digitCount > offset) {
                    break
                }
            }
            return nonDigitCount
        }
    }

}

interface CurrencyFormatter {
    fun formatCurrency(): String
}

fun String.with(transformation: CurrencyVisualTransformation): CurrencyFormatter {

    val stringValue = this

    return object : CurrencyFormatter {

        override fun formatCurrency(): String = transformation.formatCurrency(stringValue)

    }
}