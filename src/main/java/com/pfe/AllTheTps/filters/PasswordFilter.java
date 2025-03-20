package com.pfe.AllTheTps.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;

@WebFilter
@Slf4j
public class PasswordFilter implements Filter {
    private final PasswordEncoder passwordEncoder;
    public PasswordFilter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void doFilter(ServletRequest request,ServletResponse response, FilterChain filterChain) throws
            IOException, ServletException {
        String password = ((HttpServletRequest)
                request).getParameter("password");
        if (password != null) {
            log.debug("password encode 1 : {} ",
                    passwordEncoder.encode(password));
            log.debug("password encode 2 : {} ",
                    passwordEncoder.encode(password));
            filterChain.doFilter(request, response);
        } else {
            log.error("Password missed. The filter chain is stopped !! ");
            filterChain.doFilter(request, response);
        }
    }
}
