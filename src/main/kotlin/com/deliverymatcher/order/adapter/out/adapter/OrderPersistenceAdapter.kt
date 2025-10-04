package com.deliverymatcher.order.adapter.out.adapter

import com.deliverymatcher.order.adapter.out.mapper.OrderMapper
import com.deliverymatcher.order.adapter.out.repository.OrderJpaRepository
import com.deliverymatcher.order.application.port.out.OrderOutPort
import com.deliverymatcher.order.domain.Order
import org.springframework.stereotype.Component

@Component
class OrderPersistenceAdapter(
    private val orderJpaRepository : OrderJpaRepository,
    private val orderMapper : OrderMapper
) : OrderOutPort {
    override fun save(order: Order): Order {
        val orderEntity = orderMapper.toEntity(order)
        val savedEntity = orderJpaRepository.save(orderEntity)
        return orderMapper.toDomain(savedEntity)
    }
}