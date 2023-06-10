package com.hindsight.myhexagonalexample.port.`in`

import com.hindsight.myhexagonalexample.adapter.`in`.api.dto.PurchaseCreateDto
import com.hindsight.myhexagonalexample.domain.Purchase

interface PurchaseCreatePort {
    suspend fun createPurchase(dto: PurchaseCreateDto): Purchase
}