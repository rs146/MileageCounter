package com.peregrine.mileagecounter.util

import org.junit.Assert.assertEquals
import org.junit.Test

class StringExtTest {

    @Test
    fun testUppercaseFirstLetter() {
        val day = "SUNDAY"
        val expected = "Sunday"
        val actual = day.uppercaseFirstLetter()
        assertEquals(expected, actual)
    }

    @Test
    fun testUppercaseFirstLetterWhenAllLowercase() {
        val day = "sunday"
        val expected = "Sunday"
        val actual = day.uppercaseFirstLetter()
        assertEquals(expected, actual)
    }

    @Test
    fun formatMonthJanuary() {
        val month = "JANUARY"
        val expected = "Jan"
        val actual = month.formatMonth()
        assertEquals(expected, actual)
    }

    @Test
    fun formatMonthFebruary() {
        val month = "FEBRUARY"
        val expected = "Feb"
        val actual = month.formatMonth()
        assertEquals(expected, actual)
    }

    @Test
    fun formatMonthSeptember() {
        val month = "September"
        val expected = "Sept"
        val actual = month.formatMonth()
        assertEquals(expected, actual)
    }
}