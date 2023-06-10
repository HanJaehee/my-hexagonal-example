package com.hindsight.myhexagonalexample.port.out

import com.hindsight.myhexagonalexample.domain.Buyer

interface LoadBuyerPort {

    suspend fun loadBuyer(id: Long): Buyer?
}