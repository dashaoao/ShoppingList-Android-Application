package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface ShopListRepository {
    suspend fun createShopItem(shopItem: ShopItem)
    suspend fun updateShopItem(shopItem: ShopItem)
    suspend fun deleteShopItem(shopItem: ShopItem)
    suspend fun getShopItem(shopItemId: Int) : ShopItem
    fun getShopList() : LiveData<List<ShopItem>>
}