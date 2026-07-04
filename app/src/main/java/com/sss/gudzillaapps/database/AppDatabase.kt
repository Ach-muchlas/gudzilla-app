package com.sss.gudzillaapps.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sss.gudzillaapps.feature.purchase_order.data.dao.PurchaseOrderDao
import com.sss.gudzillaapps.feature.purchase_order.data.entity.PurchaseOrderEntity


@Database(
    entities = [PurchaseOrderEntity::class], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun purchaserOrderDao(): PurchaseOrderDao

    companion object {
        const val DB_NAME = "app_database"
    }
}
