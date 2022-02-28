package com.sumin.shoppinglist.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "shop_items_table")
data class ShopItemEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val count: Int,
    val enabled: Boolean
)
