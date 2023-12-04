package com.unallapps.ehliyetsinavinacalisiyorum.profil

import android.graphics.ImageDecoder
import android.graphics.ImageDecoder.*
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.unallapps.ehliyetsinavinacalisiyorum.R

@Composable
fun Profil() {
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
            .background(Color.Blue)
            .fillMaxWidth()
            .padding(10.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        launcher.launch(PickVisualMediaRequest(mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly))
                    }) {
                if (photoUri != null) { //Use Coil to display the selected image
                    val painter =
                        rememberAsyncImagePainter(ImageRequest.Builder(LocalContext.current).data(data = photoUri)
                            .build())
                    Image(painter = painter,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(150.dp)
                            .padding(5.dp),
                        contentScale = ContentScale.Fit)
                } else {
                    Image(painter = painterResource(id = R.drawable.baseline_person_24),
                        contentDescription = "Profil",
                        modifier = Modifier.size(150.dp))
                }
            }
            Row(horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(50.dp)) {
                Image(painter = painterResource(id = R.drawable.baseline_settings_24), contentDescription = "Profil")
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = { /*TODO*/ }) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Icon(painter = painterResource(id = R.drawable.home), contentDescription = "")
                Text(text = "Deneme")
                Icon(painter = painterResource(id = R.drawable.home), contentDescription = "")
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Button(onClick = { /*TODO*/ }) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Icon(painter = painterResource(id = R.drawable.home), contentDescription = "")
                Text(text = "Deneme")
                Icon(painter = painterResource(id = R.drawable.home), contentDescription = "")
            }
        }

        Spacer(modifier = Modifier.padding(5.dp))
        Button(onClick = { /*TODO*/ }) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Icon(painter = painterResource(id = R.drawable.home), contentDescription = "")
                Text(text = "Deneme")
                Icon(painter = painterResource(id = R.drawable.home), contentDescription = "")
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Button(onClick = { /*TODO*/ }) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Icon(painter = painterResource(id = R.drawable.home), contentDescription = "")
                Text(text = "Deneme")
                Icon(painter = painterResource(id = R.drawable.home), contentDescription = "")
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Button(onClick = { /*TODO*/ }) {
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Icon(painter = painterResource(id = R.drawable.home), contentDescription = "")
                Text(text = "Deneme")
                Icon(painter = painterResource(id = R.drawable.home), contentDescription = "")
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ProfilPreview() {
    Profil()
}