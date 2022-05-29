package com.baha.arbuztestapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Watermelon(
    val id: Int,
    val status: Status,
    val weight: Int,
    var amount: Int = 0
): Parcelable {

}

@Parcelize
enum class Status: Parcelable {
    Thwarted, Ripe, Unripe
}