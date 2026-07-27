package com.sss.gudzillaapps.feature.login.presentation

import android.Manifest
import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.sss.gudzillaapps.R
import com.sss.gudzillaapps.common.component.BackgroundGradient
import com.sss.gudzillaapps.common.component.card.CustomFloating3DCard
import com.sss.gudzillaapps.common.device.presentation.DeviceViewModel
import com.sss.gudzillaapps.common.helper.RequestAppPermissions
import com.sss.gudzillaapps.common.manager.SnackbarManager
import com.sss.gudzillaapps.common.model.SnackbarData
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.feature.login.presentation.component.LoginFooter
import com.sss.gudzillaapps.feature.login.presentation.component.LoginForm
import com.sss.gudzillaapps.feature.login.presentation.component.LoginHeader
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@SuppressLint("LocalContextGetResourceValueCall")
@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun LoginScreen(
    deviceViewModel: DeviceViewModel = koinViewModel(),
    onSuccessLogin: () -> Unit,
    onSettingConnection: () -> Unit,
) {

    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val clipboardManager = LocalClipboardManager.current
    val scope = rememberCoroutineScope()

    val deviceId by deviceViewModel.deviceId.observeAsState("")
    var employeeId by remember { mutableStateOf("") }

    RequestAppPermissions(
        onPermissionDenied = { permission ->
            scope.launch {
                SnackbarManager.showSnackbar(
                    SnackbarData(
                        message = context.getString(
                            permissionMessageRes(permission)
                        )
                    )
                )
            }
        }
    )

    BackgroundGradient {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = Dimens.SmallMargin)
                .imePadding(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(
                modifier = Modifier.weight(1f)
            )

            LoginHeader()

            Spacer(
                modifier = Modifier.height(40.dp)
            )

            CustomFloating3DCard(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                LoginForm(
                    deviceId = deviceId,
                    employeeId = employeeId,
                    onEditEmployeeId = { employeeId = it },
                    focusManager = focusManager,
                    onClickConnection = onSettingConnection,
                    onClickLogin = onSuccessLogin,
                    onCopyDeviceId = {
                        clipboardManager.setText(AnnotatedString(deviceId))
                        scope.launch {
                            SnackbarManager.showSnackbar(
                                SnackbarData("Device id berhasil di copy")
                            )
                        }
                    }
                )
            }

            Spacer(
                modifier = Modifier.weight(1f)
            )

            LoginFooter()
        }
    }

}

@StringRes
fun permissionMessageRes(permission: String): Int {
    return when (permission) {
        Manifest.permission.CAMERA ->
            R.string.text_permission_camera

        Manifest.permission.READ_MEDIA_IMAGES,
        Manifest.permission.READ_EXTERNAL_STORAGE,
            ->
            R.string.text_permission_gallery

        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
            ->
            R.string.text_permission_location

        Manifest.permission.POST_NOTIFICATIONS ->
            R.string.text_permission_notification

        else ->
            R.string.text_permission_denied
    }
}