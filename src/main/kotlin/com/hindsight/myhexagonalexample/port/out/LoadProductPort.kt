package com.hindsight.myhexagonalexample.port.out

import com.hindsight.myhexagonalexample.domain.Product

interface LoadProductPort {

    suspend fun loadProductList(): List<Product>

    suspend fun loadProduct(id: Long): Product?
}