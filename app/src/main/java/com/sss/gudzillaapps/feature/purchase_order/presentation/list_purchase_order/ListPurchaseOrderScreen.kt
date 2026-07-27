package com.sss.gudzillaapps.feature.purchase_order.presentation.list_purchase_order

import androidx.compose.runtime.Composable
import com.sss.gudzillaapps.feature.purchase_order.presentation.component.ListPurchaseOrderContent

@Composable
fun ListPurchaseOrderScreen(onAddItemPurchaseOrder : () -> Unit ) {
    ListPurchaseOrderContent(onAddItem = onAddItemPurchaseOrder)
}