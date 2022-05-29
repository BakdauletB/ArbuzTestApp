package com.baha.arbuztestapp.model


data class Cell(
    val id: Int,
    val name: String,
    var watermelons: ArrayList<Watermelon> = arrayListOf()
)