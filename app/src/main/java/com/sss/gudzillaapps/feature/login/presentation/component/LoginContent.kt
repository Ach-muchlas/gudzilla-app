package com.sss.gudzillaapps.feature.login.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sss.gudzillaapps.R
import com.sss.gudzillaapps.common.component.AlertType
import com.sss.gudzillaapps.common.component.CustomOutlineButton
import com.sss.gudzillaapps.common.component.CustomPrimaryButton
import com.sss.gudzillaapps.common.component.CustomTextField
import com.sss.gudzillaapps.common.component.ShowAlert
import com.sss.gudzillaapps.common.component.TextDivider
import com.sss.gudzillaapps.common.component.coloredShadow
import com.sss.gudzillaapps.common.theme.BodyBitterRegular
import com.sss.gudzillaapps.common.theme.BodyBitterSemiBold
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.common.theme.BodyPopMedium
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.common.theme.Gray
import com.sss.gudzillaapps.common.theme.Primary
import com.sss.gudzillaapps.common.theme.TitleBitterBold

@Composable
fun LoginHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.icon_app_gudzilla),
                contentDescription = null,
                modifier = Modifier.size(130.dp)
            )

            Image(
                painter = painterResource(R.drawable.icon_app_name),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 10.dp)
                    .coloredShadow(
                        color = Color(0x44C49A3C),
                        blurRadius = 16.dp,
                        offsetY = 4.dp,
                    ),
                contentScale = ContentScale.FillWidth
            )
        }

        Spacer(modifier = Modifier.height(Dimens.SmallMargin))

        Text(
            text = stringResource(R.string.text_full_name_apps),
            style = TitleBitterBold.copy(fontSize = 23.sp),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LoginForm(
    deviceId: String,
    employeeId: String,
    onEditEmployeeId: (String) -> Unit,
    focusManager: FocusManager,
    onCopyDeviceId: () -> Unit,
    onClickLogin: () -> Unit,
    onClickConnection: () -> Unit,
) {
    var isAlertVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.MediumMargin),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Welcome to", style = BodyPopMedium.copy(
                fontSize = 25.sp
            )
        )

        Row {
            Text(
                text = "Gudzilla S3", style = BodyPopBold.copy(
                    color = Primary
                ), fontSize = 25.sp
            )

            Spacer(Modifier.width(5.dp))

            Text(
                text = "Login now!", style = BodyPopMedium.copy(
                    fontSize = 25.sp
                )
            )
        }

        Spacer(Modifier.height(Dimens.MediumMargin))

        DeviceIdField(deviceId, onCopyDeviceId)

        Spacer(Modifier.height(Dimens.MediumMargin))

        EmployeeField(employeeId, onEditEmployeeId, focusManager)

        Spacer(Modifier.height(40.dp))

        CustomPrimaryButton(
            text = "Login", fontSize = Dimens.ExtraLargeFont
        ) {
            isAlertVisible = true
        }

        Spacer(Modifier.height(Dimens.MediumMargin))

        TextDivider(
            "ATAU", textStyle = BodyBitterSemiBold.copy(
                fontSize = Dimens.MediumFont, color = Gray
            )
        )

        Spacer(Modifier.height(Dimens.MediumMargin))

        CustomOutlineButton(
            text = "Konfigurasi Koneksi", onClick = onClickConnection
        )

        Spacer(Modifier.height(Dimens.MediumMargin))
    }

    if (isAlertVisible) {
        ShowAlert(
            isAlertVisible,
            "Login Berhasil",
            "Berrhasil login kamu",
            AlertType.SUCCESS,
            onDismiss = onClickLogin
        )
    }
}

@Composable
fun LoginFooter() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp, vertical = 16.dp
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Copyright © 2026 PT Saktisetia Santosa. All rights reserved",
            style = BodyBitterRegular.copy(
                fontSize = 12.sp, color = Gray
            ),
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(4.dp))

        Text(
            text = "Version 3.3.1", style = BodyBitterRegular.copy(
                fontSize = Dimens.SmallFont, color = Gray
            )
        )
    }
}

@Composable
fun DeviceIdField(
    deviceId: String,
    onCopy: () -> Unit,
) {
    Text(
        "Device ID",
        style = BodyPopBold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = Dimens.ExtraExtraSmallCornerRadius)
    )

    Spacer(Modifier.height(Dimens.ExtraExtraSmallMargin))

    CustomTextField(
        value = deviceId,
        onValueChange = {},
        hint = "",
        readOnly = true,
        textColor = Primary,
        trailingIcon = {
            IconButton(
                onClick = onCopy, modifier = Modifier.size(40.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ContentCopy,
                    contentDescription = "Copy IMEI",
                    modifier = Modifier.size(28.dp),
                    tint = Primary
                )
            }
        })
}


@Composable
fun EmployeeField(
    employeeId: String,
    onChange: (String) -> Unit,
    focusManager: FocusManager,
) {
    Text(
        text = "ID Karyawan",
        style = BodyPopBold,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = Dimens.ExtraExtraSmallCornerRadius)
    )
    Spacer(Modifier.height(Dimens.ExtraExtraSmallMargin))

    CustomTextField(
        value = employeeId,
        forceUppercase = true,
        onValueChange = onChange,
        hint = stringResource(R.string.text_input_employee_id),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Characters
        ),
        onNext = { focusManager.moveFocus(FocusDirection.Down) })
}
