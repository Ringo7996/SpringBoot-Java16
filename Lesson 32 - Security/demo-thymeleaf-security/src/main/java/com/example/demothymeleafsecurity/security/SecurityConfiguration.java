package com.example.demothymeleafsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        String[] PUBLIC_ROUTE = {"/"};
        http
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
                .formLogin((form) -> form
                        .loginPage("/login")
                        .usernameParameter("email")
                        .passwordParameter("pass")
                        .loginProcessingUrl("/login-process")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/")
                        .permitAll());

        return http.build();
    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("111")
                .roles("USER","ADMIN")
                .build();

        UserDetails author = User.withDefaultPasswordEncoder()
                .username("author")
                .password("111")
                .roles("USER","AUTHOR")
                .build();


        return new InMemoryUserDetailsManager(admin, author);
    }

}