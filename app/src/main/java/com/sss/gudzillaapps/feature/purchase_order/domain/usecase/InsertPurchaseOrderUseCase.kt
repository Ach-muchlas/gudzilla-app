package com.sss.gudzillaapps.feature.purchase_order.domain.usecase

import com.sss.gudzillaapps.feature.purchase_order.data.entity.PurchaseOrderEntity
import com.sss.gudzillaapps.feature.purchase_order.domain.repository.PurchaseOrderRepository

class InsertPurchaseOrderUseCase(private val repository: PurchaseOrderRepository) {
    suspend operator fun invoke(po: PurchaseOrderEntity) {
        repository.insertPurchaseOrder(po)
    }
}