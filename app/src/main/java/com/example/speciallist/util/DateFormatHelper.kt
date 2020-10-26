package com.example.speciallist.util

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun dateFormatter(date: String?): String? {
    var formattedDate : String?=null
    if(date!=null && date.isNotEmpty()){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            var formatter: DateTimeFormatter
            try {
                formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                val parseDate = LocalDate.parse(date,formatter)
                val format = DateTimeFormatter.ofPattern("dd.MM.yyyy")
                formattedDate = parseDate.format(format)
            }catch (e: Exception){
                formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
                val parseDate = LocalDate.parse(date,formatter)
                val format = DateTimeFormatter.ofPattern("dd.MM.yyyy")
                formattedDate = parseDate.format(format)
            }
        } else {
            var dateParse:Date
            if(date[4].toString() == "-"){
                dateParse = SimpleDateFormat("yyyy-MM-dd").parse(date)
                val format = SimpleDateFormat("dd.MM.yyyy")
                formattedDate = format.format(dateParse)
            }else{
                dateParse = SimpleDateFormat("dd-MM-yyyy").parse(date)
                val format = SimpleDateFormat("dd.MM.yyyy")
                formattedDate = format.format(dateParse)
            }
        }
    }
    return formattedDate
}
