package com.hklk.website.entity.table;

import java.io.Serializable;

public class ItemContent implements Serializable {
    private Integer id;

    private String itemName;

    private Integer orderLev;

    private Integer isTop;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Integer getOrderLev() {
        return orderLev;
    }

    public void setOrderLev(Integer orderLev) {
        this.orderLev = orderLev;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }
}