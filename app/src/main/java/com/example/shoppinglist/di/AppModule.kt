package com.example.shoppinglist.di

import com.example.shoppinglist.data.AppDatabase
import com.example.shoppinglist.data.ShopListRepositoryImpl
import com.example.shoppinglist.domain.CreateShopItemUseCase
import com.example.shoppinglist.domain.DeleteShopItemUseCase
import com.example.shoppinglist.domain.GetShopItemUseCase
import com.example.shoppinglist.domain.GetShopListUseCase
import com.example.shoppinglist.domain.ShopListRepository
import com.example.shoppinglist.domain.UpdateShopItemUseCase
import com.example.shoppinglist.presentation.main.MainViewModel
import com.example.shoppinglist.presentation.shop_item.ShopItemViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        AppDatabase.getInstance(application = get()).shopListDao()
    }

    single<ShopListRepository> {
        ShopListRepositoryImpl(shopListDao = get())
    }

    single {
        AppDatabase.getInstance(application = androidApplication()).shopListDao()
    }

//    single {
//        AppDatabase.getInstance(application = App())
//    }
//
//    single {
//        val db: AppDatabase = get()
//        db.shopListDao()
//    }

    viewModel {
        ShopItemViewModel(
            getShopItemUseCase = get(),
            createShopItemUseCase = get(),
            updateShopItemUseCase = get(),
        )
    }

    viewModel {
        MainViewModel(
            getShopListUseCase = get(),
            deleteShopItemUseCase = get(),
            updateShopItemUseCase = get(),
        )
    }

    factory {
        GetShopListUseCase(shopListRepository = get())
    }

    factory {
        DeleteShopItemUseCase(shopListRepository = get())
    }

    factory {
        UpdateShopItemUseCase(shopListRepository = get())
    }

    factory {
        CreateShopItemUseCase(shopListRepository = get())
    }

    factory {
        GetShopItemUseCase(shopListRepository = get())
    }
}