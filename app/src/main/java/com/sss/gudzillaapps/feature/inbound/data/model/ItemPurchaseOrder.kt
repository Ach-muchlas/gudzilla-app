package com.sss.gudzillaapps.feature.inbound.data.model

data class ItemPurchaseOrder(
    val idItem: String,
    val nameItem: String,
    val qtyItem: Int,
    val expDate: String,
)

val listItem = listOf(
    ItemPurchaseOrder(
        idItem = "LWKWK0001",
        nameItem = "Luwak White Coffee",
        qtyItem = 90,
        expDate = "2027-01-09"
    ),

    ItemPurchaseOrder(
        idItem = "LWKWK0002",
        nameItem = "Luwak Coffee",
        qtyItem = 100,
        expDate = "2027-01-03"
    ),

    ItemPurchaseOrder(
        idItem = "LWKWK0001",
        nameItem = "Luwak White Coffee",
        qtyItem = 190,
        expDate = "2026-10-08"
    ),
)