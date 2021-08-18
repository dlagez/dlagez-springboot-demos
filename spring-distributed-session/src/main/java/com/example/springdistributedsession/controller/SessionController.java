package com.example.springdistributedsession.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/session")
public class SessionController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/set")
    public void set(HttpSession session, @RequestParam("key") String key,
                    @RequestParam("value") String value) {
        session.setAttribute(key, value);
        System.out.println(key+": "+value);
    }

    @GetMapping("/get_all")
    public Map<String, Object> getAll(HttpSession session) {
        Map<String, Object> result = new HashMap<>();
        // 遍历
        for (Enumeration<String> enumeration = session.getAttributeNames();
        enumeration.hasMoreElements();) {
            String key = enumeration.nextElement();
            Object value = session.getAttribute(key);
            System.out.println("result add :" + key + ": " + value);
            result.put(key, value);
        }
        return result;
    }


}
