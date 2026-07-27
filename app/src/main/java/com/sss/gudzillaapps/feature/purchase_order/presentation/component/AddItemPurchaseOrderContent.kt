package com.sss.gudzillaapps.feature.purchase_order.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.sss.gudzillaapps.common.component.CustomInformationCard
import com.sss.gudzillaapps.common.component.CustomTopBar
import com.sss.gudzillaapps.common.component.card.CustomFloating3DCard
import com.sss.gudzillaapps.common.theme.BackgroundLayout
import com.sss.gudzillaapps.common.theme.Dimens

@Composable
fun AddItemPurchaseOrderContent() {

    val focusManager = LocalFocusManager.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLayout)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.MediumMargin),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTopBar(title = "Item PO", onBackClick = {})
            Spacer(Modifier.height(Dimens.LargeMargin))
            CustomInformationCard(
                title = "Proses Inbound",
                description = "Silahkan lengkapi informasi header inbound dibawah ini. Gunakan scan untuk akurasi data lebih cepat."
            )
            Spacer(Modifier.height(Dimens.LargeMargin))
            CustomFloating3DCard{
                AddItemPurchaseOrderForm(focusManager = focusManager)
            }

            Text("M")
        }
    }
}