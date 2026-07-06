package com.sss.gudzillaapps.feature.purchase_order.domain.repository

import com.sss.gudzillaapps.feature.purchase_order.data.entity.PurchaseOrderEntity

interface PurchaseOrderRepository {
    suspend fun insertPurchaseOrder(po: PurchaseOrderEntity)
}