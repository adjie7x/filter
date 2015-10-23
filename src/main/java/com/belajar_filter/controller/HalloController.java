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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/hallo")
public class HalloController {
    
    private static final Logger log = LoggerFactory.getLogger(HalloController.class);
    
    @RequestMapping(method = RequestMethod.GET, value = "/says")
    public Map<String, Object> sayHallo(@RequestParam("name") String name){
        log.info("info name : "+name);
        Map<String, Object> dto = new HashMap<>();        
        dto.put("message", "Hallo "+name);
        return dto;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/logout/success")
    public Map<String, Object> successLogOut(){
        log.info("success logout");
        Map<String, Object> dto = new HashMap<>();        
        dto.put("message", "success logout");
        return dto;
    }
    
}
