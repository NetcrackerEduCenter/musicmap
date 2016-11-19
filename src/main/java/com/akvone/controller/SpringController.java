package com.akvone.controller;

import com.akvone.entity.User;
import com.akvone.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Random;

/**
 * Created by Kirill on 04.11.2016.
 */

@Controller
@RequestMapping("")
@Validated
public class SpringController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String getPersons(Model model) {
        return "start";
    }

    @RequestMapping(value="add_user", method = RequestMethod.POST)
    @ResponseBody
    public void addBrowserInfo(ModelMap model){
        User user = new User();
        user.setVkId(new Random().nextLong());
        user.setId(new Random().nextLong());
        userServiceImpl.add(user);
//        model.addAttribute("message","success");
        System.out.println("User added");
    }

}