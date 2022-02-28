package com.sumin.shoppinglist.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ShopItemEntity::class], version = 1, exportSchema = false)
abstract class ShopItemDb : RoomDatabase() {

    abstract fun shopItemDao(): ShopItemDao

    companion object {

        private var INSTANCE: ShopItemDb? = null
        private val LOCK = Any()
        private const val DB_NAME = "shop_item_db"

        fun getInstance(application: Application): ShopItemDb {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    ShopItemDb::class.java,
                    DB_NAME
                ).build()
                INSTANCE = db
                return db
            }
        }
    }
}