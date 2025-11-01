package com.unallapps.ehliyetsinavinacalisiyorum.ui.profile

import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.ProfileSettingsButton

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun ProfileFragment(
    modifier: Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    var photoUri: Uri? by remember { mutableStateOf(null) }
    val isEditingName by viewModel.isEditingName.collectAsState()
    val userName by viewModel.userName.collectAsState()
    val userPhoto by viewModel.userPhoto.collectAsState()
    val settingsIcon by viewModel.settingsIcon.collectAsState()
    val context = LocalContext.current

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        photoUri = uri
        photoUri?.let {
            val source = ImageDecoder.decodeBitmap(
                ImageDecoder.createSource(context.contentResolver, it)
            )
            viewModel.saveUserPhoto(source)
        }
    }

    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.kapaliMavi))
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                when {
                    photoUri != null -> {
                        val painter = rememberAsyncImagePainter(
                            ImageRequest.Builder(LocalContext.current)
                                .data(photoUri)
                                .build()
                        )
                        Image(
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                                .fillMaxWidth()
                                .clickable {
                                    launcher.launch(
                                        PickVisualMediaRequest(
                                            mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                                        )
                                    )
                                },
                            painter = painter,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }

                    userPhoto?.isNotEmpty() == true -> {
                        val bitmap = BitmapFactory.decodeByteArray(userPhoto, 0, userPhoto!!.size)
                        Image(
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                                .fillMaxWidth()
                                .clickable {
                                    launcher.launch(
                                        PickVisualMediaRequest(
                                            mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                                        )
                                    )
                                },
                            bitmap = bitmap.asImageBitmap(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }

                    else -> {
                        Image(
                            modifier = Modifier
                                .clip(CircleShape)
                                .size(100.dp)
                                .clickable {
                                    launcher.launch(
                                        PickVisualMediaRequest(
                                            mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                                        )
                                    )
                                },
                            painter = painterResource(id = R.drawable.person),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                        )
                    }
                }

                Spacer(modifier = Modifier.padding(5.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    if (!isEditingName) {
                        Text(text = userName, color = Color.White, fontSize = 15.sp)
                    } else {
                        OutlinedTextField(
                            value = userName,
                            onValueChange = { viewModel.updateUserNameLocally(it) },
                            label = {
                                Text(
                                    text = stringResource(R.string.set_Profile_Name),
                                    color = Color.White
                                )
                            },
                            colors = OutlinedTextFieldDefaults.colors(
                                cursorColor = Color.White,
                                unfocusedTextColor = Color.White,
                                focusedTextColor = Color.White,
                                focusedBorderColor = Color.White,
                                unfocusedBorderColor = Color.White,
                                focusedLabelColor = Color.White,
                                unfocusedLabelColor = Color.White,
                            ),
                        )
                    }

                    Icon(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .clickable {
                                viewModel.saveUserName(userName)
                                viewModel.toggleSettingsIcon()
                                viewModel.setEditingName(!isEditingName)
                            },
                        painter = painterResource(settingsIcon),
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Text(
            text = stringResource(R.string.settings),
            color = colorResource(id = R.color.kapaliMavi),
            fontSize = 16.sp
        )

        Column(modifier = Modifier.padding(10.dp)) {
            Spacer(modifier = Modifier.padding(10.dp))
            ProfileSettingsButton(
                textResId = R.string.privacy_Policy,
                iconResId = R.drawable.gizlilik,
                onClick = {}
            )
            Spacer(modifier = Modifier.padding(5.dp))
            ProfileSettingsButton(
                textResId = R.string.terms_And_Conditions,
                iconResId = R.drawable.sartlar,
                onClick = {}
            )
            Spacer(modifier = Modifier.padding(5.dp))
            ProfileSettingsButton(
                textResId = R.string.vote_For_Us,
                iconResId = R.drawable.oy,
                onClick = {}
            )
            Spacer(modifier = Modifier.padding(5.dp))
            ProfileSettingsButton(
                textResId = R.string.report_Error,
                iconResId = R.drawable.error,
                onClick = {}
            )
            Spacer(modifier = Modifier.padding(5.dp))
            ProfileSettingsButton(
                textResId = R.string.contact,
                iconResId = R.drawable.contact,
                onClick = {}
            )
        }
    }
}
