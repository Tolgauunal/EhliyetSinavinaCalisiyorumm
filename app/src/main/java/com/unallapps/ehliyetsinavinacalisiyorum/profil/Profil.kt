package com.unallapps.ehliyetsinavinacalisiyorum.profil

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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.CustomButton

@Composable
fun Profil(paddingModifier: Modifier) {
    var photoUri: Uri? by remember { mutableStateOf(null) }
    val state = rememberScrollState()
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri -> //When the user has selected a photo, its URI is returned here
            photoUri = uri
        }
    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(rememberScrollState())) {
        Box(modifier = Modifier
            .background(colorResource(id = R.color.kapaliMavi))
            .fillMaxWidth()
            .padding(10.dp)) {
            Row(horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp)) {
                Image(painter = painterResource(id = R.drawable.baseline_settings_24), contentDescription = "Profil")
            }
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()) {
                if (photoUri != null) { //Use Coil to display the selected image
                    val painter =
                        rememberAsyncImagePainter(ImageRequest.Builder(LocalContext.current).data(data = photoUri)
                            .build())
                    Image(painter = painter,
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape)
                            .fillMaxWidth()
                            .clickable {
                                launcher.launch(PickVisualMediaRequest(mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly))
                            }
                            .padding(5.dp),
                        contentScale = ContentScale.Crop)
                } else {
                    Image(painter = painterResource(id = R.drawable.baseline_person_24),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(150.dp)
                            .clickable {
                                launcher.launch(PickVisualMediaRequest(mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly))
                            })
                }
            }
        }
        Text(text = "Ayarlar", color = colorResource(id = R.color.kapaliMavi))
        Spacer(modifier = Modifier.padding(10.dp))
        CustomButton(title = "Gizlilik Politikası", onClick = {})
        Spacer(modifier = Modifier.padding(5.dp))
        CustomButton(title = "Şartlar ve Koşullar", onClick = {})
        Spacer(modifier = Modifier.padding(5.dp))
        CustomButton(title = "Bize Oy Verin", onClick = {})
        Spacer(modifier = Modifier.padding(5.dp))
        CustomButton(title = "Hata Bildir", onClick = {})
        Spacer(modifier = Modifier.padding(5.dp))
        CustomButton(title = "İletişim", onClick = {})
    }
}