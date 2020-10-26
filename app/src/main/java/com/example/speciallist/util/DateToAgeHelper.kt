package com.example.speciallist.util

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*
import kotlin.math.floor

fun dateToAge(date: String?): Long? {
    var age: Long? = null
    if (date != null && date.isNotEmpty()) {
        age = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            var formatter: DateTimeFormatter
            var birth: LocalDate
            try {
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                birth = LocalDate.parse(date, formatter)
            } catch (e: Exception) {
                formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
                birth = LocalDate.parse(date, formatter)
            }
            val currentDate = LocalDate.now()
            ChronoUnit.YEARS.between(birth, currentDate)
        } else {
            var birth: Date = if (date[4].toString() == "-") {
                SimpleDateFormat("yyyy-MM-dd").parse(date)
            } else {
                SimpleDateFormat("dd-MM-yyyy").parse(date)
            }
            val currentDate = Date()
            val yearsBetween = (currentDate.time - birth.time) / 3.15576e+10
            floor(yearsBetween).toLong()
        }
    }
    return age
}