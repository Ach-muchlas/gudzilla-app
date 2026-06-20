package com.sss.gudzillaapps.common.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.sss.gudzillaapps.common.theme.BodyPopMedium

@Composable
fun TextDivider(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = BodyPopMedium,
    lineColor: Color = Color.Gray.copy(alpha = 0.4f),
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = lineColor
        )

        Text(
            text = text,
            style = textStyle,
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        HorizontalDivider(
            modifier = Modifier.weight(1f),
            color = lineColor
        )
    }
}