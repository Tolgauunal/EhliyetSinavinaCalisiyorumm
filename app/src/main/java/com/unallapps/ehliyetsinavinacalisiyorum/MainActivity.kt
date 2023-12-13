package com.unallapps.ehliyetsinavinacalisiyorum

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.unallapps.ehliyetsinavinacalisiyorum.bilgikartlari.BilgiKartlari
import com.unallapps.ehliyetsinavinacalisiyorum.home.Home
import com.unallapps.ehliyetsinavinacalisiyorum.konular.Konular
import com.unallapps.ehliyetsinavinacalisiyorum.profil.Profil
import com.unallapps.ehliyetsinavinacalisiyorum.testler.Testler
import com.unallapps.ehliyetsinavinacalisiyorum.ui.theme.EhliyetSinavinaCalisiyorumTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EhliyetSinavinaCalisiyorumTheme { // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
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
    val navigationSelectedItem = remember { mutableStateOf(0) }
    val navigationItem = listOf("Home", "Konular", "Testler", "Profil","Profill")
    Scaffold(bottomBar = {
        NavigationBar {
            navigationItem.forEachIndexed { index, item ->
                NavigationBarItem(selected = navigationSelectedItem.value == index,
                    onClick = { navigationSelectedItem.value = index },
                    icon = {
                        when (item) {
                            "Home" -> Icon(imageVector = Icons.Default.Home, contentDescription = "Ana Sayfa")
                            "Konular" -> Icon(painter = painterResource(id = R.drawable.baseline_library_books_24),
                                contentDescription = "Ana Sayfa")
                            "Testler" -> Icon(imageVector = Icons.Default.Home, contentDescription = "Testler")
                            "Profil" -> Icon(imageVector = Icons.Default.Person, contentDescription = "Profil")
                            "Profill" -> Icon(imageVector = Icons.Default.Person, contentDescription = "Profil")
                        }
                    },
                    label = {
                        Text(text = item)
                    })
            }
        }
    }, content = {
        Box(modifier = Modifier.padding(it)) {
            if (navigationSelectedItem.value == 0) {
                Home()
            }
            if (navigationSelectedItem.value == 1) {
                Konular()
            }
            if (navigationSelectedItem.value == 2) {
                Testler()
            }
            if (navigationSelectedItem.value == 3) {
                Profil()
            }
            if (navigationSelectedItem.value == 4) {
                BilgiKartlari(1)
            }
        }
    })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    EhliyetSinavinaCalisiyorumTheme {
        Greeting()
    }
}