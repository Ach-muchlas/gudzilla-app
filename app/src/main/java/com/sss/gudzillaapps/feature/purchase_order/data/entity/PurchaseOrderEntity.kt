package com.sss.gudzillaapps.feature.purchase_order.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sss.gudzillaapps.common.helper.GenerateString

@Entity(tableName = "purchase_order_table")
data class PurchaseOrderEntity(
    @PrimaryKey val id: String = GenerateString.generateRandomId(),
    val idPoInServer : String,
    val companyName : String,
    val itemName : String,
    val qtyItem : String,
    val expDate : String
)