package com.baha.arbuztestapp.support.extensions

import java.text.SimpleDateFormat
import java.util.*

fun formatDate(date: Date?): String? {
    if (date == null) return null
    val sdf = SimpleDateFormat("dd MMMM", Locale("ru", "RU"))
    return sdf.format(date)
}