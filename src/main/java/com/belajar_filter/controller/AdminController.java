/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajar_filter.controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */

@RestController
@RequestMapping("/admin")
public class AdminController {
    
    private static final Logger log = LoggerFactory.getLogger(AdminController.class);
    
    @RequestMapping(value = "/says/{name}",method = RequestMethod.GET)
    public Map<String, Object> says(@PathVariable("name") String name) {
        log.info("name : "+name);
        Map<String, Object> res = new HashMap<>();
        res.put("message", "hallo "+name);
        return res;
    }
    
}
