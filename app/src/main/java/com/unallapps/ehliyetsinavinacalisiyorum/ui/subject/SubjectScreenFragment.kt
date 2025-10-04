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
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.LessonLazyRow
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.SubjectLazyRow

@Composable
fun SubjectScreenFragment(
    modifier: Modifier,
    navController: NavHostController,
    viewModel: SubjectScreenViewModel = hiltViewModel()
) {
    val lessonSelectedItem by viewModel.lessonSelectedItem.collectAsState()
    val selectedSubject by viewModel.selectedSubject.collectAsState()
    val alertDialog by viewModel.alertDialog.collectAsState()

    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LessonLazyRow(lessonSelectedItem = lessonSelectedItem) {
            viewModel.setSelectedSubject(it)
        }
        Spacer(modifier = Modifier.padding(5.dp))
        SubjectLazyRow(
            lessonSelectedItemIndex = lessonSelectedItem,
            controller = false,
            onSelectedSubject = { viewModel.setSelectedSubject(it.id) },
            onAlertDialog = { viewModel.setAlertDialog(it) },
            subjectTitle = R.string.all_lesson
        )
        if (alertDialog) {
            CustomAlertDialog(
                selectedSubject = selectedSubject,
                onAlertDialogChange = { viewModel.setAlertDialog(it) },
                onClickInformationCard = { navController.navigate("informationCard/${it}") }) {
                navController.navigate("subjectScreen/${it}")
            }
        }
    }
}