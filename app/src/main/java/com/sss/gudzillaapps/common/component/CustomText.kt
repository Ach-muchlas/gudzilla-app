package com.sss.gudzillaapps.common.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.sss.gudzillaapps.common.theme.Primary
import com.sss.gudzillaapps.common.theme.TitlePopBold


@Composable
fun ResponsiveTitleText(
    text: String,
    modifier: Modifier = Modifier,
    maxFontSize: TextUnit = 25.sp,
    minFontSize: TextUnit = 20.sp,
) {
    var fontSize by remember { mutableStateOf(maxFontSize) }
    var isReady by remember { mutableStateOf(false) }

    Text(
        text = text,
        maxLines = 2,
        softWrap = false,
        overflow = TextOverflow.Clip,
        style = TitlePopBold.copy(fontSize = fontSize, color = Primary),
        modifier = modifier.drawWithContent {
            if (isReady) drawContent()
        },
        onTextLayout = { result ->
            if (result.didOverflowWidth && fontSize > minFontSize) {
                fontSize *= 0.9f
            } else {
                isReady = true
            }
        }
    )
}
