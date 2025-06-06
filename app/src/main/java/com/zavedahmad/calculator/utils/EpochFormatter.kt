package com.zavedahmad.calculator.utils

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun epochFormatter(timestamp: Long): String{
    // Convert Long (milliseconds) to Instant
    val instant = Instant.ofEpochMilli(timestamp)
    // Convert to a zoned date/time (e.g., using device’s time zone)
    val zonedDateTime = instant.atZone(ZoneId.systemDefault())
    // Define a formatter for readable output
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    // Format to string
    return zonedDateTime.format(formatter)
}