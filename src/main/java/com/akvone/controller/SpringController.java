package com.akvone.controller;

import com.akvone.entity.JSONUserData;
import com.akvone.router.UserDataRouter;
import com.akvone.service.HistoryRecordService;
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

    @Autowired
    private HistoryRecordService historyRecordService;

    @Autowired
    private UserDataRouter userDataRouter;

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
        model.addAttribute("userCount",historyRecordService.getUserCountByLocationId(locationId));
        model.addAttribute("genreTop", historyRecordService.getGenreTop(locationId));
        return "start";

    }*/

}