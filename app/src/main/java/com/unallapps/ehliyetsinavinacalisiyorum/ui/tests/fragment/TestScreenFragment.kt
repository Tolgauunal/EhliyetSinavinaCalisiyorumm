package com.unallapps.ehliyetsinavinacalisiyorum.ui.tests.fragment

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.CloseAlert
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.FinishAlert
import com.unallapps.ehliyetsinavinacalisiyorum.ui.tests.viewmodel.TestScreenViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun TestScreen(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: TestScreenViewModel = hiltViewModel()
) {
    val selectedLesson by viewModel.getSelectedLessonInfo.collectAsState()
    val questionIndex by viewModel.questionIndex.collectAsState()
    val questionSize by viewModel.questionSize.collectAsState()
    val question by viewModel.question.collectAsState()
    val correctSum by viewModel.correctSum.collectAsState()
    val wrongSum by viewModel.wrongSum.collectAsState()
    val questionImage by viewModel.questionImage.collectAsState()
    val optionA by viewModel.optionA.collectAsState()
    val optionB by viewModel.optionB.collectAsState()
    val optionC by viewModel.optionC.collectAsState()
    val optionD by viewModel.optionD.collectAsState()
    val backgroundColorA by viewModel.backgroundColorA.collectAsState()
    val backgroundColorB by viewModel.backgroundColorB.collectAsState()
    val backgroundColorC by viewModel.backgroundColorC.collectAsState()
    val backgroundColorD by viewModel.backgroundColorD.collectAsState()
    val finishAlertDialog by viewModel.finishAlertDialog.collectAsState()
    val exitAlertDialog by viewModel.exitAlertDialog.collectAsState()

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
            selectedLesson?.let {
                Image(
                    painter = painterResource(it.icon),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp)
                )
            }
            selectedLesson?.let {
                Text(text = it.name, textAlign = TextAlign.Center)
            }
            Image(
                painter = painterResource(id = R.drawable.baseline_close_24),
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
                text = stringResource(R.string.question_Size) + " " + (questionIndex + 1) +
                    "/" + questionSize,
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
                        text = stringResource(R.string.correct_Size) + " " + correctSum,
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
                        text = stringResource(R.string.wrong_Size) + " " + wrongSum,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(top = 20.dp))
        questionImage?.let {
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
            Text(text = question)
        }
        CustomOptionCard(
            optionIcon = R.drawable.a,
            optionTest = optionA,
            correctColor = backgroundColorA
        ) {
            viewModel.setSelectedCorrect(it)
        }
        CustomOptionCard(
            optionIcon = R.drawable.b,
            optionTest = optionB,
            correctColor = backgroundColorB
        ) {
            viewModel.setSelectedCorrect(it)
        }
        CustomOptionCard(
            optionIcon = R.drawable.c,
            optionTest = optionC,
            correctColor = backgroundColorC
        ) {
            viewModel.setSelectedCorrect(it)
        }
        CustomOptionCard(
            optionIcon = R.drawable.d,
            optionTest = optionD,
            correctColor = backgroundColorD
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

        if (finishAlertDialog) {
            FinishAlert(onFinishAlertDialog = { viewModel.setFinishAlertDialog(it) }) {
                navController.navigate("testScreen/${selectedLesson?.name}")
            }
        }
        if (exitAlertDialog) {
            CloseAlert(onClose = { viewModel.setExitAlertDialog(it) }) {
                viewModel.setTestNumber(testNumber = questionIndex)
                navController.navigate("tests")
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
    Card(
        modifier = Modifier
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