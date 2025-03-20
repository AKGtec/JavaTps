package com.pfe.AllTheTps.Interceptors;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;


import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class UrlInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws
            Exception {
        log.debug("Process Pre-action");
        return true;
    }
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, @Nullable
                           ModelAndView modelAndView) throws Exception {
        log.debug("Process Post-action");
    }
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, @Nullable
                                Exception ex) throws Exception {
        log.debug("Process after-completion");
    }
}
