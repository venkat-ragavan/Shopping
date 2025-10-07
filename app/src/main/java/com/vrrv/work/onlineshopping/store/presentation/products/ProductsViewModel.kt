package com.vrrv.work.onlineshopping.store.presentation.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vrrv.work.onlineshopping.store.domain.repo.ProductRepo
import com.vrrv.work.onlineshopping.store.presentation.util.sendEvent
import com.vrrv.work.onlineshopping.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productRepo: ProductRepo
): ViewModel() {

    private val _state = MutableStateFlow(ProductsViewState())
    val state = _state.asStateFlow()

    init {
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            productRepo.getProducts()
                .onRight { products ->
                    _state.update { it.copy(products = products) }
                }
                .onLeft { error ->
                    _state.update { it.copy(error = error.error.message) }
                    sendEvent(Event.Toast(error.error.message))
                }
            _state.update { it.copy(isLoading = false) }
        }
    }

}