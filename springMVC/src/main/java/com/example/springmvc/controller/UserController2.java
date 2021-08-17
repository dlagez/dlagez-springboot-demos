package com.example.springmvc.controller;

import com.example.springmvc.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users2")
public class UserController2 {

    @GetMapping("list")
    public List<UserVO> list() {
        List<UserVO> result = new ArrayList<>();
        result.add(new UserVO(1, "roczhang"));
        result.add(new UserVO(2, "dlage"));
        result.add(new UserVO(3, "cccc"));
        return result;
    }

    @GetMapping("/get")
    public UserVO get(@RequestParam("id") Integer id) {
        return new UserVO(id, UUID.randomUUID().toString());
    }
}
