package com.sss.gudzillaapps.feature.purchase_order.domain.repository

import com.sss.gudzillaapps.feature.purchase_order.data.entity.PurchaseOrderEntity
import com.sss.gudzillaapps.feature.purchase_order.data.local.PurchaseOrderLocalDataSource

class PurchaseOrderRepositoryImpl(private val local: PurchaseOrderLocalDataSource) :
    PurchaseOrderRepository {
    override suspend fun insertPurchaseOrder(po: PurchaseOrderEntity) {
        local.insertPurchaseOrder(po)
    }
}