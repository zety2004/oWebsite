package com.hklk.website.entity.vo;

import com.hklk.website.entity.table.ItemContent;
import com.hklk.website.entity.table.ItemDetail;

import java.io.Serializable;
import java.util.List;

    public class ItemVo implements Serializable {
        private Integer id;

        private String itemName;

        private Integer orderLev;

        private Integer isTop;

        private List<ItemDetail> itemDetails;

        private static final long serialVersionUID = 1L;

        public ItemVo(ItemContent itemContent, List<ItemDetail> itemDetails) {
            this.id = itemContent.getId();
            this.itemName = itemContent.getItemName();
            this.orderLev = itemContent.getOrderLev();
            this.isTop = itemContent.getIsTop();
            this.itemDetails = itemDetails;
        }

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

        public List<ItemDetail> getItemDetails() {
            return itemDetails;
        }

        public void setItemDetails(List<ItemDetail> itemDetails) {
            this.itemDetails = itemDetails;
        }

        public Integer getIsTop() {
            return isTop;
        }

        public void setIsTop(Integer isTop) {
            this.isTop = isTop;
        }
    }
