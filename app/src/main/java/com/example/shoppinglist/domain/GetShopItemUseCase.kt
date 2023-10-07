package com.example.shoppinglist.domain

import com.example.shoppinglist.data.ShopItem

class GetShopItemUseCase (private val shopListRepository: ShopListRepository){
    fun getShopItem(shopItemId : Int) : ShopItem{
        return shopListRepository.getShopItem(shopItemId)
    }
}