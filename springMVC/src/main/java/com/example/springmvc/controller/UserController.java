package com.example.springmvc.controller;

import com.example.springmvc.vo.UserVO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("")
   public List<UserVO> list() {
        List<UserVO> result = new ArrayList<>();
        result.add(new UserVO(1, "roczhang"));
        result.add(new UserVO(2, "dlage"));
        result.add(new UserVO(3, "cccc"));
        return result;
    }

    @GetMapping("/{id}")
    public UserVO get(@PathVariable("id") Integer id) {
        return new UserVO(4, "username" + id);
    }
}
