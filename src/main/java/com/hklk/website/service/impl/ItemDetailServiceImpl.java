package com.hklk.website.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hklk.website.dao.inter.ItemDetailMapper;
import com.hklk.website.entity.table.ItemDetail;
import com.hklk.website.entity.vo.PageTableForm;
import com.hklk.website.service.ItemDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemDetailServiceImpl implements ItemDetailService {

    @Autowired
    ItemDetailMapper itemDetailMapper;

    @Override
    public PageTableForm<ItemDetail> queryItemDetailList(Integer itemId, Integer pageNum, Integer numPerPage) {
        Page page = PageHelper.startPage(pageNum, numPerPage, true);
        itemDetailMapper.queryItemDetails(itemId);
        PageTableForm<ItemDetail> pageTableForm = new PageTableForm<>(page);
        return pageTableForm;
    }

    @Override
    public int updateByPrimaryKeySelective(ItemDetail record) {
        return itemDetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertSelective(ItemDetail record) {
        return itemDetailMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return itemDetailMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ItemDetail selectItemDetailById(Integer id) {
        return itemDetailMapper.selectByPrimaryKey(id);
    }
}
