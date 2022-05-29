package com.baha.arbuztestapp.ui.ui_extensions

import android.content.Context
import com.baha.arbuztestapp.R
import com.baha.arbuztestapp.model.Status
import com.baha.arbuztestapp.model.Watermelon

fun Watermelon.getUIStatus(context: Context): String {
    return when (status) {
        Status.Unripe -> context.getString(R.string.status_unripe)
        Status.Ripe -> context.getString(R.string.status_ripe)
        Status.Thwarted -> context.getString(R.string.status_thwarted)
        else -> context.getString(R.string.status_unripe)
    }
}