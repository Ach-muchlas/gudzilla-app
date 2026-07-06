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

)