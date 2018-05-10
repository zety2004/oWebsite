package com.hklk.website.dao.inter;

import com.hklk.website.entity.table.UserFeedBack;

import java.util.List;

public interface UserFeedBackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserFeedBack record);

    int insertSelective(UserFeedBack record);

    UserFeedBack selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserFeedBack record);

    int updateByPrimaryKeyWithBLOBs(UserFeedBack record);

    int updateByPrimaryKey(UserFeedBack record);

    List<UserFeedBack> queryList() ;
}