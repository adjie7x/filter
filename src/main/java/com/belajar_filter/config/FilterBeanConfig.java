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
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author ASUS
 */

@Configuration
@ComponentScan
@EnableWebMvc
public class FilterBeanConfig {
    
    private static final Logger log = LoggerFactory.getLogger(FilterBeanConfig.class);
    
    @Bean
    public FilterRegistrationBean addFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter());
        filterRegistrationBean.addUrlPatterns("/belajar_filter/*");
        filterRegistrationBean.setEnabled(true);
        
        return filterRegistrationBean;
    }
    
    public static Filter myFilter (){
        Filter filter = new  Filter() {
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
        };
        
        return filter;
    }
    
}
