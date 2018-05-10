package com.hklk.website.service;

import com.hklk.website.entity.table.ItemContent;
import com.hklk.website.entity.table.UserFeedBack;

import java.util.List;

public interface FeedBackService {
    List<UserFeedBack> queryList() ;
    int deleteByPrimaryKey(Integer id);
    int insertSelective(UserFeedBack userFeedBack);
    int updateByPrimaryKeySelective(UserFeedBack userFeedBack);
}
