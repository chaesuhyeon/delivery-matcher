package com.deliverymatcher.order.adapter.`in`.controller

import com.deliverymatcher.order.adapter.`in`.dto.OrderRequestDto
import com.deliverymatcher.order.adapter.`in`.dto.OrderResponseDto
import com.deliverymatcher.order.adapter.`in`.mapper.OrderDtoMapper
import com.deliverymatcher.order.application.port.`in`.OrderUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/orders")
@RestController
class OrderController (
    private val orderUseCase: OrderUseCase,
    private val orderDtoMapper: OrderDtoMapper
) {
    @PostMapping
    fun createOrder(@RequestBody request: OrderRequestDto): OrderResponseDto {
        val order = orderDtoMapper.toDomain(request)
        val savedOrder = orderUseCase.createOrder(order)
        return orderDtoMapper.toResponseDto(savedOrder)
    }

}