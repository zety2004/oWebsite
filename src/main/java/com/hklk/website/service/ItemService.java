package com.hklk.website.service;

import com.hklk.website.entity.table.ItemContent;

import java.util.List;

public interface ItemService {
    List<ItemContent> queryItemList() ;
    int deleteByPrimaryKey(Integer id);
    int insertSelective(ItemContent itemContent);
    int updateByPrimaryKeySelective(ItemContent itemContent);
    ItemContent selectItemById(Integer id);
}
