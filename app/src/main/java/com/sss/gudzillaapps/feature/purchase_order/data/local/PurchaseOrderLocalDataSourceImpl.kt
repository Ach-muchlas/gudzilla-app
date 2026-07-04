package com.sss.gudzillaapps.feature.purchase_order.data.local

import com.sss.gudzillaapps.feature.purchase_order.data.dao.PurchaseOrderDao
import com.sss.gudzillaapps.feature.purchase_order.data.entity.PurchaseOrderEntity

class PurchaseOrderLocalDataSourceImpl(private val dao: PurchaseOrderDao) : PurchaseOrderLocalDataSource {
    override suspend fun insertPurchaseOrder(po: PurchaseOrderEntity) {
        dao.insertPurchaseOrder(po)
    }
}