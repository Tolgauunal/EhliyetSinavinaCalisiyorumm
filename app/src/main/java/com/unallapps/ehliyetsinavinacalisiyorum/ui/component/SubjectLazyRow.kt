package com.unallapps.ehliyetsinavinacalisiyorum.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseSubject
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.Subject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubjectLazyRow(
    lessonSelectedItemIndex: Int,
    controller: Boolean,
    onSelectedSubject: (Subject) -> Unit,
    onAlertDialog: (Boolean) -> Unit
) {
    Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
        val currentList = if (controller) {
            DatabaseSubject.subjectLists.filter { it.id == lessonSelectedItemIndex }.take(5)
                .toMutableList()
        } else {
            DatabaseSubject.subjectLists
        }
        Text(text = stringResource(R.string.Suggestion_lesson))
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            items(count = currentList.size, itemContent = {
                val subjects = currentList[it]
                if (subjects.id == lessonSelectedItemIndex) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Card(
                            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.acikmavi)),
                            shape = RoundedCornerShape(20.dp),
                            onClick = {
                                onAlertDialog(true)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp)
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start,
                                modifier = Modifier
                                    .clickable {
                                        onSelectedSubject(subjects)
                                        onAlertDialog(true)
                                    }
                                    .fillMaxWidth()
                                    .padding(5.dp)) {
                                Image(
                                    painter = painterResource(id = subjects.icon),
                                    contentDescription = "",
                                )
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = subjects.name,
                                        modifier = Modifier.padding(10.dp),
                                        color = colorResource(id = R.color.kapaliMavi),
                                        maxLines = 1,
                                        textAlign = TextAlign.Center
                                    )
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Center
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.info),
                                            contentDescription = "",
                                            tint = colorResource(id = R.color.kapaliMavi),
                                            modifier = Modifier.size(14.dp)
                                        )
                                        Text(
                                            text = stringResource(R.string.Information_Card),
                                            modifier = Modifier.padding(3.dp),
                                            color = colorResource(id = R.color.kapaliMavi),
                                            fontSize = 12.sp,
                                            textAlign = TextAlign.Center
                                        )
                                        Icon(
                                            painter = painterResource(id = R.drawable.infobook),
                                            contentDescription = "",
                                            tint = colorResource(id = R.color.kapaliMavi),
                                            modifier = Modifier.size(12.dp)
                                        )
                                        Text(
                                            text = stringResource(R.string.Subject_Explanation),
                                            modifier = Modifier.padding(3.dp),
                                            color = colorResource(id = R.color.kapaliMavi),
                                            fontSize = 12.sp,
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            })
        }
    }
}
