package com.unallapps.ehliyetsinavinacalisiyorum.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.ui.PdfViewer
import com.unallapps.ehliyetsinavinacalisiyorum.ui.bilgikartlari.BilgiKartlari
import com.unallapps.ehliyetsinavinacalisiyorum.ui.home.Home
import com.unallapps.ehliyetsinavinacalisiyorum.ui.konular.KonuAnlatim
import com.unallapps.ehliyetsinavinacalisiyorum.ui.konular.Konular
import com.unallapps.ehliyetsinavinacalisiyorum.ui.profil.Profile
import com.unallapps.ehliyetsinavinacalisiyorum.ui.testler.TestAdd
import com.unallapps.ehliyetsinavinacalisiyorum.ui.testler.TestEkrani
import com.unallapps.ehliyetsinavinacalisiyorum.ui.testler.Testler

@SuppressLint("NewApi")
@Composable
fun BottomNavigationGraph(navController: NavHostController, paddingModifier: Modifier) {
    paddingModifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.kapaliMavi))
        .padding(16.dp)
        .background(Color.LightGray)
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        composable(route = BottomBarScreen.Home.route) {
            Home(paddingModifier, navController)
        }
        composable(route = BottomBarScreen.TestAdd.route) {
            TestAdd(paddingModifier)
        }
        composable(route = BottomBarScreen.Konular.route) {
            Konular(paddingModifier,navController)
        }
        composable(route = BottomBarScreen.Testler.route) {
            Testler(paddingModifier, navController)
        }
        composable(route = BottomBarScreen.Profil.route) {
            Profile(paddingModifier)
        }
        composable(route = BottomBarScreen.PdfViewer.route) {
            PdfViewer()
        }
        composable(route = BottomBarScreen.BilgiKartlari.route, arguments = listOf(navArgument("konuAdi") {
            type = NavType.StringType
        })) {
            val json = it.arguments?.getString("konuAdi")
            BilgiKartlari(json!!, paddingModifier)
        }
        composable(route = BottomBarScreen.TestEkrani.route, arguments = listOf(navArgument("dersAdi") {
            type = NavType.StringType
        })) {
            val json = it.arguments?.getString("dersAdi")
            TestEkrani(paddingModifier,json!!, navController = navController)
        }
        composable(route = BottomBarScreen.KonuAnlatimi.route, arguments = listOf(navArgument("konuAdi") {
            type = NavType.StringType
        })) {
            val json = it.arguments?.getString("konuAdi")
            KonuAnlatim(json!!, paddingModifier)
        }
    }
}
