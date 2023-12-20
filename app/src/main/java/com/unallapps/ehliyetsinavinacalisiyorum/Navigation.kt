package com.unallapps.ehliyetsinavinacalisiyorum

sealed class Navigation(
    val route: String,
    val label: String,
) {
    object BilgiKartlari: Navigation(
        route ="bilgiKartlari",
        label ="BilgiKartlari"
    )
}