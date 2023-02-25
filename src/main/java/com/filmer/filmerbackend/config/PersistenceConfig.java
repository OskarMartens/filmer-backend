package com.filmer.filmerbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.filmer.filmerbackend.repositories"})
public class PersistenceConfig {
}

/*

.authorizeHttpRequests()
.requestMatchers("/", "/login", "/error", "rest/**", "/register", "/static/**").permitAll()
.request("/admin").hasRole("ADMIN")
.authenticated()
.and()
.formLogin(
    formLogin -> {
        formLogin
            .loginPage("/login");
    }
   )


 */