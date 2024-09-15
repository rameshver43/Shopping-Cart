package com.eCommerce.shopping_cart.service.user;

import com.eCommerce.shopping_cart.dto.UserDto;
import com.eCommerce.shopping_cart.exceptions.AlreadyExistsException;
import com.eCommerce.shopping_cart.exceptions.ResourceNotFoundException;
import com.eCommerce.shopping_cart.model.User;
import com.eCommerce.shopping_cart.repository.UserRepository;
import com.eCommerce.shopping_cart.request.CreateUserRequest;
import com.eCommerce.shopping_cart.request.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found!"));
    }

    @Override
    public UserDto createUser(CreateUserRequest request) {
        if(!userRepository.existsByEmail(request.getEmail())) {
            User user = new User();
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setEmail(request.getEmail());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            return convertToUserDto(userRepository.save(user));
        }
        else
        {
            throw new AlreadyExistsException("Oops! " + request.getEmail() +"already exists!");
        }
    }

    @Override
    public UserDto updateUser(UserUpdateRequest request, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found!"));
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        return convertToUserDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found!"));
        userRepository.delete(user);
    }

    @Override
    public UserDto convertToUserDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        return userRepository.findByEmail(email);
    }
}
