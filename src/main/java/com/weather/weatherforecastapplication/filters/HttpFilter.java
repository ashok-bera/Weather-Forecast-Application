package com.weather.weatherforecastapplication.filters;

import com.weather.weatherforecastapplication.constants.EnvVariables;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Objects;

@Component
public class HttpFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String authHeader = httpServletRequest.getHeader(EnvVariables.AUTH_HEADER_KEY);

        if(!isValidUser(authHeader)) {
            throw new RemoteException("Auth Exception. Invalid User.");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isValidUser(String authHeader) {
        if (Objects.isNull(authHeader) || Objects.equals(authHeader, ""))
            return Boolean.FALSE;
        return Boolean.TRUE;
    }
}
