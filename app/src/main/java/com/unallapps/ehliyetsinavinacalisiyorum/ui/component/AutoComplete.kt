package com.unallapps.ehliyetsinavinacalisiyorum.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.unallapps.ehliyetsinavinacalisiyorum.R
import com.unallapps.ehliyetsinavinacalisiyorum.data.DatabaseKonular

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoComplete() {
    var category by remember { mutableStateOf("") }
    val heightTextFields by remember { mutableStateOf(55.dp) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    var expanded by remember { mutableStateOf(false) }

    Text(text = "Category",
        modifier = Modifier.padding(3.dp),
        fontSize = 16.sp,
        color = Color.Black,
        fontWeight = FontWeight.Medium)
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(value = category,
                onValueChange = {
                    category = it
                    expanded = true
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(heightTextFields)
                    .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
                    .onGloballyPositioned { textFieldSize = it.size.toSize() },
                colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.Black),
                textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                            contentDescription = "")
                    }
                })
        }
        AnimatedVisibility(visible = expanded) {
            Card(modifier = Modifier
                .padding(5.dp)
                .width(textFieldSize.width.dp)) {
                LazyColumn(modifier = Modifier.height(150.dp)) {
                    if (category.isNotEmpty()) {
                        items(DatabaseKonular.konularList.filter {
                            it.name.lowercase().contains(category.lowercase()) || it.name.lowercase().contains("other")
                        }) {
                            CategoryItems(title = it.name) {
                                category = it
                                expanded = false
                            }
                        }
                    } else {
                        items(DatabaseKonular.konularList) {
                            CategoryItems(title = it.name) {
                                category = it
                                expanded = false
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
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable { onSelect(title) }) {
        Text(text = title)
    }
}