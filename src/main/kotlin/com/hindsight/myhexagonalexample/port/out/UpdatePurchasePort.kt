package com.hindsight.myhexagonalexample.port.out

import com.hindsight.myhexagonalexample.domain.Purchase

interface UpdatePurchasePort {
    suspend fun updatePurchase(purchase: Purchase): Purchase
}