package com.hindsight.myhexagonalexample.port.`in`

import com.hindsight.myhexagonalexample.domain.Product

interface ProductGetPort {

    suspend fun getProductList(): List<Product>
}