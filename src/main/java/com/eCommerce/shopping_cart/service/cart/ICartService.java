package com.eCommerce.shopping_cart.service.cart;

import com.eCommerce.shopping_cart.model.Cart;
import com.eCommerce.shopping_cart.model.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCart(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);
    Cart intializeNewCart(User user);

    Cart getCartByUserId(Long userId);
}
