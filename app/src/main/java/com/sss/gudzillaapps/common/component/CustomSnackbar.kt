package com.sss.gudzillaapps.common.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sss.gudzillaapps.common.data.SnackbarType
import com.sss.gudzillaapps.common.model.SnackbarData
import com.sss.gudzillaapps.common.theme.Blue
import com.sss.gudzillaapps.common.theme.BodyPopMedium
import com.sss.gudzillaapps.common.theme.LightRed
import com.sss.gudzillaapps.common.theme.Primary
import com.sss.gudzillaapps.common.theme.Red


@Composable
fun CustomSnackbar(
    data: SnackbarData,
    onDismiss: () -> Unit,
) {
    val (bgColor, icon) = when (data.type) {
        SnackbarType.SUCCESS -> Primary to Icons.Default.CheckCircle
        SnackbarType.INFO -> Blue to Icons.Default.Info
        SnackbarType.ERROR -> Red to Icons.Default.Close
    }

    AnimatedVisibility(
        visible = true,
        enter = slideInVertically { it } + fadeIn(),
        exit = slideOutVertically { it } + fadeOut()
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(12.dp),
            color = bgColor
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = Color.White
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    style = BodyPopMedium,
                    text = data.message,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )

                if (data.actionLabel != null && data.onAction != null) {
                    Spacer(modifier = Modifier.width(8.dp))
                    TextButton(onClick = {
                        data.onAction.invoke()
                        onDismiss()
                    }) {
                        Text(
                            data.actionLabel.uppercase(),
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}