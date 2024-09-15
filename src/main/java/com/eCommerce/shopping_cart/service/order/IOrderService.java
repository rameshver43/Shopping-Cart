package com.eCommerce.shopping_cart.service.order;

import com.eCommerce.shopping_cart.dto.OrderDto;
import com.eCommerce.shopping_cart.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IOrderService {
    OrderDto placeOrder(Long userId);
    OrderDto getOrder(Long orderId);

    List<OrderDto> getUserOrders(Long userId);
}
