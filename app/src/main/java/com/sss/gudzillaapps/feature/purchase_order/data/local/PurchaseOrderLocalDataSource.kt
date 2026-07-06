package com.sss.gudzillaapps.feature.purchase_order.data.local

import com.sss.gudzillaapps.feature.purchase_order.data.entity.PurchaseOrderEntity

interface PurchaseOrderLocalDataSource {
    suspend fun insertPurchaseOrder(po: PurchaseOrderEntity)
}