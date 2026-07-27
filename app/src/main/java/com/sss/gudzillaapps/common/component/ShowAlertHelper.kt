package com.sss.gudzillaapps.common.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.sss.gudzillaapps.R
import com.sss.gudzillaapps.common.component.button.CustomPrimaryButton
import com.sss.gudzillaapps.common.theme.BodyBitterMedium
import com.sss.gudzillaapps.common.theme.BodyPopBold
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.common.theme.White


// ─────────────────────────────────────────────
// 1. Tipe alert yang tersedia
// ─────────────────────────────────────────────
enum class AlertType {
    SUCCESS,
    ERROR,
    LOADING
}

// ─────────────────────────────────────────────
// 2. Data class konfigurasi tiap tipe alert
//    → ganti R.raw.xxx dengan file Lottie kamu
// ─────────────────────────────────────────────
data class AlertConfig(
    val lottieRes: Int,
    val iterations: Int,           // LottieConstants.IterateForever untuk loop
    val buttonText: String,
    val isDismissible: Boolean,     // Loading = false, lainnya = true
)

// Sesuaikan nama file raw Lottie kamu di sini
private fun resolveConfig(type: AlertType): AlertConfig = when (type) {
    AlertType.SUCCESS -> AlertConfig(
        lottieRes = R.raw.animation_success,   // ← ganti sesuai file kamu
        iterations = LottieConstants.IterateForever,
        buttonText = "Selesai",
        isDismissible = true
    )

    AlertType.ERROR -> AlertConfig(
        lottieRes = R.raw.animation_error,     // ← ganti sesuai file kamu
        iterations = LottieConstants.IterateForever,
        buttonText = "Tutup",
        isDismissible = true
    )

    AlertType.LOADING -> AlertConfig(
        lottieRes = R.raw.animation_success,   // ← ganti sesuai file kamu
        iterations = LottieConstants.IterateForever,
        buttonText = "",
        isDismissible = false
    )
}

// ─────────────────────────────────────────────
// 3. Komponen utama — inilah yang dipanggil
//    di screen kamu
// ─────────────────────────────────────────────
/**
 * Penggunaan:
 *
 *  ShowAlert(
 *      show       = showDialog,
 *      title      = "Berhasil Disimpan",
 *      desc       = "RCV-250S16-0001",
 *      type       = AlertType.SUCCESS,
 *      onDismiss  = { showDialog = false }
 *  )
 */
@Composable
fun ShowAlert(
    show: Boolean,
    title: String,
    desc: String,
    type: AlertType,
    onDismiss: () -> Unit = {},
) {
    if (!show) return

    val config = resolveConfig(type)

    Dialog(
        onDismissRequest = { if (config.isDismissible) onDismiss() },
        properties = DialogProperties(
            dismissOnBackPress = config.isDismissible,
            dismissOnClickOutside = config.isDismissible
        )
    ) {
        AlertContent(
            title = title,
            desc = desc,
            config = config,
            onButton = onDismiss
        )
    }
}

// ─────────────────────────────────────────────
// 4. Isi dialog (internal)
// ─────────────────────────────────────────────
@Composable
private fun AlertContent(
    title: String,
    desc: String,
    config: AlertConfig,
    onButton: () -> Unit,
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(config.lottieRes)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = config.iterations
    )

    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 28.dp)
        ) {
            // Animasi Lottie
            LottieAnimation(
                composition = composition,
                progress = { progress },
                modifier = Modifier.size(100.dp)
            )

            Spacer(Modifier.height(Dimens.MediumMargin))

            // Title — tampil hanya jika bukan Loading
            if (title.isNotBlank() && config.isDismissible) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    style = BodyPopBold,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(6.dp))
            }

            // Desc
            if (desc.isNotBlank()) {
                Text(
                    text = desc,
                    fontSize = 13.sp,
                    style = BodyBitterMedium,
                    textAlign = TextAlign.Center
                )
            }

            // Tombol — sembunyikan saat Loading
            if (config.isDismissible) {
                Spacer(Modifier.height(24.dp))
                CustomPrimaryButton(text = config.buttonText, onClick = onButton)
            }
        }
    }
}