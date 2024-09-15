package com.eCommerce.shopping_cart.service.cart;

import com.eCommerce.shopping_cart.model.CartItem;

public interface ICartItemService {
     void addItem(Long cartId, Long productId, int quantity);
     void removeItem(Long cartId, Long productId);
     void updateItemQuantity(Long cartId, Long productId, int quantity);

    CartItem getCartItem(Long cartId, Long productId);
}
