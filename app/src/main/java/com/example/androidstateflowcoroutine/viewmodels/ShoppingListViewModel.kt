package com.example.androidstateflowcoroutine.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ShoppingListViewModel : ViewModel() {

    private val _shoppingList = MutableStateFlow<List<String>>(emptyList())
    // StateFlow is a type of Flow that represents a read-only state with a single updatable data value that emits updates to the value to its collectors.
    val shoppingList: StateFlow<List<String>> = _shoppingList

    fun addItem(item: String) {
        // viewModelScope is a built-in coroutine scope for the ViewModel. It lives as long as the ViewModel lives.
        viewModelScope.launch {
            _shoppingList.value = _shoppingList.value + item
        }
    }

    fun removeItem(item: String) {
        viewModelScope.launch {
            _shoppingList.value = _shoppingList.value.filter { it != item }
        }
    }
}
