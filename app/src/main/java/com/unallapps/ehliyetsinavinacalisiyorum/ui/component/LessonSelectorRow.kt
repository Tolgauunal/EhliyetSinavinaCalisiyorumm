package com.unallapps.ehliyetsinavinacalisiyorum.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseLesson

@Composable
fun LessonSelectorRow(
    selectedLessonIndex: Int,
    onLessonSelected: (Int) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = stringResource(R.string.selected_Lesson))

        Spacer(modifier = Modifier.height(10.dp))

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val visibleLessons = DatabaseLesson.lessonList.take(3)

            items(visibleLessons.size) { index ->
                val lesson = visibleLessons[index]
                val isSelected = selectedLessonIndex == index

                LessonCard(
                    lessonName = lesson.name,
                    iconResId = lesson.icon,
                    isSelected = isSelected,
                    onClick = { onLessonSelected(index) }
                )
            }
        }
    }
}

@Composable
private fun LessonCard(
    lessonName: String,
    iconResId: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .clickable { onClick() }
            .padding(4.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(
            width = 1.dp,
            color = colorResource(id = R.color.kapaliMavi)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected)
                colorResource(id = R.color.kapaliMavi)
            else
                colorResource(id = R.color.white),
            contentColor = if (isSelected)
                Color.White
            else
                colorResource(id = R.color.kapaliMavi)
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(15.dp)
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(
                text = lessonName,
                color = if (isSelected)
                    Color.White
                else
                    colorResource(id = R.color.kapaliMavi)
            )
        }
    }
}

@Preview
@Composable
fun LessonSelectorRowPreview() {
    LessonSelectorRow(selectedLessonIndex = 0, onLessonSelected = {})
}

@Preview
@Composable
fun LessonCardPreview() {
    LessonCard(
        lessonName = "Genel İlk Yardım Bilgileri",
        iconResId = R.drawable.ilkyardim,
        isSelected = true,
        onClick = {})
}