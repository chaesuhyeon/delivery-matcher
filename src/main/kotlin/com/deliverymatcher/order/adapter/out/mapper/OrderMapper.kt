package com.deliverymatcher.order.adapter.out.mapper

import com.deliverymatcher.order.adapter.out.entity.OrderEntity
import com.deliverymatcher.order.domain.Order
import org.springframework.stereotype.Component

@Component
class OrderMapper {

    fun toDomain(entity: OrderEntity): Order {
        return Order.create(
            memberId = entity.memberId,
            productId = entity.productId,
            totalAmount = entity.totalAmount
        ).also {
            when (entity.orderStatus) {
                "PAID" -> it.markPaid()
                "CANCELLED" -> it.markCancelled()
                else -> it.markCreated()
            }
        }
    }


    fun toEntity(domain: Order): OrderEntity {
        return OrderEntity.of(
            memberId = domain.memberId,
            productId = domain.productId,
            totalAmount = domain.totalAmount,
            orderStatus = domain.getStatus()
        )
    }
}

