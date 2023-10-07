package com.example.shoppinglist.domain

import com.example.shoppinglist.data.ShopItem

class CreateShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun createShopItem(shopItem: ShopItem) {
        shopListRepository.createShopItem(shopItem)
    }
}