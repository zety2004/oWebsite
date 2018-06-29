package com.hklk.website.service;

import com.hklk.website.entity.table.UserFeedBack;
import com.hklk.website.entity.vo.PageTableForm;

public interface FeedBackService {
    PageTableForm<UserFeedBack> queryList(Integer pageNum,Integer pageSize) ;
    int deleteByPrimaryKey(Integer id);
    int insertSelective(UserFeedBack userFeedBack);
    int updateByPrimaryKeySelective(UserFeedBack userFeedBack);
}
