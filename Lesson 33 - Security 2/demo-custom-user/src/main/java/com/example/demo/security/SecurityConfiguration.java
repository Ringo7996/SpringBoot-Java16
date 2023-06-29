package com.example.demo.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true
)
@AllArgsConstructor
public class SecurityConfiguration {
    private final UserDetailsService userDetailsService;
    private final CustomFilter customFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);

        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        String[] PUBLIC_ROUTE = {"/", "/api/v1/auth/**","/login"};
        http
                .csrf(c -> c.disable())
                .authorizeHttpRequests((authz) -> authz
                                .requestMatchers(PUBLIC_ROUTE).permitAll()
//                        .requestMatchers("POST", "/cc").hasRole("ADMIN")
//                        .requestMatchers("/").permitAll()
//                        .requestMatchers("/profile").hasAnyRole("ADMIN", "AUTHOR")
//                        .requestMatchers("/admin").hasRole("ADMIN")
//                        .requestMatchers("/author").hasRole("AUTHOR")
//                        .requestMatchers("/cc").hasAuthority("ROLE_SALE")
                                .anyRequest().authenticated()
                )
//                .formLogin((form) -> form
//                        .loginPage("/login-process")
//                        .usernameParameter("email")
//                        .passwordParameter("pass")
//                        .loginProcessingUrl("/login-process")
//                        .defaultSuccessUrl("/", true)
//                        .permitAll()
//                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/")
                        .permitAll()
                )
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}