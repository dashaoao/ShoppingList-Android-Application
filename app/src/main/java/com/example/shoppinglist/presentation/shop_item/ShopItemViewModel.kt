package com.example.shoppinglist.presentation.shop_item

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopListRepositoryImpl
import com.example.shoppinglist.domain.CreateShopItemUseCase
import com.example.shoppinglist.domain.GetShopItemUseCase
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.UpdateShopItemUseCase

class ShopItemViewModel : ViewModel() {
    private val repository = ShopListRepositoryImpl()

    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val createShopItemUseCase = CreateShopItemUseCase(repository)
    private val updateShopItemUseCase = UpdateShopItemUseCase(repository)

    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    private val _shopItem = MutableLiveData<ShopItem>()
    val shopItem : LiveData<ShopItem>
        get() = _shopItem

    private val _finishProcess = MutableLiveData<Unit>()
    val finishProcess : LiveData<Unit>
        get() = _finishProcess

    fun getShopItem(shopItemId: Int) {
        val item = getShopItemUseCase.getShopItem(shopItemId)
        _shopItem.value = item
    }

    fun createShopItem(inputName: String?, inputCount: String) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        if (validateInput(name, count)){
            val shopItem = ShopItem(name, count, true)
            createShopItemUseCase.createShopItem(shopItem)
            finishWork()
        }
    }

    fun updateShopItem(inputName: String?, inputCount: String) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        if (validateInput(name, count)) {
            _shopItem.value?.let {
                val item = it.copy(name = name, count = count)
                updateShopItemUseCase.updateShopItem(item)
                finishWork()
            }
        }
    }

    private fun parseName(inputName: String?): String {
        return inputName?.trim() ?: ""
    }

    private fun parseCount(inputCount: String?): Int {
        return inputCount?.trim()?.toIntOrNull() ?: 0
    }

    private fun validateInput(name: String, count: Int): Boolean {
        return if (name.isBlank()) {
            _errorInputName.value = true
            false
        }
        else if (count <= 0) {
            _errorInputCount.value = true
            false
        }
        else true
    }

    public fun resetErrorInputName(){
        _errorInputName.value = false
    }

    public fun resetErrorInputCount(){
        _errorInputCount.value = false
    }

    private fun finishWork(){
        _finishProcess.value = Unit
    }
}