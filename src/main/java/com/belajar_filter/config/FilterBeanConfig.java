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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ASUS
 */
@Configuration
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

    public static Filter myFilter() {
        Filter filter = new Filter() {
            
            private ServletContext context;

            @Override
            public void init(FilterConfig filterConfig) throws ServletException {
                log.debug("initiate general filter config");
                this.context = filterConfig.getServletContext();
                this.context.log("AuthenticationFilter initialized");
            }

            @Override
            public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc) throws IOException, ServletException {
                log.debug("execute do filter ... ");
                HttpServletResponse response = (HttpServletResponse) res;
                HttpServletRequest request = (HttpServletRequest) req;

                String getParam = request.getParameter("name");
                String urlRequest = request.getRequestURI();
                log.debug("intercept url request : " + urlRequest);
                log.debug("intercept param : " + getParam);
                

                if ("aji".equals(getParam)) {
                    log.debug("is aji");
                    fc.doFilter(req, res);
                } else {
                    log.debug("is not aji");
                    response.sendError(HttpServletResponse.SC_NOT_ACCEPTABLE);
                }

            }

            @Override
            public void destroy() {

            }
        };

        return filter;
    }

}
