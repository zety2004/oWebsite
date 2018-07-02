package com.hklk.website.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hklk.website.dao.inter.ItemContentMapper;
import com.hklk.website.entity.table.ItemContent;
import com.hklk.website.entity.vo.PageTableForm;
import com.hklk.website.service.ItemService;
import com.hklk.website.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemContentMapper itemContentMapper;

    @Override
    public PageTableForm<ItemContent> queryItemList(Integer pageNum, Integer pageSize) {
        Page page = PageHelper.startPage(pageNum, pageSize, true);
        System.out.println("page before" + JsonUtil.toJson(page));
        itemContentMapper.queryItems();
        System.out.println("page after" + JsonUtil.toJson(page));
        PageTableForm<ItemContent> pageTableForm = new PageTableForm<>(page);
        return pageTableForm;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return itemContentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(ItemContent itemContent) {
        return itemContentMapper.insertSelective(itemContent);
    }

    @Override
    public int updateByPrimaryKeySelective(ItemContent itemContent) {
        return itemContentMapper.updateByPrimaryKeySelective(itemContent);
    }

    @Override
    public ItemContent selectItemById(Integer id) {
        return itemContentMapper.selectByPrimaryKey(id);
    }
}
