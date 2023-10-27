package com.example.shoppinglist.domain

class UpdateShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun updateShopItem(shopItem: ShopItem) {
        shopListRepository.updateShopItem(shopItem)
    }
}