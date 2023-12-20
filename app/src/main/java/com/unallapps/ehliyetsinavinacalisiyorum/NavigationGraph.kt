package com.unallapps.ehliyetsinavinacalisiyorum

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.unallapps.ehliyetsinavinacalisiyorum.bilgikartlari.BilgiKartlari

@Composable
fun NavigationGraph(navController: NavHostController, paddingModifier: Modifier) {
    NavHost(navController = navController, startDestination = Navigation.BilgiKartlari.route) {
        composable(route = Navigation.BilgiKartlari.route) {
            BilgiKartlari(1, paddingModifier)
        }
    }
}
