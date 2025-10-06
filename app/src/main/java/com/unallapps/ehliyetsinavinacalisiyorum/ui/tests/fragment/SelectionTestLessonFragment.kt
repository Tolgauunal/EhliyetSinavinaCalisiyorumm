package com.unallapps.ehliyetsinavinacalisiyorum.ui.tests.fragment

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
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
import com.unallapps.ehliyetsinavinacalisiyorum.data.util.Constants
import com.unallapps.ehliyetsinavinacalisiyorum.ui.tests.viewmodel.TestsNavViewModel
import com.unallapps.ehliyetsinavinacalisiyorum.ui.theme.gradientYellow

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun TestsNavFragment(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: TestsNavViewModel = hiltViewModel()
) {
    val selectedLessonItemIndex = viewModel.selectedLessonItemIndex.collectAsState()
    val selectedLessonItemText = viewModel.selectedLessonItemText.collectAsState()
    val favoriteCardVisible = viewModel.favoriteCardVisible.collectAsState()

    Column(
        modifier = modifier
            .padding(start = 8.dp, end = 8.dp, top = 8.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(DatabaseLesson.lessonList.size) { index ->
                val lesson = DatabaseLesson.lessonList[index]
                val isSelected = selectedLessonItemIndex.value == index

                // Renk animasyonu
                val backgroundColor by animateColorAsState(
                    targetValue = if (isSelected)
                        colorResource(id = R.color.green)
                    else
                        colorResource(id = R.color.kapaliMavi),
                    label = ""
                )
                val textColor = Color.White
                val shouldShowCard = lesson.name != Constants.String.FAVORITE || favoriteCardVisible.value

                if (shouldShowCard) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp, horizontal = 8.dp)
                            .shadow(
                                elevation = if (isSelected) 8.dp else 3.dp,
                                shape = MaterialTheme.shapes.medium
                            )
                            .clickable {
                                viewModel.setSelectedLessonItemText(lesson.name)
                                viewModel.setSelectedLessonItemIndex(index)
                            },
                        colors = CardDefaults.cardColors(containerColor = backgroundColor),
                        shape = MaterialTheme.shapes.medium
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
                                contentDescription = null,
                                modifier = Modifier.size(70.dp)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            Text(
                                text = lesson.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = textColor,
                                textAlign = TextAlign.Start
                            )
                        }
                    }
                }
            }
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                onClick = {
                    selectedLessonItemText.value?.let { viewModel.defaultTestItem(it) }
                    navController.navigate("testScreen/${selectedLessonItemText.value}/${false}")
                },
                modifier = Modifier
                    .padding(16.dp)
                    .weight(Constants.Fractions.FRACTION05)
                    .background(gradientYellow, shape = ButtonDefaults.shape)
            ) {
                Text(text = stringResource(R.string.restart), fontSize = 16.sp)
            }
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                onClick = {
                    navController.navigate("testScreen/${selectedLessonItemText.value}/${true}")
                },
                modifier = Modifier
                    .padding(16.dp)
                    .weight(Constants.Fractions.FRACTION05)
                    .background(gradientYellow, shape = ButtonDefaults.shape)

            ) {
                Text(text = stringResource(R.string.continuee), fontSize = 16.sp)
            }
        }
    }
}

