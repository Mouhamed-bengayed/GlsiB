package com.example.glsib.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final String[] PUBLIC_ENDPOINTS={
            "/api/customer/*",

    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
   http
        .cors().and().csrf().disable()
        .sessionManagement()
           .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
        .authorizeRequests()
           .antMatchers(PUBLIC_ENDPOINTS).permitAll()
        .anyRequest().authenticated()
        .and()
   .httpBasic();
}
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER  )
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
