package com.unallapps.ehliyetsinavinacalisiyorum.ui.home

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.CustomAlertDialog
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.LessonSelectorRow
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.SubjectAutoComplete
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.SubjectList

@SuppressLint("StateFlowValueCalledInComposition", "CoroutineCreationDuringComposition")
@Composable
fun HomeFragment(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val userName by viewModel.userName.collectAsState()
    val selectedLessonIndex by viewModel.selectedLessonIndex.collectAsState()
    val selectedSubject by viewModel.selectedSubject.collectAsState()
    val isDialogVisible by viewModel.isDialogVisible.collectAsState()
    val userInfo by viewModel.userInfo.collectAsState()

    Column(
        modifier = modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            userName?.let {
                Text(
                    text = it,
                    color = colorResource(id = R.color.kapaliMavi),
                    fontSize = 16.sp
                )
            }
            userInfo.userPhoto?.let {
                val bitmap = BitmapFactory.decodeByteArray(
                    userInfo.userPhoto,
                    0,
                    userInfo.userPhoto!!.size
                )
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            } ?: run {
                Image(
                    painter = painterResource(id = R.drawable.person),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(24.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.kapaliMavi))
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp)
                ) {
                    Text(
                        text = stringResource(R.string.search_Info),
                        color = colorResource(id = R.color.white),
                        textAlign = TextAlign.Center
                    )
                    SubjectAutoComplete {
                        navController.navigate("subjectScreen/${it}")
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.learningback),
                    contentDescription = "",
                    modifier = Modifier
                        .weight(1f)
                        .size(100.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        LessonSelectorRow(selectedLessonIndex = selectedLessonIndex) {
            viewModel.updateSelectedLesson(it)
        }
        Spacer(modifier = Modifier.padding(5.dp))
        SubjectList(
            selectedLessonIndex = selectedLessonIndex,
            isLessonMode = true,
            onSubjectSelected = { viewModel.updateSelectedSubject(it) },
            onShowDialog = { viewModel.showDialog(it) })
    }
    if (isDialogVisible) {
        CustomAlertDialog(
            selectedSubject = selectedSubject,
            onAlertDialogChange = { viewModel.isDialogVisible.value == it },
            onClickAction = { action, name ->
                when (action) {
                    "informationCard" -> navController.navigate("informationCard/${name}")
                    "subjectScreen" -> navController.navigate("subjectScreen/${name}")
                }
            }
        )
    }
}
