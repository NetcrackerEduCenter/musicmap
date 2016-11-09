package com.akvone.controller;

//import com.akvone.entity.Bank;
//import com.akvone.service.implementation.BankServiceImpl;
import com.akvone.entity.StartInfo;
import com.akvone.service.StartInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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

//    @RequestMapping(value = "/check", method = RequestMethod.GET)
//    public void getPersons1(Model model) {
//        System.out.println("CHECKER");
////        bankService.addBank(new Bank());
//    }

    @RequestMapping(value="add_start_info", method = RequestMethod.GET)
    public void addPerson(ModelMap model) {
        boolean flag = startInfoService.addStartInfo(new StartInfo());
        model.addAttribute(new StartInfo());
        System.out.println("CHECK THIS");
    }

}