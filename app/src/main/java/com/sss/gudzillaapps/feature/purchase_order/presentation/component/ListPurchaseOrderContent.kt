package com.sss.gudzillaapps.feature.purchase_order.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sss.gudzillaapps.common.component.CustomTopBar
import com.sss.gudzillaapps.common.theme.BackgroundLayout
import com.sss.gudzillaapps.common.theme.Dimens
import com.sss.gudzillaapps.feature.purchase_order.data.entity.PurchaseOrderEntity

@Composable
fun ListPurchaseOrderContent(
    onAddItem: () -> Unit,
) {

    val dataPurchaseOrder = listOf(
        PurchaseOrderEntity(
            idPoInServer = "PO-100292017-CUI",
            companyName = "Japan Rie",
            qtyItem = "180",
            itemName = "Luwak",
            expDate = "2026-06-09"
        ),

    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLayout)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.MediumMargin),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            CustomTopBar(title = "List PO", onBackClick = {  })

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(Dimens.MediumMargin),
                contentPadding = PaddingValues(
                    top = Dimens.MediumMargin,
                    bottom = Dimens.MediumMargin
                )
            ) {
                items(dataPurchaseOrder) { item ->
                    CardPurchaseOrder(data = item, onClick = onAddItem)
                }
            }
        }
    }
}