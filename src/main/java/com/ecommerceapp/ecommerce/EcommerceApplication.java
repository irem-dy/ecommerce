package com.ecommerceapp.ecommerce;

import com.ecommerceapp.ecommerce.entity.User;
import com.ecommerceapp.ecommerce.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@Bean
	public CommandLineRunner createAdminUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (userRepository.findByUsername("adminuser").isEmpty()) {
				User admin = new User();
				admin.setUsername("adminuser");
				admin.setPassword(passwordEncoder.encode("adminpassword"));
				admin.setRole("ADMIN");
				userRepository.save(admin);
				System.out.println("✅ Admin kullanıcı oluşturuldu.");
			} else {
				System.out.println("ℹ️ Admin kullanıcı zaten mevcut.");
			}
		};
	}
}
