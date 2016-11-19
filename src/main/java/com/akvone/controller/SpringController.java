package com.akvone.controller;

import com.akvone.entity.JSONUserData;
import com.akvone.service.HistoryService;
import com.akvone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private UserService userService;
    private HistoryService historyService;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String sendStartPage(Model model) {
        return "start";
    }

    @PostMapping(value = "/add_user")
    public ResponseEntity receiveJSONUserData(@RequestBody JSONUserData jsonUserData) {

        System.out.println("Received from client: " + jsonUserData);

        return new ResponseEntity(jsonUserData, HttpStatus.OK);
    }

    /*@RequestMapping(value = "/top", method = RequestMethod.GET)
    public String sendTopStat(@RequestPart ("locationID") Long locationId, Model model){
        model.addAttribute("userCount",historyService.getUserCountByLocationId(locationId));
        model.addAttribute("genreTop", historyService.getGenreTop(locationId));
        return "start";

    }*/

}