/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar_filter.config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author ASUS
 */
@Component
public class GeneralFilterConfig implements Filter{
    
    private static final Logger log = LoggerFactory.getLogger(GeneralFilterConfig.class);

    
    FilterConfig filterConfig = null;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.debug("initiate general filter config");
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
        log.debug("execute do filter ... ");
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        
        String getParam = req.getParameter("name");
        log.debug("intercept param : "+getParam);
        
        fc.doFilter(req, res);
        
        
    }

    @Override
    public void destroy() {
        
    }
    
}
