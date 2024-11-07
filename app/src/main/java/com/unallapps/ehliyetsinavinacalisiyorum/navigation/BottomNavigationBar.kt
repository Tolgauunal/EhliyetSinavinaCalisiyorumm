package com.unallapps.ehliyetsinavinacalisiyorum.navigation

import com.unallapps.ehliyetsinavinacalisiyorum.R

sealed class BottomBarScreen(
    val route: String,
    val label: String,
    val icon: Int
) {
    object Home : BottomBarScreen(
        route = "home",
        label = "Home",
        icon = R.drawable.home
    )

    object Konular : BottomBarScreen(
        route = "konular",
        label = "Konular",
        icon = R.drawable.baseline_library_books_24
    )

    object Testler : BottomBarScreen(
        route = "testler",
        label = "Testler",
        icon = R.drawable.test
    )

    object Profil : BottomBarScreen(
        route = "profil",
        label = "Profil",
        icon = R.drawable.baseline_person_24
    )

    object BilgiKartlari : BottomBarScreen(
        route = "bilgiKartlari/{konuAdi}",
        label = "BilgiKartlari",
        icon = R.drawable.baseline_person_24
    )

    object TestEkrani : BottomBarScreen(
        route = "testEkrani/{dersAdi}/{restartOrContinue}",
        label = "TestEkrani",
        icon = R.drawable.baseline_person_24
    )

    object KonuAnlatimi : BottomBarScreen(
        route = "konuAnlatimi/{konuAdi}",
        label = "KonuAnlatimi",
        icon = R.drawable.baseline_person_24
    )
}