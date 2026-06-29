package com.sss.gudzillaapps.feature.inbound.presentation.create_inbound.component.field

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import com.sss.gudzillaapps.R
import com.sss.gudzillaapps.common.component.CustomFloatingActionButton
import com.sss.gudzillaapps.common.component.CustomTextField
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.common.theme.Gray


@Composable
fun PalletInboundField(
    textTitle: String,
    textHint: String,
    value: String,
    leadingIcon: Int,
    onChange: (String) -> Unit,
    onScanClick: () -> Unit,
    focusManager: FocusManager,
) {

    Text(
        text = textTitle,
        style = BodyPopBold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = Dimens.ExtraExtraSmallCornerRadius)
    )
    Spacer(Modifier.height(Dimens.ExtraExtraSmallMargin))

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        CustomTextField(
            value = value,
            forceUppercase = true,
            onValueChange = onChange,
            hint = textHint,
            leadingIcon = {
                Icon(
                    painter = painterResource(leadingIcon),
                    contentDescription = "Icon Employee Id",
                    tint = Gray
                )
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Characters
            ),
            onNext = { focusManager.moveFocus(FocusDirection.Down) },
            modifier = Modifier.weight(1f)
        )

        Spacer(Modifier.width(5.dp))

        CustomFloatingActionButton(
            imageVector = Icons.Default.QrCodeScanner,
            onClick = onScanClick
        )
    }
}