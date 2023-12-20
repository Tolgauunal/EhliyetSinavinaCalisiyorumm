package com.unallapps.ehliyetsinavinacalisiyorum

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Home

sealed class BottomBarScreen(
    val route: String,
    val label: String,
    val icon: Int
) {
    object Home: BottomBarScreen(
        route ="home",
        label ="Home",
        icon = R.drawable.home
    )
    object Konular: BottomBarScreen(
        route ="konular",
        label ="Konular",
        icon = R.drawable.baseline_library_books_24
    )
    object Testler: BottomBarScreen(
        route ="testler",
        label ="Testler",
        icon = R.drawable.home
    )
    object Profil: BottomBarScreen(
        route ="profil",
        label ="Profil",
        icon = R.drawable.baseline_person_24
    )
    object BilgiKartlari: BottomBarScreen(
        route ="bilgiKartlari",
        label ="BilgiKartlari",
        icon = R.drawable.baseline_person_24
    )
}