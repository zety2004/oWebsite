package com.hklk.website.service;

import com.hklk.website.entity.table.ItemDetail;

import java.util.List;

public interface ItemDetailService {
    List<ItemDetail> queryItemDetailList(Integer itemId);
    ItemDetail selectItemDetailById(Integer id);
    int updateByPrimaryKeySelective(ItemDetail record);
    int insertSelective(ItemDetail record);
    int deleteByPrimaryKey(Integer id);

}
