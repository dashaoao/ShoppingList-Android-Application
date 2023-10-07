package com.example.shoppinglist.domain

import com.example.shoppinglist.data.ShopItem

class UpdateShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun updateShopItem( shopItem: ShopItem ) {
        shopListRepository.updateShopItem(shopItem)
    }
}