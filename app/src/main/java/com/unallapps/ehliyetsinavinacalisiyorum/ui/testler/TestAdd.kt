package com.unallapps.ehliyetsinavinacalisiyorum.ui.testler

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestAdd(modifier: Modifier, testAddViewModel: testAddViewModel = hiltViewModel()) {
    val testId = remember { mutableStateOf("") }
    val content = remember { mutableStateOf("") }
    val a = remember { mutableStateOf("") }
    val b = remember { mutableStateOf("") }
    val c = remember { mutableStateOf("") }
    val d = remember { mutableStateOf("") }
    val correct = remember { mutableStateOf("") }
    Column(modifier = modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.Top,
        Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(label = { Text(text = "TestId") }, value = testId.value, onValueChange = { testId.value = it })
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(label = { Text(text = "Soru") }, value = content.value, onValueChange = { content.value = it })
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(label = { Text(text = "a") }, value = a.value, onValueChange = { a.value = it })
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(label = { Text(text = "b") }, value = b.value, onValueChange = { b.value = it })
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(label = { Text(text = "c") }, value = c.value, onValueChange = { c.value = it })
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(label = { Text(text = "d") }, value = d.value, onValueChange = { d.value = it })
        Spacer(modifier = Modifier.padding(5.dp))
        TextField(label = { Text(text = "cevap") }, value = correct.value, onValueChange = { correct.value = it })
        Spacer(modifier = Modifier.padding(5.dp))
        Button(onClick = {
            testAddViewModel.addTest(a.value,
                b.value,
                c.value,
                d.value,
                content.value,
                correct.value,
                testId = testId.value)
            a.value = ""
            b.value = ""
            c.value = ""
            d.value = ""
            testId.value = ""
            content.value = ""
            correct.value = ""
        }) {}
    }
}