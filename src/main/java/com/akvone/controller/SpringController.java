package com.akvone.controller;

//import com.akvone.entity.Bank;
//import com.akvone.service.implementation.BankServiceImpl;
import com.akvone.entity.StartInfo;
import com.akvone.service.StartInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Kirill on 04.11.2016.
 */
@Controller
@RequestMapping("")
@Validated
public class SpringController {
    @Autowired
    private StartInfoService startInfoService;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String getPersons(Model model) {
        return "start";
    }


    @RequestMapping(value="add_start_info", method = RequestMethod.POST)
    @ResponseBody
    public void addBrowserInfo(ModelMap model){
        startInfoService.addStartInfo(new StartInfo());
        model.addAttribute("message","success");
        System.out.println("CHECK THIS");
    }

}