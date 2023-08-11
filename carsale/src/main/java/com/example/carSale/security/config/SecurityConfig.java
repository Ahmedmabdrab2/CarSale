package com.example.carSale.security.config;

import com.example.carSale.security.filter.AuthenticationFilter;
import com.example.carSale.security.filter.ExceptionHandlerFilter;
import com.example.carSale.security.filter.JWTAuthorizationFilter;
import com.example.carSale.security.manager.CustomAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.SessionManagementConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.*;

@AllArgsConstructor
@Configuration
public class SecurityConfig {

    private final CustomAuthenticationManager customAuthenticationManager;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
        authenticationFilter.setFilterProcessesUrl("/authenticate");
          http
                  .headers().frameOptions().disable() // for h2 console
                  .and()
                  .csrf().disable()
                  .authorizeRequests()
                  .antMatchers("/h2/**").permitAll() //  h2 console without the need to authenticate.
                  .antMatchers(HttpMethod.POST, SecurityConstants.REGISTER_PATH).permitAll()
                  .anyRequest().authenticated()
                  .and()
                  .addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
                  .addFilter(authenticationFilter)
                  .addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
                  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
                }



}


