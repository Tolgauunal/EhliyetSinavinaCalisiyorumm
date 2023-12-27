package com.unallapps.ehliyetsinavinacalisiyorum.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.unallapps.ehliyetsinavinacalisiyorum.R

@Composable
fun CustomButton(title: String, onClick: () -> Unit) {
    Button(onClick = { onClick },
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.acikmavi))) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()) {
            Icon(painter = painterResource(id = R.drawable.home), contentDescription = "")
            Text(text = title, color = colorResource(id = R.color.kapaliMavi))
            Icon(painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                contentDescription = "",
                tint = colorResource(id = R.color.kapaliMavi))
        }
    }
}