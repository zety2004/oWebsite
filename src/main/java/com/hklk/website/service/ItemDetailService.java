package com.hklk.website.service;

import com.hklk.website.entity.table.ItemDetail;
import com.hklk.website.entity.vo.PageTableForm;

import java.util.List;

public interface ItemDetailService {
    PageTableForm<ItemDetail> queryItemDetailList(Integer itemId, Integer pageNum, Integer numPerPage);
    ItemDetail selectItemDetailById(Integer id);
    int updateByPrimaryKeySelective(ItemDetail record);
    int insertSelective(ItemDetail record);
    int deleteByPrimaryKey(Integer id);

}
