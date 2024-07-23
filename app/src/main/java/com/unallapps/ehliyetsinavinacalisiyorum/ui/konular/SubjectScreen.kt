package com.unallapps.ehliyetsinavinacalisiyorum.ui.konular

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.CustomAlertDialog
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.LessonLazyRow
import com.unallapps.ehliyetsinavinacalisiyorum.ui.component.SubjectLazyRow

@Composable
fun SubjectScreen(
    modifier: Modifier,
    navController: NavHostController,
    konularViewModel: SubjectScreenViewModel = hiltViewModel()
) {
    val lessonSelectedItem = konularViewModel.lessonSelectedItem.collectAsState()
    val selectedSubject = konularViewModel.selectedSubject.collectAsState()
    val alertDialog = konularViewModel.alertDialog.collectAsState()

    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LessonLazyRow(lessonSelectedItem = lessonSelectedItem.value) {
            konularViewModel.lessonSelectedItem.value = it
        }
        Spacer(modifier = Modifier.padding(5.dp))
        SubjectLazyRow(lessonSelectedItemIndex = lessonSelectedItem.value,
            controller = false,
            onSelectedSubject = { konularViewModel.selectedSubject.value = it },
            onAlertDialog = { konularViewModel.alertDialog.value = it })
        if (alertDialog.value) {
            CustomAlertDialog(
                selectedSubject = selectedSubject.value,
                onAlertDialogChange = { konularViewModel.alertDialog.value = it },
                onClickBilgiKartlari = { navController.navigate("bilgiKartlari/${it}") }) {
                navController.navigate("konuAnlatimi/${it}")
            }
        }
    }
}