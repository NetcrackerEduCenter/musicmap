package com.akvone.service;

import com.akvone.dao.IStartInfoDAO;
import com.akvone.entity.StartInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StartInfoService implements IStartInfoService {
    @Autowired
    private IStartInfoDAO initialInformationDAO;

    @Override
    public boolean addStartInfo(StartInfo startInfo) {
        initialInformationDAO.addStartInfo(startInfo);
        return true;
    }
}
