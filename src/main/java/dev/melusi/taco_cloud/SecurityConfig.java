package dev.melusi.taco_cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        //UserDetailsService is a functional interface(single abstract method) and can
        //be implemented as a lambda instead of as a full-blown implementation class.
        return username -> {
            User user = userRepo.findByUsername(username);
            if (user != null) return user;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/design", "/orders")
                .hasRole("USER")
                .requestMatchers("/", "/**")
                .permitAll()
            )
            .build();
    }
}
