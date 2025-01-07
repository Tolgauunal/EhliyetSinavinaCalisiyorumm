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
import com.unallapps.ehliyetsinavinacalisiyorum.data.util.Constants
import com.unallapps.ehliyetsinavinacalisiyorum.ui.home.HomeFragment
import com.unallapps.ehliyetsinavinacalisiyorum.ui.informationCard.InformationCardFragment
import com.unallapps.ehliyetsinavinacalisiyorum.ui.subject.SubjectFilter
import com.unallapps.ehliyetsinavinacalisiyorum.ui.profile.ProfileFragment
import com.unallapps.ehliyetsinavinacalisiyorum.ui.subject.SubjectScreenFragment
import com.unallapps.ehliyetsinavinacalisiyorum.ui.tests.fragment.TestScreen
import com.unallapps.ehliyetsinavinacalisiyorum.ui.tests.fragment.TestsNavFragment

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
            HomeFragment(paddingModifier, navController)
        }
        composable(route = BottomBarScreen.Subjects.route) {
            SubjectScreenFragment(paddingModifier, navController)
        }
        composable(route = BottomBarScreen.Tests.route) {
            TestsNavFragment(paddingModifier, navController)
        }
        composable(route = BottomBarScreen.Profile.route) {
            ProfileFragment(paddingModifier)
        }
        composable(
            route = BottomBarScreen.InformationCard.route,
            arguments = listOf(navArgument(Constants.String.SUBJECT_NAME) {
                type = NavType.StringType
            })
        ) {
            InformationCardFragment(paddingModifier)
        }
        composable(
            route = BottomBarScreen.TestScreen.route,
            arguments = listOf(navArgument(Constants.String.LESSON_NAME) {
                type = NavType.StringType
            }, navArgument(Constants.String.RESTART_OR_CONTINUE) { type = NavType.BoolType })
        ) {
            TestScreen(
                paddingModifier,
                navController = navController
            )
        }
        composable(
            route = BottomBarScreen.SubjectScreen.route,
            arguments = listOf(navArgument(Constants.String.SUBJECT_NAME) {
                type = NavType.StringType
            })
        ) {
            val json = it.arguments?.getString(Constants.String.SUBJECT_NAME)
            SubjectFilter(json!!, paddingModifier)
        }
    }
}