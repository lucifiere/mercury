package com.atlandes.erp.po;

public class Price {

    //货物编号
    private Integer id;
    //货物名称
    private String itemsName;
    //货物单位
    private String itemsUnit;
    //货物税率
    private Integer itemsTax;
    //货物成本单价
    private Integer itemsCost;
    //货物加工运输单价
    private Integer itemsAddTranCost;
    //货物库存量
    private Integer itemsStoreCounts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemsName() {
        return itemsName;
    }

    public void setItemsName(String itemsName) {
        this.itemsName = itemsName;
    }

    public String getItemsUnit() {
        return itemsUnit;
    }

    public void setItemsUnit(String itemsUnit) {
        this.itemsUnit = itemsUnit;
    }

    public Integer getItemsTax() {
        return itemsTax;
    }

    public void setItemsTax(Integer itemsTax) {
        this.itemsTax = itemsTax;
    }

    public Integer getItemsCost() {
        return itemsCost;
    }

    public void setItemsCost(Integer itemsCost) {
        this.itemsCost = itemsCost;
    }

    public Integer getItemsAddTranCost() {
        return itemsAddTranCost;
    }

    public void setItemsAddTranCost(Integer itemsAddTranCost) {
        this.itemsAddTranCost = itemsAddTranCost;
    }

    public Integer getItemsStoreCounts() {
        return itemsStoreCounts;
    }

    public void setItemsStoreCounts(Integer itemsStoreCounts) {
        this.itemsStoreCounts = itemsStoreCounts;
    }
}
