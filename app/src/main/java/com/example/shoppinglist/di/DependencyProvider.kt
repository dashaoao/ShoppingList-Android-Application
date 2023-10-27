package com.example.shoppinglist.di

import com.example.shoppinglist.data.ShopListRepositoryImpl

object DependencyProvider {
    val shopListRepository = ShopListRepositoryImpl()
}