package com.eCommerce.shopping_cart.repository;

import com.eCommerce.shopping_cart.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String role);
}
