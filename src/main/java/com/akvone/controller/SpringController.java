package com.akvone.controller;

import com.akvone.entity.JSONUserData;
import com.akvone.service.HistoryRecordService;
import com.akvone.service.RouterService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

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
        //model.addAttribute("userCount",historyRecordService.getUserCountByLocationId(locationId));
        //model.addAttribute("genreTop", historyRecordService.getStyleTop(locationId));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userCount",historyRecordService.getUserCountByLocationId(locationId));
        JSONArray jsonArray = new JSONArray();
        for (Object s : historyRecordService.getStyleTop(locationId).toArray()){
            jsonArray.add(s.toString());
        }
        jsonObject.put("topStyles",jsonArray);
        return jsonObject.toJSONString();
    }

}