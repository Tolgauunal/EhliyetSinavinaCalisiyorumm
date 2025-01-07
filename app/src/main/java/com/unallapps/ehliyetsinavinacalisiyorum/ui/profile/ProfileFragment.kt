package com.unallapps.ehliyetsinavinacalisiyorum.ui.profile

import android.annotation.SuppressLint
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.CustomButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.P)
@SuppressLint("StateFlowValueCalledInComposition", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileFragment(
    modifier: Modifier,
    profileViewModel: ProfileViewModel = hiltViewModel()
) {
    var photoUri: Uri? by remember { mutableStateOf(null) }
    val settingsState = remember { mutableStateOf(false) }
    val nameStateTextField = remember { mutableStateOf("") }
    val nameStateText = profileViewModel.nameStateText.collectAsState()
    val userImage = profileViewModel.userImage.collectAsState()
    val settingsIconControl = profileViewModel.isDeleteAll.collectAsState()
    val settingsIcon = profileViewModel.settingsIcon.collectAsState()
    val context = LocalContext.current
    getProfileInfo(profileViewModel, nameStateText.value)
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            photoUri = uri
            photoUri?.let {
                val source = ImageDecoder.decodeBitmap(
                    ImageDecoder.createSource(
                        context.contentResolver,
                        it
                    )
                )
                profileViewModel.savePhoto(source)
            }
        }
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.verticalScroll(rememberScrollState())
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
                if (photoUri != null) {
                    val painter =
                        rememberAsyncImagePainter(
                            ImageRequest.Builder(LocalContext.current).data(data = photoUri)
                                .build()
                        )
                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .fillMaxWidth()
                            .clickable {
                                launcher.launch(PickVisualMediaRequest(mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly))
                            },
                        contentScale = ContentScale.Crop
                    )

                } else if (userImage.value?.isNotEmpty() == true) {
                    val userPhoto = userImage.value
                    val bitmap = BitmapFactory.decodeByteArray(userPhoto, 0, userPhoto!!.size)
                    Image(
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .fillMaxWidth()
                            .clickable {
                                launcher.launch(PickVisualMediaRequest(mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly))
                            },
                        contentScale = ContentScale.Crop
                    )
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
                Spacer(modifier = Modifier.padding(5.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    if (!settingsState.value) {
                        Text(text = nameStateText.value, color = Color.White, fontSize = 15.sp)
                        nameStateTextField.value = nameStateText.value
                    } else {
                        OutlinedTextField(
                            value = nameStateTextField.value,
                            onValueChange = { nameStateTextField.value = it },
                            label = {
                                Text(
                                    text = stringResource(R.string.Set_Profile_Name),
                                    color = Color.White
                                )
                            },
                            colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color.White)
                        )
                    }
                    Icon(painter = painterResource(settingsIcon.value),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .clickable {
                                profileViewModel.setDeleteAll(!settingsIconControl.value)
                                profileViewModel.insertOrUpdate(nameStateTextField.value)
                                profileViewModel.setSettingsIcon()
                                settingsState.value = settingsIconControl.value
                            })
                }
            }
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = stringResource(R.string.Settings),
            color = colorResource(id = R.color.kapaliMavi),
            fontSize = 16.sp
        )
        Column(modifier = Modifier.padding(10.dp)) {
            Spacer(modifier = Modifier.padding(10.dp))
            CustomButton(
                title = stringResource(R.string.Privacy_Policy),
                R.drawable.gizlilik,
                onClick = {}
            )
            Spacer(modifier = Modifier.padding(5.dp))
            CustomButton(
                title = stringResource(R.string.Terms_And_Conditions),
                R.drawable.sartlar,
                onClick = {}
            )
            Spacer(modifier = Modifier.padding(5.dp))
            CustomButton(
                title = stringResource(R.string.Vote_For_Us),
                R.drawable.oy,
                onClick = {}
            )
            Spacer(modifier = Modifier.padding(5.dp))
            CustomButton(
                title = stringResource(R.string.Report_Error),
                R.drawable.error,
                onClick = {}
            )
            Spacer(modifier = Modifier.padding(5.dp))
            CustomButton(
                title = stringResource(R.string.Contact),
                R.drawable.contact,
                onClick = {}
            )
        }
    }
}

private fun getProfileInfo(profileViewModel: ProfileViewModel, nameStateText: String) {
    CoroutineScope(Dispatchers.Main).launch {
        profileViewModel.userInfo.collect {
            profileViewModel.nameStateText.value = nameStateText
        }
    }
}
