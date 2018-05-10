package com.hklk.website.service.impl;

import com.hklk.website.dao.inter.ItemContentMapper;
import com.hklk.website.dao.inter.UserFeedBackMapper;
import com.hklk.website.entity.table.ItemContent;
import com.hklk.website.entity.table.UserFeedBack;
import com.hklk.website.service.FeedBackService;
import com.hklk.website.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    UserFeedBackMapper userFeedBackMapper;
    @Override
    public List<UserFeedBack> queryList() {
        return userFeedBackMapper.queryList();
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userFeedBackMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(UserFeedBack userFeedBack) {
        return userFeedBackMapper.insertSelective(userFeedBack);
    }

    @Override
    public int updateByPrimaryKeySelective(UserFeedBack userFeedBack) {
        return userFeedBackMapper.updateByPrimaryKeySelective(userFeedBack);
    }

}
