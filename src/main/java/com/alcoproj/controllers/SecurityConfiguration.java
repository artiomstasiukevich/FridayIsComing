package com.alcoproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    AuthTokenFilter filter;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/private", "/users").hasRole("ADMIN")
                .antMatchers("/private/**").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .and()
                .httpBasic();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}pass")
                .roles("ADMIN");
    }

    @Bean
    public FilterRegistrationBean<OncePerRequestFilter> loggingFilter(){
        FilterRegistrationBean<OncePerRequestFilter> registrationBean
                = new FilterRegistrationBean<>();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/users/*");

        return registrationBean;
    }
}