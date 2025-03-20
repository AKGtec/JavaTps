package com.pfe.AllTheTps.filters;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Enumeration;

@WebFilter("/*")
@Slf4j
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response, FilterChain filterChain) throws
            IOException, ServletException {
        loggingRequest((HttpServletRequest)request);
        filterChain.doFilter(request,response);
    }
    private void loggingRequest(HttpServletRequest request) {
        log.debug("** URI : {} ",request.getRequestURI());
        log.debug("** Method: {} ",request.getMethod());
        loggingHeaders(request);
    }
    private void loggingHeaders(HttpServletRequest request) {
        Enumeration<String> names = request.getHeaderNames();
        while(names.hasMoreElements()){
            String name=names.nextElement();
            String value = request.getHeader(name);
            log.debug("** Header {} value {} ",name,value);
        }
    }
}