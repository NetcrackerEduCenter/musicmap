package com.akvone.service.impl;

import com.akvone.dao.SingerDAO;
import com.akvone.entity.Singer;
import com.akvone.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nikitafedorovv on 26/11/2016.
 */

@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerDAO singerDAO;

    public Singer add(String name) {
        Singer singer;
        if (singerDAO.exists(name)){
            singer = singerDAO.getByName(name);
        } else {
            singer = new Singer();
            singer.setName(name);
        }

        singerDAO.save(singer);
        return singerDAO.getByName(name);
    }
}
