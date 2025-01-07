package com.unallapps.ehliyetsinavinacalisiyorum.ui.tests.fragment

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseLesson
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.ui.tests.viewmodel.TestsNavViewModel

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun TestsNavFragment(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: TestsNavViewModel = hiltViewModel()
) {
    val selectedLessonItemIndex = viewModel.selectedLessonItemIndex.collectAsState()
    val selectedLessonItemText = viewModel.selectedLessonItemText.collectAsState()
    Column(
        modifier = modifier
            .padding(start = 8.dp, end = 8.dp, top = 8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth(), content = {
            items(DatabaseLesson.derslerList.size) { index ->
                val lesson = DatabaseLesson.derslerList[index]
                if (selectedLessonItemIndex.value == index) {
                    Card(modifier = Modifier
                        .clickable {
                            viewModel.selectedLessonItemText.value = lesson.name
                            viewModel.selectedLessonItemIndex.value = index
                        }
                        .padding(4.dp)
                        .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.green))) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Image(
                                painter = painterResource(id = lesson.icon),
                                contentDescription = "",
                                alignment = Alignment.TopCenter,
                                modifier = Modifier.size(75.dp)
                            )
                            Text(
                                text = lesson.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                } else {
                    Card(
                        modifier = Modifier
                            .clickable {
                                viewModel.setSelectedLessonItemText(lesson.name)
                                viewModel.setSelectedLessonItemIndex(index)
                            }
                            .padding(4.dp)
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.kapaliMavi)),
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Image(
                                painter = painterResource(id = lesson.icon),
                                contentDescription = "",
                                alignment = Alignment.TopCenter,
                                modifier = Modifier.size(75.dp)
                            )
                            Text(
                                text = lesson.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = Color.White,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                }
            }
        })
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.altinsarisi)),
                onClick = {
                    viewModel.defaultTestItem(selectedLessonItemText.value)
                    navController.navigate("testScreen/${selectedLessonItemText.value}/${false}")
                },
                modifier = Modifier
                    .padding(16.dp)
                    .weight(0.5f)
            ) {
                Text(text = stringResource(R.string.Restart), fontSize = 16.sp)
            }
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.altinsarisi)),
                onClick = {
                    navController.navigate("testScreen/${selectedLessonItemText.value}/${true}")
                },
                modifier = Modifier
                    .padding(16.dp)
                    .weight(0.5f)
            ) {
                Text(text = stringResource(R.string.Continue), fontSize = 16.sp)
            }
        }
    }
}

