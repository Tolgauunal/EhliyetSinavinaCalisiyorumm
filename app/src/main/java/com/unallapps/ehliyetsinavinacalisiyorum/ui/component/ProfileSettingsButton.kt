package com.unallapps.ehliyetsinavinacalisiyorum.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unallapps.ehliyetsinavinacalisiyorum.R

@Composable
fun ProfileSettingsButton(
    textResId: Int,
    iconResId: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.acikmavi)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )

            Text(
                text = stringResource(textResId),
                color = colorResource(id = R.color.kapaliMavi),
                fontSize = 15.sp
            )

            Icon(
                painter = painterResource(id = R.drawable.baseline_keyboard_arrow_right_24),
                contentDescription = null,
                tint = colorResource(id = R.color.kapaliMavi)
            )
        }
    }
}

@Preview
@Composable
fun LessonButtonPreview() {
    ProfileSettingsButton(
        textResId = R.string.report_Error,
        iconResId = R.drawable.ilkyardim,
        onClick = {}
    )
}