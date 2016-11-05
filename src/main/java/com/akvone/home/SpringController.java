package com.akvone.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Kirill on 04.11.2016.
 */
@Controller
@RequestMapping("/start")
public class SpringController {

    @RequestMapping(value = "", method = RequestMethod.GET)

    public String getPersons(Model model) {
        return "start";
    }
}