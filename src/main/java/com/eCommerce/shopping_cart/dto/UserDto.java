package com.eCommerce.shopping_cart.dto;
import com.eCommerce.shopping_cart.model.Cart;
import com.eCommerce.shopping_cart.model.Order;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<OrderDto> orders;
    private CartDto cart;
}
