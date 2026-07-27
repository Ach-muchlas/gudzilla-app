package com.sss.gudzillaapps.common.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.common.theme.BodyPopRegular
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.common.theme.Gray
import com.sss.gudzillaapps.common.theme.Primary

@Composable
fun CustomInformationCard(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Outlined.Info,
    iconBackground: Color = Primary.copy(alpha = 0.08f),
    iconTint: Color = Primary,
    backgroundColor: Color = Color(0xFFFFFCF5),
    borderColor: Color = Primary.copy(alpha = 0.25f)
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(Dimens.LargeCornerRadius),
        color = backgroundColor,
        border = BorderStroke(1.dp, borderColor)
    ) {

        Row(
            modifier = Modifier.padding(Dimens.MediumMargin),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(iconBackground),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconTint,
                    modifier = Modifier.size(24.dp)

                )
            }

            Spacer(modifier = Modifier.width(Dimens.MediumMargin))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title.uppercase(),
                    style = BodyPopBold.copy(fontSize = Dimens.MediumFont)
                )
                Spacer(Modifier.height(Dimens.ExtraExtraSmallMargin))
                Text(
                    text = description,
                    style = BodyPopRegular.copy(fontSize = Dimens.SmallFont),
                    color = Gray
                )
            }
        }
    }

}
