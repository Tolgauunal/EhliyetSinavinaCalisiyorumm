package com.unallapps.ehliyetsinavinacalisiyorum.ui.testler

import android.annotation.SuppressLint
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
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.CloseAlert
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.FinishAlert

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun TestScreen(
    modifier: Modifier,
    lessonName: String,
    navController: NavHostController,
    viewModel: TestViewModel = hiltViewModel()
) {
    viewModel.getSelectedLesson(lessonName)
    viewModel.getTestList(lessonName)
    val selectedLesson = viewModel.getSelectedLessonInfo.collectAsState()
    val questionIndex = viewModel.questionIndex.collectAsState()
    val questionSize = viewModel.questionSize.collectAsState()
    val question = viewModel.question.collectAsState()
    val correctSum = viewModel.correctSum.collectAsState()
    val wrongSum = viewModel.wrongSum.collectAsState()
    val questionImage = viewModel.questionImage.collectAsState()
    val optionA = viewModel.optionA.collectAsState()
    val optionB = viewModel.optionB.collectAsState()
    val optionC = viewModel.optionC.collectAsState()
    val optionD = viewModel.optionD.collectAsState()
    val backgroundColorA = viewModel.backgroundColorA.collectAsState()
    val backgroundColorB = viewModel.backgroundColorB.collectAsState()
    val backgroundColorC = viewModel.backgroundColorC.collectAsState()
    val backgroundColorD = viewModel.backgroundColorD.collectAsState()
    val finishAlertDialog = viewModel.finishAlertDialog.collectAsState()
    val exitAlertDialog = viewModel.exitAlertDialog.collectAsState()
    val testClickable = viewModel.testClickable.collectAsState()


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            selectedLesson.value?.let {
                Image(
                    painter = painterResource(it.icon),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp)
                )
            }
            selectedLesson.value?.let {
                Text(text = it.name, textAlign = TextAlign.Center)
            }
            Image(painter = painterResource(id = R.drawable.baseline_close_24),
                contentDescription = "",
                modifier = Modifier.clickable {
                    viewModel.setExitAlertDialog(true)
                })
        }
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Soru Sayısı ${questionIndex.value + 1} / ${questionSize.value}",
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Column {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.dogru),
                        contentDescription = "",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "Doğru Sayısı: ${correctSum.value}",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.wrong),
                        contentDescription = "",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Text(
                        text = "Yanlış Sayısı: ${wrongSum.value}",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(top = 20.dp))
        questionImage.value?.let {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = it),
                    contentDescription = "",
                    modifier = Modifier.size(height = 100.dp, width = 250.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = question.value)
        }
        CustomOptionCard(
            optionIcon = R.drawable.a,
            optionTest = optionA.value,
            correctColor = backgroundColorA.value
        ) {
            viewModel.setSelectedCorrect(it)
        }
        CustomOptionCard(
            optionIcon = R.drawable.b,
            optionTest = optionB.value,
            correctColor = backgroundColorB.value
        ) {
            viewModel.setSelectedCorrect(it)
        }
        CustomOptionCard(
            optionIcon = R.drawable.c,
            optionTest = optionC.value,
            correctColor = backgroundColorC.value
        ) {
            viewModel.setSelectedCorrect(it)
        }
        CustomOptionCard(
            optionIcon = R.drawable.d,
            optionTest = optionD.value,
            correctColor = backgroundColorD.value
        ) {
            viewModel.setSelectedCorrect(it)
        }
        Spacer(modifier = Modifier.padding(5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.baseline_done_24),
                contentDescription = "",
                modifier = Modifier.clickable {
                    viewModel.nextQuestion()
                }
            )
        }

        if (finishAlertDialog.value) {
            FinishAlert(onfinishAlertDialog = { viewModel.setFinishAlertDialog(it) }) {
                navController.navigate("testEkrani/${selectedLesson.value?.name}")
            }
        }
        if (exitAlertDialog.value) {
            FinishAlert(onfinishAlertDialog = { viewModel.setExitAlertDialog(it) }) {
                navController.navigate("testler")
            }
        }
    }
}

@Composable
fun CustomOptionCard(
    optionIcon: Int,
    optionTest: String,
    correctColor: Int?,
    onClick: (String) -> Unit
) {
    Spacer(modifier = Modifier.padding(top = 10.dp))
    Card(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onClick(optionTest)
        }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .background(
                    color = colorResource(
                        id = correctColor ?: R.color.white
                    )
                )
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(optionIcon),
                contentDescription = "",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = optionTest, modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}