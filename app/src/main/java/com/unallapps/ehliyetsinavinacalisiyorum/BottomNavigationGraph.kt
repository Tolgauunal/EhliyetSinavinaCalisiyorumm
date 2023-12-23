package com.unallapps.ehliyetsinavinacalisiyorum

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.unallapps.ehliyetsinavinacalisiyorum.bilgikartlari.BilgiKartlari
import com.unallapps.ehliyetsinavinacalisiyorum.home.Home
import com.unallapps.ehliyetsinavinacalisiyorum.konular.Konular
import com.unallapps.ehliyetsinavinacalisiyorum.profil.Profil
import com.unallapps.ehliyetsinavinacalisiyorum.testler.Testler

@Composable
fun BottomNavigationGraph(
    navController: NavHostController,
    paddingModifier: Modifier
) {
    NavHost(navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route= BottomBarScreen.Home.route) {
            Home(paddingModifier)
        }
        composable(route= BottomBarScreen.Konular.route) {
            Konular(paddingModifier)
        }
        composable(route= BottomBarScreen.Testler.route) {
            Testler(paddingModifier)
        }
        composable(route= BottomBarScreen.Profil.route) {
            Profil(paddingModifier)
        }
        composable(route= BottomBarScreen.BilgiKartlari.route) {
            BilgiKartlari(1,paddingModifier)
        }
    }
}
