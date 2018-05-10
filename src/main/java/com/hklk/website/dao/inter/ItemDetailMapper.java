package com.hklk.website.dao.inter;

import com.hklk.website.entity.table.ItemDetail;

import java.util.List;

public interface ItemDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemDetail record);

    int insertSelective(ItemDetail record);

    ItemDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemDetail record);

    int updateByPrimaryKeyWithBLOBs(ItemDetail record);

    int updateByPrimaryKey(ItemDetail record);

    List<ItemDetail> queryItemDetails(Integer item_id);
}