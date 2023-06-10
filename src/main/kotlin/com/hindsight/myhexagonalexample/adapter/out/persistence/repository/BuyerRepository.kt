package com.hindsight.myhexagonalexample.adapter.out.persistence.repository

import com.hindsight.myhexagonalexample.adapter.out.persistence.entity.BuyerEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository


interface BuyerRepository: CoroutineCrudRepository<BuyerEntity, Long>