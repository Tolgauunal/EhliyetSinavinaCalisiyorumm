package com.unallapps.ehliyetsinavinacalisiyorum.ui.subject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.unallapps.ehliyetsinavinacalisiyorum.R
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.CustomAlertDialog
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.LessonSelectorRow
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.SubjectList

@Composable
fun SubjectScreenFragment(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: SubjectScreenViewModel = hiltViewModel()
) {
    val selectedLessonIndex by viewModel.selectedLessonIndex.collectAsState()
    val selectedSubject by viewModel.selectedSubject.collectAsState()
    val isAlertDialogVisible by viewModel.isAlertDialogVisible.collectAsState()

    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LessonSelectorRow(selectedLessonIndex = selectedLessonIndex) {
            viewModel.selectLesson(it)
        }
        Spacer(modifier = Modifier.padding(5.dp))
        SubjectList(
            selectedLessonIndex = selectedLessonIndex,
            isLessonMode = false,
            onSubjectSelected = { viewModel.selectLesson(it.id) },
            onShowDialog = { viewModel.setAlertDialogVisible(it) },
            titleRes = R.string.all_lesson
        )
        if (isAlertDialogVisible) {
            CustomAlertDialog(
                selectedSubject = selectedSubject,
                onAlertDialogChange = { viewModel.isAlertDialogVisible.value == it },
                onClickAction = { action, name ->
                    when (action) {
                        "informationCard" -> navController.navigate("informationCard/${name}")
                        "subjectScreen" -> navController.navigate("subjectScreen/${name}")
                    }
                }
            )
        }
    }
}