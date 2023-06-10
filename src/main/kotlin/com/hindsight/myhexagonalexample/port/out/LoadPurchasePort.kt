package com.hindsight.myhexagonalexample.port.out

import com.hindsight.myhexagonalexample.domain.Purchase

interface LoadPurchasePort {

    suspend fun loadPurchase(id: Long): Purchase?
}