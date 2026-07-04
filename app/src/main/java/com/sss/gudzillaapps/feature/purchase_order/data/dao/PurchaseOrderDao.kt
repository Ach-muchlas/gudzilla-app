package com.sss.gudzillaapps.feature.purchase_order.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.sss.gudzillaapps.feature.purchase_order.data.entity.PurchaseOrderEntity

@Dao
interface PurchaseOrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPurchaseOrder(data: PurchaseOrderEntity)

}