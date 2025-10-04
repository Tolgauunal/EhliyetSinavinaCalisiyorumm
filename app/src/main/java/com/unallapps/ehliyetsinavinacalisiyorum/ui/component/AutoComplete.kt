package com.unallapps.ehliyetsinavinacalisiyorum.ui.component

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseSubject

@SuppressLint("ResourceAsColor")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoComplete(isClick: (String) -> Unit) {
    var category by remember { mutableStateOf("") }
    val heightTextFields by remember { mutableStateOf(55.dp) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                value = category,
                onValueChange = {
                    category = it
                    expanded = true
                },
                label = {
                    Text(
                        text = "Konu Arayın",
                        color = colorResource(id = R.color.kapaliMavi)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(heightTextFields)
                    .background(color = Color.White, shape = RoundedCornerShape(15.dp))
                    .onGloballyPositioned { textFieldSize = it.size.toSize() },
                textStyle = TextStyle(
                    color = colorResource(id = R.color.kapaliMavi),
                    fontSize = 16.sp
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    errorContainerColor = Color.Transparent,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.DarkGray,
                    disabledTextColor = Color.Gray,
                    errorTextColor = Color.Red,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    errorIndicatorColor = Color.Red,
                    cursorColor = Color(0xFF003366),
                    focusedLabelColor = Color(0xFF003366),
                    unfocusedLabelColor = Color.DarkGray,
                    disabledLabelColor = Color.Gray,
                    errorLabelColor = Color.Red,
                    focusedPlaceholderColor = Color.LightGray,
                    unfocusedPlaceholderColor = Color.Gray,
                    disabledPlaceholderColor = Color.Gray,
                    errorPlaceholderColor = Color.Red
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                singleLine = true
            )
        }
        AnimatedVisibility(visible = expanded) {
            Card(
                modifier = Modifier
                    .padding(5.dp)
                    .width(textFieldSize.width.dp)
            ) {
                LazyColumn {
                    if (category.isNotEmpty()) {
                        items(DatabaseSubject.subjectLists.filter {
                            it.name.lowercase()
                                .contains(category.lowercase()) || it.name.lowercase()
                                .contains("other")
                        }.take(2)) {
                            CategoryItems(title = it.name) {
                                category = it
                                expanded = false
                                isClick(it)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CategoryItems(title: String, onSelect: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect(title) }) {
        Text(
            text = title,
            modifier = Modifier.padding(5.dp),
            color = colorResource(id = R.color.kapaliMavi),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}