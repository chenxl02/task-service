package com.wkb.robot.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author yilu
 * @Date 2018/10/9 17:33
 **/
@Controller
@RequestMapping("/home")
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
