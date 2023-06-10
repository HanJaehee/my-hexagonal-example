package com.hindsight.myhexagonalexample.port.out

import com.hindsight.myhexagonalexample.domain.Purchase

interface CreatePurchasePort {

    suspend fun createPurchase(productId: Long, amount: Long, buyerId: Long): Purchase
}