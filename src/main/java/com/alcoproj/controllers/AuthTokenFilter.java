package com.alcoproj.controllers;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alcoproj.model.UserCredentials;
import com.alcoproj.service.UserCredentialsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {
    private UserCredentialsService userCredentialsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        UsernamePasswordAuthenticationToken token = mapper.readValue(request.getHeader("Authorization"),
                UsernamePasswordAuthenticationToken.class);
        UserCredentials credentials = userCredentialsService.getByEmail(token.getName());
        if (credentials != null && credentials.getPassword().equals(token.getCredentials())) {
            filterChain.doFilter(request, response);
        }
    }

}