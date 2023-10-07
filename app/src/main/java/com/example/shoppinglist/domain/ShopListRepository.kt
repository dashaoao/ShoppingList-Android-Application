package com.example.shoppinglist.domain

import com.example.shoppinglist.data.ShopItem

interface ShopListRepository {
    fun createShopItem(shopItem: ShopItem)
    fun updateShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: Int) : ShopItem
    fun getShopList() : List<ShopItem>
}