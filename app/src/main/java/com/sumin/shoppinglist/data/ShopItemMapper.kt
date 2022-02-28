package com.sumin.shoppinglist.data

import com.sumin.shoppinglist.data.database.ShopItemEntity
import com.sumin.shoppinglist.domain.ShopItem


fun ShopItem.toShopItemEntity(): ShopItemEntity = ShopItemEntity(
    id = id,
    name = name,
    count = count,
    enabled = enabled
)

fun ShopItemEntity.toShopItem(): ShopItem = ShopItem(
    id = id,
    name = name,
    count = count,
    enabled = enabled
)

fun List<ShopItemEntity>.toShopItemList(): List<ShopItem> = map { it.toShopItem() }
