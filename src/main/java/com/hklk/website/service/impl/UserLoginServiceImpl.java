package com.hklk.website.service.impl;

import com.hklk.website.dao.inter.OperatingUserMapper;
import com.hklk.website.entity.table.OperatingUser;
import com.hklk.website.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    OperatingUserMapper operatingUserMapper;

    @Override
    public OperatingUser userLogin(String name, String password) {
        Map<String,String> params = new HashMap<>();
        params.put("username",name);
        params.put("password",password);
        return operatingUserMapper.selectByNameAndPassword(params);
    }
}
