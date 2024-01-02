package com.unallapps.ehliyetsinavinacalisiyorum.ui.profil

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.CustomButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(paddingModifier: Modifier, profileViewModel: ProfileViewModel = hiltViewModel()) {
    var photoUri: Uri? by remember { mutableStateOf(null) }
    val state = rememberScrollState()
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri -> //When the user has selected a photo, its URI is returned here
            photoUri = uri
        }
    val nameStateText = remember { mutableStateOf("Misafir Kullanıcı") }
    val nameStateTextField = remember { mutableStateOf("") }
    val settingsState = remember { mutableStateOf(false) }
    val settingsIcon = remember { mutableStateOf(false) }
    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(rememberScrollState())) {
        Box(modifier = Modifier
            .background(colorResource(id = R.color.kapaliMavi))
            .fillMaxWidth()
            .height(150.dp)
            .padding(10.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()) {
                if (photoUri != null) {
                    val painter = rememberAsyncImagePainter(ImageRequest.Builder(LocalContext.current).data(data = photoUri).build())
                    Image(painter = painter,
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .fillMaxWidth()
                            .clickable {
                                launcher.launch(PickVisualMediaRequest(mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly))
                            },
                        contentScale = ContentScale.Crop)
                } else {
                    Image(painter = painterResource(id = R.drawable.person),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(100.dp)
                            .clickable {
                                launcher.launch(PickVisualMediaRequest(mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly))
                            })
                }
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    if (!settingsState.value) {
                        Text(text = nameStateText.value, color = Color.White, fontSize = 15.sp)
                    } else {
                        TextField(value = nameStateTextField.value, onValueChange = {
                            nameStateTextField.value = it
                            nameStateText.value = it
                        }, colors = TextFieldDefaults.textFieldColors(containerColor = Color.Green, textColor = Color.Black))
                    }
                    if (!settingsIcon.value) {
                        Icon(painter = painterResource(id = R.drawable.baseline_settings_24),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .clickable {
                                    settingsState.value = true
                                    settingsIcon.value = true
                                })
                    } else {
                        Icon(painter = painterResource(id = R.drawable.home),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .clickable {
                                    settingsState.value = false
                                    settingsIcon.value = false
                                    profileViewModel.insert(nameStateTextField.value)
                                })
                    }
                }
            }
        }
        Text(text = "Ayarlar", color = colorResource(id = R.color.kapaliMavi))
        Spacer(modifier = Modifier.padding(10.dp))
        CustomButton(title = "Gizlilik Politikası", R.drawable.gizlilik, onClick = {})
        Spacer(modifier = Modifier.padding(5.dp))
        CustomButton(title = "Şartlar ve Koşullar", R.drawable.sartlar, onClick = {})
        Spacer(modifier = Modifier.padding(5.dp))
        CustomButton(title = "Bize Oy Verin", R.drawable.baseline_keyboard_arrow_right_24, onClick = {})
        Spacer(modifier = Modifier.padding(5.dp))
        CustomButton(title = "Hata Bildir", R.drawable.baseline_keyboard_arrow_right_24, onClick = {})
        Spacer(modifier = Modifier.padding(5.dp))
        CustomButton(title = "İletişim", R.drawable.contact, onClick = {})
    }
}