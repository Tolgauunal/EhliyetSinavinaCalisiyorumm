package com.unallapps.ehliyetsinavinacalisiyorum

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.unallapps.ehliyetsinavinacalisiyorum.navigation.BottomBarScreen
import com.unallapps.ehliyetsinavinacalisiyorum.navigation.BottomNavigationGraph
import com.unallapps.ehliyetsinavinacalisiyorum.ui.theme.EhliyetSinavinaCalisiyorumTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EhliyetSinavinaCalisiyorumTheme { // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.kapaliMavi)
                ) {
                    Greeting()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Greeting() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { AppBottomBar(navController = navController) },
    ) //content:
    { paddingValues ->
        BottomNavigationGraph(
            navController = navController,
            paddingModifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun AppBottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Subjects,
        BottomBarScreen.Tests,
        BottomBarScreen.Profile,
        BottomBarScreen.InformationCard
    )
    NavigationBar(
        modifier = Modifier.clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
        containerColor = colorResource(id = R.color.white)
    ) {
        screens.forEach { screen ->
            when (screen) {
                is BottomBarScreen.Home, BottomBarScreen.Subjects,
                BottomBarScreen.Tests, BottomBarScreen.Profile -> AddItem(
                    screen = screen,
                    navController = navController
                )

                else -> Unit
            }
        }
    }
}

@Composable
fun RowScope.AddItem(screen: BottomBarScreen, navController: NavHostController) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    NavigationBarItem(
        label = {
            Text(text = screen.label)
        },
        icon = {
            Icon(painter = painterResource(id = screen.icon), contentDescription = screen.label)
        },
        selected = screen.route == backStackEntry.value?.destination?.route,
        onClick = {
            navController.navigate(screen.route)
        },
        alwaysShowLabel = true,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = colorResource(id = R.color.kapaliMavi),
            unselectedIconColor = colorResource(id = R.color.Gray),
            indicatorColor = colorResource(id = R.color.acikmavi)
        )
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    EhliyetSinavinaCalisiyorumTheme {
        Greeting()
    }
}