package com.unallapps.ehliyetsinavinacalisiyorum

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.unallapps.ehliyetsinavinacalisiyorum.bilgikartlari.BilgiKartlari
import com.unallapps.ehliyetsinavinacalisiyorum.home.Home
import com.unallapps.ehliyetsinavinacalisiyorum.konular.KonuAnlatim
import com.unallapps.ehliyetsinavinacalisiyorum.konular.Konular
import com.unallapps.ehliyetsinavinacalisiyorum.profil.Profil
import com.unallapps.ehliyetsinavinacalisiyorum.testler.TestEkrani
import com.unallapps.ehliyetsinavinacalisiyorum.testler.Testler

@Composable
fun BottomNavigationGraph(
    navController: NavHostController,
    paddingModifier: Modifier
) {
    paddingModifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.kapaliMavi))
        .padding(16.dp)
        .background(Color.LightGray)
    NavHost(navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route= BottomBarScreen.Home.route) {
            Home(paddingModifier,navController)
        }
        composable(route= BottomBarScreen.Konular.route) {
            Konular(paddingModifier,navController)
        }
        composable(route= BottomBarScreen.Testler.route) {
            Testler(paddingModifier,navController)
        }
        composable(route= BottomBarScreen.Profil.route) {
            Profil(paddingModifier)
        }
        composable(route= BottomBarScreen.BilgiKartlari.route) {
            BilgiKartlari(1,paddingModifier)
        }
        composable(route= BottomBarScreen.TestEkrani.route) {
            TestEkrani(1,paddingModifier)
        }
        composable(route= BottomBarScreen.KonuAnlatimi.route) {
            KonuAnlatim(1,paddingModifier)
        }
    }
}
