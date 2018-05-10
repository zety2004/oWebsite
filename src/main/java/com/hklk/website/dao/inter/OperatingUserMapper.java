package com.hklk.website.dao.inter;

import com.hklk.website.dao.inter.repo.MyBatisRepository;
import com.hklk.website.entity.table.OperatingUser;

import java.util.Map;

@MyBatisRepository
public interface OperatingUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OperatingUser record);

    int insertSelective(OperatingUser record);

    OperatingUser selectByPrimaryKey(Integer id);

    OperatingUser selectByNameAndPassword(Map<String,String> param);

    int updateByPrimaryKeySelective(OperatingUser record);

    int updateByPrimaryKey(OperatingUser record);
}