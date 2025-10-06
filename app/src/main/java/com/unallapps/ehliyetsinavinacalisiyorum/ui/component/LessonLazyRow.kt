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
import androidx.compose.ui.unit.dp
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseLesson

@Composable
fun LessonLazyRow(
    lessonSelectedItem: Int,
    onClick: (Int) -> Unit
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
            val limitedList = DatabaseLesson.lessonList.take(3)
            items(limitedList.size) { index ->
                val lesson = DatabaseLesson.lessonList[index]
                val isSelected = lessonSelectedItem == index

                Card(
                    modifier = Modifier
                        .clickable { onClick(index) }
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
                            painter = painterResource(id = lesson.icon),
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Text(
                            text = lesson.name,
                            color = if (isSelected)
                                Color.White
                            else
                                colorResource(id = R.color.kapaliMavi)
                        )
                    }
                }
            }
        }
    }
}