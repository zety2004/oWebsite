package com.hklk.website.dao.inter;

import com.hklk.website.entity.table.ItemContent;

import java.util.List;

public interface ItemContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemContent record);

    int insertSelective(ItemContent record);

    ItemContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemContent record);

    int updateByPrimaryKey(ItemContent record);

    List<ItemContent> queryItems();
}