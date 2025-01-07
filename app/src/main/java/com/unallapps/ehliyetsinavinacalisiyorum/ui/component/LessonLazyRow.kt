package com.unallapps.ehliyetsinavinacalisiyorum.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseLesson
import com.unallapps.ehliyetsinavinacalisiyorum.R

@Composable
fun LessonLazyRow(lessonSelectedItem: Int, onClick: (Int) -> Unit) {
    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        Text(text = stringResource(R.string.Selected_Lesson))
        Spacer(modifier = Modifier.padding(top = 10.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items(count = DatabaseLesson.derslerList.count(), itemContent = {
                val selectedLesson = DatabaseLesson.derslerList[it]
                if (lessonSelectedItem == it) {
                    Card(colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.kapaliMavi),
                        contentColor = Color.White
                    ),
                        border = BorderStroke(1.dp, color = colorResource(id = R.color.kapaliMavi)),
                        elevation = CardDefaults.cardElevation(16.dp),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.clickable { onClick(it) }) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(5.dp)
                        ) {
                            Image(
                                painter = painterResource(id = selectedLesson.icon),
                                contentDescription = ""
                            )
                            Text(
                                text = selectedLesson.name,
                                modifier = Modifier.padding(10.dp),
                                color = Color.White
                            )
                        }
                    }
                } else {
                    Card(colors = CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.white),
                        contentColor = Color.White
                    ),
                        border = BorderStroke(1.dp, color = colorResource(id = R.color.kapaliMavi)),
                        elevation = CardDefaults.cardElevation(16.dp),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.clickable { onClick(it) }) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(5.dp)
                        ) {
                            Image(
                                painter = painterResource(id = selectedLesson.icon),
                                contentDescription = ""
                            )
                            Text(
                                text = selectedLesson.name,
                                modifier = Modifier.padding(10.dp),
                                color = colorResource(id = R.color.kapaliMavi)
                            )
                        }
                    }
                }
                Spacer(
                    modifier = Modifier.padding(
                        start = 0.dp,
                        top = 10.dp,
                        end = 10.dp,
                        bottom = 10.dp
                    )
                )
            })
        }
    }

}
