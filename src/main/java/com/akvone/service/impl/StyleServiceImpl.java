package com.akvone.service.impl;

import com.akvone.dao.StyleDAO;
import com.akvone.entity.Style;
import com.akvone.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nikitafedorovv on 26/11/2016.
 */

@Service
public class StyleServiceImpl implements StyleService {

    @Autowired
    private StyleDAO styleDAO;

    @Override
    public Style getByName(String name){
        return styleDAO.getByName(name);
    }

    @Override
    public Style getById(Long id){
        return styleDAO.getById(id);
    }

}
