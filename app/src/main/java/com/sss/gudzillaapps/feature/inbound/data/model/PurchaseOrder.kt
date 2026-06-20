package com.sss.gudzillaapps.feature.inbound.data.model

data class PurchaseOrder(
    val idPo: String,
    val companyName: String,
    val items: List<ItemPurchaseOrder>,
)

val listPo = listOf(
    PurchaseOrder(
        idPo = "PO-0018120382",
        companyName = "Cakra Buana Timur",
        items = listItem
    )
)