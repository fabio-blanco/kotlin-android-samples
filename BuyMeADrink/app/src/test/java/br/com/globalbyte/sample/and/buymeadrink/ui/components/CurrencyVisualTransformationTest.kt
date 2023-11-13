package br.com.globalbyte.sample.and.buymeadrink.ui.components

import androidx.compose.ui.text.buildAnnotatedString
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.text.DecimalFormat
import kotlin.properties.Delegates

class CurrencyVisualTransformationTest {

    private var thousandsSeparator by Delegates.notNull<Char>()
    private var decimalSeparator by Delegates.notNull<Char>()
    private var zero by Delegates.notNull<Char>()

    private val transformation = CurrencyVisualTransformation()

    @Before
    fun setUp() {
        val symbols = DecimalFormat().decimalFormatSymbols
        thousandsSeparator = symbols.groupingSeparator
        decimalSeparator = symbols.decimalSeparator
        zero = symbols.zeroDigit
    }

    @Test
    fun `When input is empty string then it should succeed`() {

        val inputText = buildAnnotatedString {
            append("")
        }

        val result = transformation.filter(inputText)

        assertEquals("0${decimalSeparator}00", result.text.text)
    }

    @Test
    fun `When input is zero string then it should succeed`() {

        val inputText = buildAnnotatedString {
            append("0")
        }

        val result = transformation.filter(inputText)

        assertEquals("0${decimalSeparator}00", result.text.text)
    }

    @Test
    fun `When filtering less decimal than configured digits then it should succeed`() {

        val inputText = buildAnnotatedString {
            append("0${decimalSeparator}1")
        }

        val result = transformation.filter(inputText)

        //assertEquals("0${decimalSeparator}10", result.text.text)
        assertEquals("0${decimalSeparator}01", result.text.text)
    }

    @Test
    fun `When input is a big number then it should succeed`() {

        val inputText = buildAnnotatedString {
            append("159753208")
        }

        val result = transformation.filter(inputText)

        assertEquals("1${thousandsSeparator}597${thousandsSeparator}532${decimalSeparator}08", result.text.text)
    }

    @Test
    fun `When input is completely formed then it should succeed`() {

        val inputText = buildAnnotatedString {
            append("1597532${decimalSeparator}08")
        }

        val result = transformation.filter(inputText)

        assertEquals("1${thousandsSeparator}597${thousandsSeparator}532${decimalSeparator}08", result.text.text)
    }

    @Test
    fun `When input has more decimals than configured then it should succeed`() {

        val inputText = buildAnnotatedString {
            append("1597532${decimalSeparator}081")
        }

        val result = transformation.filter(inputText)

        assertEquals("15${thousandsSeparator}975${thousandsSeparator}320${decimalSeparator}81", result.text.text)
    }

}