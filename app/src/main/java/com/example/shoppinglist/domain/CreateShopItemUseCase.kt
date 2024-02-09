package com.example.shoppinglist.domain

class CreateShopItemUseCase(private val shopListRepository: ShopListRepository) {
    suspend fun createShopItem(shopItem: ShopItem) {
        shopListRepository.createShopItem(shopItem)
    }
}