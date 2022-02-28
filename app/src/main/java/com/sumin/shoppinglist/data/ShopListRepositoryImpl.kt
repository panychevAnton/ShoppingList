package com.sumin.shoppinglist.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import com.sumin.shoppinglist.data.database.ShopItemDb
import com.sumin.shoppinglist.domain.ShopItem
import com.sumin.shoppinglist.domain.ShopListRepository

class ShopListRepositoryImpl(
    application: Application
) : ShopListRepository {

    private val shopItemDao = ShopItemDb.getInstance(application).shopItemDao()

    override suspend fun addShopItem(shopItem: ShopItem) {
        shopItemDao.addShopItem(shopItem.toShopItemEntity())
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
        shopItemDao.deleteShopItem(shopItem.id)
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        shopItemDao.addShopItem(shopItem.toShopItemEntity())
    }

    override suspend fun getShopItem(shopItemId: Int): ShopItem =
        shopItemDao.getShopItem(shopItemId).toShopItem()


    override fun getShopList(): LiveData<List<ShopItem>> = Transformations.map(
        shopItemDao.getShopItemList()
    ) {
        it.toShopItemList()
    }

}
