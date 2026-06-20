package com.sss.gudzillaapps.feature.inbound.data.model

data class HeaderTransactionPallet(
    val idTransaction: String,
    val idPallet: String,
    val locationPallet: String,
    val listPurchaseOrder: List<PurchaseOrder>,
)

val listHeaderTransaction = listOf(
    HeaderTransactionPallet(
        idTransaction = "TRNO-00181098-JHL00",
        idPallet = "PLT-008916",
        locationPallet = "STR01",
        listPurchaseOrder = listPo
    ),

    HeaderTransactionPallet(
        idTransaction = "TRNO-00181098-JKL00",
        idPallet = "PLT-108996",
        locationPallet = "STR02",
        listPurchaseOrder = listPo
    )
)

