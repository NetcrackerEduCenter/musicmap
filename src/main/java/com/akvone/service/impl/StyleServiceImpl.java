package com.akvone.service.impl;

import com.akvone.dao.StyleDAO;
import com.akvone.entity.Style;
import com.akvone.service.StyleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StyleServiceImpl implements StyleService {

    @Autowired
    private StyleDAO styleDAO;

    @Override
    public Style getById(Long id){
        if (styleDAO.exists(id)) return styleDAO.getById(id);
        else {
            System.out.println();
            System.out.println("Style have not been found in database (styleID = " + id + ")");
            return null;
        }
    }

}
