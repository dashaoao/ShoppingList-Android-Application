package com.example.shoppinglist.domain

interface ShopListRepository {
    fun createShopItem(shopItem: ShopItem)
    fun updateShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun getShopItem(shopItemId: Int) : ShopItem
    fun getShopList() : List<ShopItem>
}