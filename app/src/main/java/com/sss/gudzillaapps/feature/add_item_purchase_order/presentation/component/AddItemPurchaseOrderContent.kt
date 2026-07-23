package com.sss.gudzillaapps.feature.add_item_purchase_order.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.sss.gudzillaapps.common.component.CustomTopBar
import com.sss.gudzillaapps.common.theme.BackgroundLayout
import com.sss.gudzillaapps.common.theme.Dimens

@Composable
fun AddItemPurchaseOrderContent(
    idPo: String,

    ) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.SmallMargin)
            .background(BackgroundLayout)
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTopBar("Item PO", )
        }
    }
}