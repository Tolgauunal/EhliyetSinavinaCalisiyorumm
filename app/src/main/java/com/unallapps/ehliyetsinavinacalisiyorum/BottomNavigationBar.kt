package com.unallapps.ehliyetsinavinacalisiyorum

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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
        icon = R.drawable.test
    )
    object Profil: BottomBarScreen(
        route ="profil",
        label ="Profil",
        icon = R.drawable.baseline_person_24
    )
    object BilgiKartlari: BottomBarScreen(
        route ="bilgiKartlari/{konuAdi}",
        label ="BilgiKartlari",
        icon = R.drawable.baseline_person_24
    )
    object TestEkrani: BottomBarScreen(
        route ="testEkrani",
        label ="TestEkrani",
        icon = R.drawable.baseline_person_24
    )
    object KonuAnlatimi: BottomBarScreen(
        route ="konuAnlatimi",
        label ="KonuAnlatimi",
        icon = R.drawable.baseline_person_24
    )
}