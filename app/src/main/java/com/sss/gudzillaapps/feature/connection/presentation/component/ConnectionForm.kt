package com.sss.gudzillaapps.feature.connection.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.sss.gudzillaapps.R
import com.sss.gudzillaapps.common.component.CustomCheckbox
import com.sss.gudzillaapps.common.component.textfield.CustomDropdownTextField
import com.sss.gudzillaapps.common.component.textfield.CustomReadOnlyField
import com.sss.gudzillaapps.common.component.textfield.CustomTextField
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.feature.login.presentation.component.DeviceIdField
import com.sss.gudzillaapps.network.model.UrlModel

@Composable
fun ConnectionForm(
    isFirstTimeOpenApps: Boolean,
    deviceId: String,
    onCopyDeviceId: () -> Unit,
    systemOperation: String,
    versionApps: String,
    listUrl: List<UrlModel>,
    selectedUrl: UrlModel?,
    onUrlSelected: (UrlModel) -> Unit,
    onSave: (String) -> Unit,
    onClickToLogin: () -> Unit,
) {

    var ipA by remember { mutableStateOf("") }
    var ipB by remember { mutableStateOf("") }
    var ipC by remember { mutableStateOf("") }
    var ipD by remember { mutableStateOf("") }
    var port by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }

    val focusManager = LocalFocusManager.current

    val focusIpA = remember { FocusRequester() }
    val focusIpB = remember { FocusRequester() }
    val focusIpC = remember { FocusRequester() }
    val focusIpD = remember { FocusRequester() }
    val focusPort = remember { FocusRequester() }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.SmallMargin),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(Dimens.SmallMargin))

        DeviceIdField(deviceId, onCopyDeviceId)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(Dimens.MediumMargin)
        ) {
            CustomReadOnlyField(
                title = "Sistem Operasi",
                value = systemOperation,
                modifier = Modifier.weight(1.5f)
            )

            CustomReadOnlyField(
                title = "Versi Aplikasi",
                value = versionApps,
                modifier = Modifier.weight(1f)
            )
        }


        Spacer(Modifier.height(Dimens.MediumMargin))

        Text(
            text = stringResource(R.string.text_server_name),
            style = BodyPopBold,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(Dimens.ExtraExtraSmallMargin))


        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomCheckbox(
                checked = checked, onCheckedChange = { checked = it })

            Spacer(modifier = Modifier.width(Dimens.ExtraSmallMargin))

            CustomDropdownTextField(
                label = "Pilih Koneksi",
                items = listUrl,
                selectedItem = selectedUrl,
                enabled = checked,
                onItemSelected = {
                    onUrlSelected(it)
                },
                itemText = { it.urlName })
        }

        if (selectedUrl?.urlName == "Lainnya") {

            Spacer(Modifier.height(Dimens.MediumMargin))

            Row {
                IpTextField(
                    value = ipA,
                    hint = "202",
                    focusRequester = focusIpA,
                    nextFocus = focusIpB,
                    onValueChangeState = { ipA = it },
                    modifier = Modifier.weight(1f)
                )

                Spacer(Modifier.width(Dimens.ExtraSmallMargin))

                IpTextField(
                    value = ipB,
                    hint = "1",
                    focusRequester = focusIpB,
                    nextFocus = focusIpC,
                    onValueChangeState = { ipB = it },
                    modifier = Modifier.weight(1f)
                )

                Spacer(Modifier.width(Dimens.ExtraSmallMargin))

                IpTextField(
                    value = ipC,
                    hint = "133",
                    focusRequester = focusIpC,
                    nextFocus = focusIpD,
                    onValueChangeState = { ipC = it },
                    modifier = Modifier.weight(1f)
                )

                Spacer(Modifier.width(Dimens.ExtraSmallMargin))

                IpTextField(
                    value = ipD,
                    hint = "202",
                    focusRequester = focusIpD,
                    nextFocus = focusPort,
                    onValueChangeState = { ipD = it },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(Modifier.height(Dimens.SmallMargin))

            CustomTextField(
                value = port,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                hint = "202",
                onValueChange = { newValue ->
                    if (newValue.all { it.isDigit() }) {
                        port = newValue
                    }
                },
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        }

    }
}