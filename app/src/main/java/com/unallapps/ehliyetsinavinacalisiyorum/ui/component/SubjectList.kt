package com.unallapps.ehliyetsinavinacalisiyorum.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseSubject
import com.unallapps.ehliyetsinavinacalisiyorum.data.Subject

@Composable
fun SubjectList(
    selectedLessonIndex: Int,
    isLessonMode: Boolean,
    onSubjectSelected: (Subject) -> Unit,
    onShowDialog: (Boolean) -> Unit,
    titleRes: Int = R.string.suggestion_lesson
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = stringResource(id = titleRes))

        val subjects = if (isLessonMode) {
            DatabaseSubject.subjectLists
                .filter { it.id == selectedLessonIndex }
                .take(5)
        } else {
            DatabaseSubject.subjectLists
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(subjects.size) { index ->
                val subject = subjects[index]

                if (subject.id == selectedLessonIndex) {
                    SubjectCard(
                        subject = subject,
                        onClick = {
                            onSubjectSelected(subject)
                            onShowDialog(true)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun SubjectCard(
    subject: Subject,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.acikmavi)
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp)
            .clickable { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = subject.icon),
                contentDescription = null
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = subject.name,
                    color = colorResource(id = R.color.kapaliMavi),
                    modifier = Modifier.padding(6.dp),
                    maxLines = 1,
                    textAlign = TextAlign.Center
                )

                InfoRow()
            }
        }
    }
}

@Composable
private fun InfoRow() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        InfoItem(
            iconRes = R.drawable.info,
            textRes = R.string.information_Card
        )
        InfoItem(
            iconRes = R.drawable.infobook,
            textRes = R.string.subject_Explanation
        )
    }
}

@Composable
private fun InfoItem(iconRes: Int, textRes: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = colorResource(id = R.color.kapaliMavi),
            modifier = Modifier.size(14.dp)
        )
        Text(
            text = stringResource(id = textRes),
            color = colorResource(id = R.color.kapaliMavi),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 3.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SubjectListPreview() {
    SubjectList(
        selectedLessonIndex = 0,
        isLessonMode = true,
        onSubjectSelected = {},
        onShowDialog = {}
    )
}

@Preview(showBackground = true)
@Composable
fun SubjectCardPreview() {
    val dummySubject = Subject(
        id = 0,
        name = "İlk Yardım",
        icon = R.drawable.ilkyardim
    )
    SubjectCard(subject = dummySubject, onClick = {})
}

@Preview(showBackground = true)
@Composable
fun InfoRowPreview() {
    InfoRow()
}

@Preview(showBackground = true)
@Composable
fun InfoItemPreview() {
    InfoItem(iconRes = R.drawable.info, textRes = R.string.information_Card)
}