package com.atlandes.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by XD.Wang on 2017/6/7.
 * 主页
 */
@Controller
@RequestMapping("admin")
public class IndexController {

    @RequestMapping("index")
    public ModelAndView toIndexPage() {
        ModelAndView mv = new ModelAndView("admin/index");
        return mv;
    }

}
