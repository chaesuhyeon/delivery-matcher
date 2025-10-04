package com.deliverymatcher.order.adapter.`in`.mapper

import com.deliverymatcher.order.adapter.`in`.dto.OrderRequestDto
import com.deliverymatcher.order.adapter.`in`.dto.OrderResponseDto
import com.deliverymatcher.order.domain.Order
import org.springframework.stereotype.Component

@Component
class OrderDtoMapper {

    // DTO -> Domain
    fun toDomain(dto: OrderRequestDto): Order {
        return Order.create(
            memberId = dto.memberId,
            productId = dto.productId,
            totalAmount = dto.totalAmount
        )
    }

    // Domain -> DTO
    fun toResponseDto(order: Order): OrderResponseDto {
        return OrderResponseDto.of(
            id = order.id,
            memberId = order.memberId,
            productId = order.productId,
            totalAmount = order.totalAmount,
            orderStatus = order.getStatus()
        )
    }
}