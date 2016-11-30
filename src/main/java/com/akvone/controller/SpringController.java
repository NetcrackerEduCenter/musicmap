package com.akvone.controller;

import com.akvone.entity.JSONUserData;
import com.akvone.service.RouterService;
import com.akvone.service.HistoryRecordService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.LogManager;

@Controller
@RequestMapping("")
@Validated
public class SpringController {

    @Autowired
    private HistoryRecordService historyRecordService;

    @Autowired
    private RouterService routerService;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String sendStartPage(Model model) {
        return "start";
    }

    @PostMapping(value = "/add_user")
    public ResponseEntity receiveJSONUserData(@RequestBody JSONUserData jsonUserData) {

//        long time = System.currentTimeMillis();

        routerService.route(jsonUserData);
        System.out.println("Received from client: " + jsonUserData);

//        System.out.println();
//        System.out.println(System.currentTimeMillis() - time + " ms");

        return new ResponseEntity(jsonUserData, HttpStatus.OK);
    }

    @RequestMapping(value = {"/regStat"}, method = RequestMethod.GET)
    @ResponseBody
    public String search(@RequestParam ("locationId") Long locationId, ModelMap model) {
        //why u don't use it? (by MM)
        //model.addAttribute("userCount",historyRecordService.getUserCountByLocationId(locationId));
        //model.addAttribute("genreTop", historyRecordService.getStyleTop(locationId));

        return "{\"userCount\":"
                +historyRecordService.getUserCountByLocationId(locationId)
                +",\"topStyles\":"
                +historyRecordService.getStyleTop(locationId)
                +"}";
    }

}