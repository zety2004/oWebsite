package com.hklk.website.service.impl;

import com.hklk.website.dao.inter.ItemContentMapper;
import com.hklk.website.entity.table.ItemContent;
import com.hklk.website.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemContentMapper itemContentMapper;

    @Override
    public List<ItemContent> queryItemList() {
        return itemContentMapper.queryItems();
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
