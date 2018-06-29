package com.hklk.website.service;

import com.hklk.website.entity.table.ItemContent;
import com.hklk.website.entity.vo.PageTableForm;

import java.util.List;

public interface ItemService {
    PageTableForm<ItemContent> queryItemList(Integer pageNum, Integer pageSize) ;
    int deleteByPrimaryKey(Integer id);
    int insertSelective(ItemContent itemContent);
    int updateByPrimaryKeySelective(ItemContent itemContent);
    ItemContent selectItemById(Integer id);
}
