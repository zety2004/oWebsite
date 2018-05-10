package com.hklk.website.service;

import com.hklk.website.entity.table.OperatingUser;

public interface UserLoginService {
    OperatingUser userLogin(String name, String password);
}
