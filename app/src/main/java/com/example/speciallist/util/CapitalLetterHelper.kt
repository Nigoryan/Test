package com.example.speciallist.util

fun capitalLetter(word: String?):String? {
    return if(word!=null && word.isNotEmpty())
        word.substring(0,1).toUpperCase()+word.substring(1).toLowerCase()
    else word
}