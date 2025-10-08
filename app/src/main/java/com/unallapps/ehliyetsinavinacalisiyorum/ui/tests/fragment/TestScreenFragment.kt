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
import androidx.compose.material3.Icon
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
import com.unallapps.ehliyetsinavinacalisiyorum.navigation.BottomBarScreen
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.ExitConfirmationDialog
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.FinishAlert
import com.unallapps.ehliyetsinavinacalisiyorum.ui.tests.viewmodel.TestScreenViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun TestScreen(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: TestScreenViewModel = hiltViewModel()
) {
    val selectedLesson by viewModel.selectedLesson.collectAsState()
    val currentQuestionIndex by viewModel.currentQuestionIndex.collectAsState()
    val totalQuestionCount by viewModel.totalQuestionCount.collectAsState()
    val currentQuestionText by viewModel.currentQuestionText.collectAsState()
    val correctAnswerCount by viewModel.correctAnswerCount.collectAsState()
    val wrongAnswerCount by viewModel.wrongAnswerCount.collectAsState()
    val questionImageRes by viewModel.questionImageRes.collectAsState()
    val optionAText by viewModel.optionAText.collectAsState()
    val optionBText by viewModel.optionBText.collectAsState()
    val optionCText by viewModel.optionCText.collectAsState()
    val optionDText by viewModel.optionDText.collectAsState()
    val optionAColor by viewModel.optionAColor.collectAsState()
    val optionBColor by viewModel.optionBColor.collectAsState()
    val optionCColor by viewModel.optionCColor.collectAsState()
    val optionDColor by viewModel.optionDColor.collectAsState()
    val showFinishDialog by viewModel.showFinishDialog.collectAsState()
    val showExitDialog by viewModel.showExitDialog.collectAsState()
    val showNextButton by viewModel.showNextButton.collectAsState()
    val favoriteIconRes by viewModel.favoriteIconRes.collectAsState()
    val nextQuestionIcon by viewModel.nextQuestionIcon.collectAsState()

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
            Row {
                Icon(
                    painter = painterResource(id = favoriteIconRes),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clickable {
                            viewModel.toggleFavoriteStatus()
                        }
                        .size(24.dp),
                    tint = colorResource(R.color.altinsarisi)
                )
                Icon(
                    painter = painterResource(id = R.drawable.baseline_close_24),
                    contentDescription = "",
                    tint = colorResource(R.color.altinsarisi),
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            viewModel.setExitDialogVisible(true)
                        }
                )
            }
        }
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(R.string.question_Size) + " " + (currentQuestionIndex + 1) +
                    "/" + totalQuestionCount,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.dogru),
                        contentDescription = "",
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Text(
                        text = stringResource(R.string.correct_Size) + " " + correctAnswerCount,
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
                        text = stringResource(R.string.wrong_Size) + " " + wrongAnswerCount,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(top = 20.dp))
        questionImageRes?.let {
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
            Text(text = currentQuestionText)
        }
        CustomOptionCard(
            optionIcon = R.drawable.a,
            optionTest = optionAText,
            correctColor = optionAColor
        ) {
            viewModel.selectAnswer(it)
        }
        CustomOptionCard(
            optionIcon = R.drawable.b,
            optionTest = optionBText,
            correctColor = optionBColor
        ) {
            viewModel.selectAnswer(it)
        }
        CustomOptionCard(
            optionIcon = R.drawable.c,
            optionTest = optionCText,
            correctColor = optionCColor
        ) {
            viewModel.selectAnswer(it)
        }
        CustomOptionCard(
            optionIcon = R.drawable.d,
            optionTest = optionDText,
            correctColor = optionDColor
        ) {
            viewModel.selectAnswer(it)
        }
        Spacer(modifier = Modifier.padding(5.dp))
        if (showNextButton) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Icon(
                    painter = painterResource(id = nextQuestionIcon),
                    contentDescription = "",
                    tint = colorResource(R.color.altinsarisi),
                    modifier = Modifier
                        .size(36.dp)
                        .clickable {
                            viewModel.nextQuestion()
                        }
                )
            }
        }

        if (showFinishDialog) {
            FinishAlert(
                onPopBack = {
                    viewModel.setFinishDialogVisible(it)
                    navController.popBackStack(
                        route = BottomBarScreen.Tests.route,
                        inclusive = false
                    )
                },
                onRestart = {
                    navController.navigate("testScreen/${selectedLesson?.name}/${it}")
                }
            )
        }
        if (showExitDialog) {
            ExitConfirmationDialog(onDismiss = {
                viewModel.setExitDialogVisible(it)
            }) {
                viewModel.setExitDialogVisible(false)
                viewModel.saveTestProgress(currentQuestion = currentQuestionIndex)
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