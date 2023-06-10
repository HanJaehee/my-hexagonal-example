package com.hindsight.myhexagonalexample.port.`in`

import com.hindsight.myhexagonalexample.domain.Purchase

interface PurchaseUpdatePort {

    suspend fun updatePurchaseAmount(id: Long, amount: Long): Purchase
}