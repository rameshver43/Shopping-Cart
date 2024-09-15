package com.eCommerce.shopping_cart.data;

import com.eCommerce.shopping_cart.model.User;
import com.eCommerce.shopping_cart.model.Role;
import com.eCommerce.shopping_cart.repository.RoleRepository;
import com.eCommerce.shopping_cart.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Transactional
public class DataInitializer implements ApplicationListener<ApplicationReadyEvent> {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Set<String> roles = Set.of("ROLE_ADMIN", "ROLE_USER");
        createDefaultUserIfNotExists();
        CreateDefaultRoleIfNotExists(roles);
        createDefaultAdminIfNotExists();
    }

    private void createDefaultUserIfNotExists() {

        Role userRole = roleRepository.findByName("ROLE_USER");
        for(int i=0;i<5;i++)
        {
            String defaultEmail = "user"+i+"@email.com";
            if(userRepository.existsByEmail(defaultEmail))
                continue;
            User user = new User();
            user.setEmail(defaultEmail);
            user.setFirstName("The User");
            user.setLastName("User" + i);
            user.setRoles(Set.of(userRole));
            user.setPassword(passwordEncoder.encode("password"));
            userRepository.save(user);
            System.out.println("Default user " + i + " created");
        }
    }

    private void createDefaultAdminIfNotExists() {
        Role adminRole = roleRepository.findByName("ROLE_ADMIN");
        for(int i=0;i<5;i++)
        {
            String defaultEmail = "admin"+i+"@email.com";
            if(userRepository.existsByEmail(defaultEmail))
                continue;
            User user = new User();
            user.setEmail(defaultEmail);
            user.setFirstName("Admin");
            user.setLastName("Admin" + i);
            user.setRoles(Set.of(adminRole));
            user.setPassword(passwordEncoder.encode("password"));
            userRepository.save(user);
            System.out.println("Default admin user " + i + " created");
        }
    }

    private void CreateDefaultRoleIfNotExists(Set<String> roles) {

        for(String role: roles)
        {
            Role newRole = roleRepository.findByName(role);
            if(newRole == null)
            {
                newRole = new Role(role);
                roleRepository.save(newRole);
            }
        }
    }
}
