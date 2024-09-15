package com.eCommerce.shopping_cart.service.user;

import com.eCommerce.shopping_cart.dto.UserDto;
import com.eCommerce.shopping_cart.model.User;
import com.eCommerce.shopping_cart.request.CreateUserRequest;
import com.eCommerce.shopping_cart.request.UserUpdateRequest;

public interface IUserService {
    User getUserById(Long userId);
    UserDto createUser(CreateUserRequest request);
    UserDto updateUser(UserUpdateRequest request, Long userId);
    void deleteUser(Long userId);

    UserDto convertToUserDto(User user);

    User getAuthenticatedUser();
}
