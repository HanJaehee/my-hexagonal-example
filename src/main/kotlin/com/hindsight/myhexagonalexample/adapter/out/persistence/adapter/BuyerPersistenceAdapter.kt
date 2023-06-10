package com.hindsight.myhexagonalexample.adapter.out.persistence.adapter

import com.hindsight.myhexagonalexample.adapter.out.persistence.repository.BuyerRepository
import com.hindsight.myhexagonalexample.adapter.out.persistence.toDomain
import com.hindsight.myhexagonalexample.common.Adapter
import com.hindsight.myhexagonalexample.domain.Buyer
import com.hindsight.myhexagonalexample.port.out.LoadBuyerPort

@Adapter
class BuyerPersistenceAdapter(
    private val buyerRepository: BuyerRepository
) : LoadBuyerPort {

    override suspend fun loadBuyer(id: Long): Buyer? =
        buyerRepository.findById(id = id)?.toDomain()

}